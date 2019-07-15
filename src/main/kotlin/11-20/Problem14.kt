package `11-20`

//The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
//
//Hint: The basic equation of a circle is x2 + y2 = r2.


fun estimatePiByOrder(noOfTotalPts:Int):Double {
    val max = noOfTotalPts
    val end = max/2
    val rad:Double = max.toDouble()/2

    val totalPts = max*max
    var ptsInCircle = 0
    val xRange = -end..end
    val yRange = -end..end

    for (x in xRange){
        for(y in yRange){
            if(x*x + y*y <= rad*rad)
                ptsInCircle++
        }
    }

    var pi:Double = 4*ptsInCircle.toDouble()/totalPts
    pi = roundUpto3(pi)
    return pi
}

fun estimatePiRandom(noOfTotalPts:Int):Double {
    val rad = 10
    var ptsInCircle = 0

    for(i in 1..noOfTotalPts){
        val x:Double = Math.random()*rad
        val y:Double = Math.random()*rad
        if(x*x + y*y <= rad*rad)
            ptsInCircle++
    }

    var pi:Double = 4*ptsInCircle.toDouble()/noOfTotalPts
    pi = roundUpto3(pi)
    return pi
}

fun roundUpto3(num:Double):Double{
    var numMult1000 = num*1000
    numMult1000 = Math.round(numMult1000).toDouble()
    return numMult1000/1000
}