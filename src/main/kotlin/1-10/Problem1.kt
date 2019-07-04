//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//
//For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

//Normal way, complexity: O(n2)
fun addUptoK(arr:Array<Int>,k:Int):Boolean{
    for(i in 0..arr.size-1){
        for(j in i+1..arr.size-1){
            if(arr[i]+arr[j]==k)
                return true
        }
    }
    return false
}

// Using hash-set, complexity: O(n)
fun addUptoK2(arr:Array<Int>,k:Int):Boolean{
    val set = HashSet<Int>(arr.size)

    arr.forEach { elem ->
        val remain = k - elem
        println(elem)
        if(set.contains(remain))
            return true
        set.add(elem)
    }

    return false
}