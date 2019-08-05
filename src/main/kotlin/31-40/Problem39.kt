package `31-40`/*
Conway's Game of Life takes place on an infinite two-dimensional board of square cells.
Each cell is either dead or alive, and at each tick, the following rules apply:

Any live cell with less than two live neighbours dies.
Any live cell with two or three live neighbours remains living.
Any live cell with more than three live neighbours dies.
Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life.
It should be able to be initialized with a starting list of live cell coordinates and the number of steps it should run for.
Once initialized, it should print out the board state at each step.
Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).
 */


fun getAdjacentCoordinates(x: Int, y: Int):HashSet<Pair<Int, Int>>
{
    val adjacentCoordinates = HashSet<Pair<Int, Int>>()
    adjacentCoordinates.add(Pair(x-1, y))
    adjacentCoordinates.add(Pair(x+1, y))
    adjacentCoordinates.add(Pair(x, y-1))
    adjacentCoordinates.add(Pair(x, y+1))
    adjacentCoordinates.add(Pair(x-1, y-1))
    adjacentCoordinates.add(Pair(x-1, y+1))
    adjacentCoordinates.add(Pair(x+1, y-1))
    adjacentCoordinates.add(Pair(x+1, y+1))

    return adjacentCoordinates
}

fun getNoOfAdjacentAliveCells(coordinates: HashSet<Pair<Int, Int>>, x:Int, y:Int):Int
{
    var noOfAliveCells = 0
    noOfAliveCells += checkIfCellIsAlive(coordinates, x - 1, y)
    noOfAliveCells += checkIfCellIsAlive(coordinates, x + 1, y)
    noOfAliveCells += checkIfCellIsAlive(coordinates, x, y - 1)
    noOfAliveCells += checkIfCellIsAlive(coordinates, x, y + 1)
    noOfAliveCells += checkIfCellIsAlive(coordinates, x - 1, y - 1)
    noOfAliveCells += checkIfCellIsAlive(coordinates, x - 1, y + 1)
    noOfAliveCells += checkIfCellIsAlive(coordinates, x + 1, y - 1)
    noOfAliveCells += checkIfCellIsAlive(coordinates, x + 1, y + 1)

    return noOfAliveCells
}

fun checkIfCellIsAlive(coordinates: HashSet<Pair<Int, Int>>, x:Int, y:Int):Int
{
    if(coordinates.contains(Pair(x,y)))
        return 1
    else
        return 0
}

fun printBoard(coordinates:HashSet<Pair<Int, Int>>)
{
    var minX = Integer.MAX_VALUE
    var minY = Integer.MAX_VALUE
    var maxX = Integer.MIN_VALUE
    var maxY = Integer.MIN_VALUE

    coordinates.forEach {coordinate ->
        if(coordinate.first < minX)
            minX = coordinate.first
        if(coordinate.first > maxX)
            maxX = coordinate.first
        if(coordinate.second < minY)
            minY = coordinate.second
        if(coordinate.second > maxY)
            maxY = coordinate.second
    }

    for(i in minX..maxX){
        for(j in minY..maxY){
            if(coordinates.contains( Pair(i,j) ))
                print('*' + "\t")
            else
                print('.' + "\t")
        }
        println()
    }


}

fun updateLivingNeighbourhood(livingNeighbourhood:HashMap<Pair<Int, Int>, Int>,
                              adjacentCoordinates:HashSet<Pair<Int, Int>>):HashMap<Pair<Int, Int>, Int>
{
    adjacentCoordinates.forEach { coordinate ->
        if(!livingNeighbourhood.containsKey(coordinate))
            livingNeighbourhood[coordinate] = 1
        else
            livingNeighbourhood[coordinate] = livingNeighbourhood[coordinate]!! + 1

    }
    return livingNeighbourhood
}

fun makeIteration(coordinates: HashSet<Pair<Int, Int>>):HashSet<Pair<Int, Int>>
{
    val deadCoordinates = HashSet<Pair<Int, Int>>()
    var livingNeighbourhood = HashMap<Pair<Int, Int>, Int>()

    coordinates.forEach {coordinate ->
        val x = coordinate.first
        val y = coordinate.second
        val adjacentCoordinates = getAdjacentCoordinates(x, y)
        val noOfAdjacentAliveCells = getNoOfAdjacentAliveCells(coordinates, x, y)
        livingNeighbourhood = updateLivingNeighbourhood(livingNeighbourhood, adjacentCoordinates)

        if(noOfAdjacentAliveCells < 2 || noOfAdjacentAliveCells > 3)
            deadCoordinates.add(coordinate)
    }

    livingNeighbourhood.forEach { pair, i ->
        if(livingNeighbourhood[pair] == 3)
            coordinates.add(pair)
     }

    coordinates.removeAll(deadCoordinates)

    return coordinates
}

fun playGame(array: Array<Pair<Int, Int>>, n:Int)
{
    var pairSet = HashSet<Pair<Int, Int>>()
    array.forEach { coordinate ->
        pairSet.add(coordinate)
    }
    println("Given arrangement :")
    printBoard(pairSet)
    println()
    for(i in 1..n)
    {
        println("After Iteration : "+i)
        pairSet = makeIteration(pairSet)
        printBoard(pairSet)
        println()
    }
}

fun main(){
    playGame(arrayOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(1, 5)), 3)
}