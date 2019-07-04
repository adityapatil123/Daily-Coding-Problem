import java.util.*
import java.util.logging.Handler
import kotlin.concurrent.schedule
import kotlin.concurrent.timer

// Implement a job scheduler which takes in a function f and an integer n,
// and calls f after n milliseconds.

fun jobScheduler(f:(Boolean)->Boolean, n:Int){
    Thread.sleep(n.toLong())
    print(f(true))
}

fun main(args:Array<String>){
    fun bool(boolean: Boolean):Boolean{
    return boolean and true
    }
    jobScheduler(::bool,2000)
}