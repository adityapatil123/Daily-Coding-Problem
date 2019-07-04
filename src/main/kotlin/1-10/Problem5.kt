import java.util.function.Function

//cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
// For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

//Given this implementation of cons:

//def cons(a, b):
//  def pair(f):
//      return f(a, b)
//  return pair

//Implement car and cdr.

fun cons(num1:Int, num2:Int):Pair<Int,Int>
{
    fun pair(func:(Int,Int)->Pair<Int,Int>) = func(num1, num2)
    fun f(numA: Int,numB: Int) = Pair(numA,numB)

    val pair = pair(::f)
    return pair
}

fun car(pair:Pair<Int,Int>):Int = pair.first
fun cdr(pair:Pair<Int,Int>):Int = pair.second

fun main(args:Array<String>){
    val pair = cons(1,2)
    println(car(pair))
    println(cdr(pair))
}