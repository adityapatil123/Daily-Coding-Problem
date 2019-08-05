package `31-40`
/*
You have an N by N board.
Write a function that, given N,
returns the number of possible arrangements of the board where N queens can be placed on the board without threatening each other,
i.e. no two queens share the same row, column, or diagonal.
 */
fun isSafe(board: Array<Array<Boolean>>, row:Int, col:Int):Boolean{
    val n = board.size
    // Check this row on left side
    for(j in (col-1).downTo(0)){
        if(board[row][j])
            return false
    }

    // Check upper diagonal on left side
    var i = row
    var j = col
    while(i >=0 && j>=0){
        if(board[i][j])
            return false
        i--
        j--
    }

    // Check lower diagonal on left side
    i = row
    j = col
    while(i<n && j>=0){
        if(board[i][j])
            return false
        i++
        j--
    }

    return true
}

fun getQueenConfigurationsRecursive(board: Array<Array<Boolean>>, col:Int):Int
{
    val n = board.size
    var noOfPossibleArrangements = 0
    if(col >=  n)
        return 1

    for(i in 0..(n-1))
    {
        if(isSafe(board, i, col)){
            board[i][col] = true
            noOfPossibleArrangements += getQueenConfigurationsRecursive(board, col + 1)
            board[i][col] = false
        }
    }

    return noOfPossibleArrangements
}


fun getQueenConfigurationsMain(n:Int):Int
{
    val boardArrayList = ArrayList<Array<Boolean>>()

    for(i in 0..(n-1)){
        val arrayList = arrayListOf<Boolean>()
        for(j in 0..(n-1))
            arrayList.add(false)
        boardArrayList.add(arrayList.toTypedArray())
    }

    val board = boardArrayList.toTypedArray()
    return getQueenConfigurationsRecursive(board, 0)
}