package `21-30`

/*
You are given an M by N matrix consisting of booleans that represents a board.
Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start.
If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7,
since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */

fun getMinNoOfStepsInBoard(board:Array<Array<Boolean>>, start:Pair<Int, Int>, end:Pair<Int, Int>):Int?
{
    val set  = HashSet<Pair<Int, Int>>()
    return getMinNoOfStepsRecursive(board, start, end, set)
}


fun getMinNoOfStepsRecursive(board:Array<Array<Boolean>>, start:Pair<Int, Int>, end:Pair<Int, Int>, set: HashSet<Pair<Int, Int>>):Int?
{
    if(start == end)
        return 0

    val yLength = board.size
    val xLength = board[0].size

    val newSet = HashSet<Pair<Int, Int>>()
    newSet.addAll(set)

    newSet.add(start)
    val pathLengths = mutableListOf<Int>()

    fun exploreNeighbour(coordinate: Pair<Int, Int>)
    {
        if(!newSet.contains(coordinate) && !board[coordinate.first][coordinate.second]){
//            println(coordinate)
            val pathLength = getMinNoOfStepsRecursive(board, coordinate, end, newSet)
            if(pathLength != null)
                pathLengths.add(pathLength)
        }
    }

    if(start.first != 0)
        exploreNeighbour(Pair(start.first-1, start.second))
    if(start.first != yLength-1)
        exploreNeighbour(Pair(start.first+1, start.second))
    if(start.second != 0)
        exploreNeighbour(Pair(start.first, start.second-1))
    if(start.second != xLength-1)
        exploreNeighbour(Pair(start.first, start.second+1))

    if(pathLengths.isEmpty())
        return null
    else
        return pathLengths.min()!! + 1
}

/*
Solution:
Coin can move in 4 directions wherever it can.Hence tree structure will be there.
We are using set to check if that coordinate already visited or not on each level of tree.
2 conditions will be checked before moving to that point
1. That desired place is not already visited.
2. That place is not wall i.e. it is 'false'
Get minimum of branches - no of steps and add 1 at each level.
 */