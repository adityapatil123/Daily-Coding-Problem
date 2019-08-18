package `41-50`/*
Given a array of numbers representing the stock prices of a company in chronological order,
write a function that calculates the maximum profit you could have made from buying and selling that stock once.
You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5,
since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */

fun buyAtStockPrice(stockPrices:Array<Int>):Int?
{
    if(stockPrices.size < 2)
        return null

    var minimumPrice:Int = 0
    var stockPriceAtWhichBuy:Int? = null

    stockPrices.forEachIndexed { index, price ->
        if(index == 0)
            minimumPrice = price
        else{
            if(price > minimumPrice && stockPriceAtWhichBuy!=minimumPrice)
                stockPriceAtWhichBuy = minimumPrice
            else
                minimumPrice = price
        }
    }

    return stockPriceAtWhichBuy
}