# Daily-Coding-Problems 1-10
Solutions to problems sent by dailycodingproblem.com

## Problem 1
Given a list of numbers, return whether any two sums to k. 
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem1.kt)
[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem1KtTest.kt)

- **Brute force method O(n2)** Used nested for-loops
- **Using HashSet O(n)** In linear time, value will be checked and added in HashSet

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem1KtTest.kt)

## Problem 2
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem2.kt)

- **Brute force method O(n2)** Used nested for-loops or while loops
- **Using leftProduct and rightProduct O(n)** Here,leftProductArray and rightProductArray which is continuous product from left-to-right and right-to-left.

e.g. In array[1,2,3,4] for 2nd pos you will consider product of left of it(1) and product of right of it(12), hence multiplication = 1 x 12 =12

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem2KtTest.kt)

## Problem 3
This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem3.kt)

- **Serialise** will be done using stringifying values and seperating them using '-'
- In **Desialising**,queue is made and paseed on to **deserialiseNode**,where it is used for recursive actions.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem3KtTest.kt)

## Problem 4
This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem4.kt)

- **Using HashSet and its contians function:** Its great and linear but there should be **in-placing**
- **Array In-placing:** We are placing number at its index and not caring if its out-of range or duplicate.
  1. In for-loop, Check if any number is not at right pos only and is in the range.In while loop for continuous, break if number is duplicate, out of range or at correct position.
  2. In next for-loop, check if array doesn't contain number from range 0-array.length. Return next absent number.
  3. If every elem present in range and return next element i.e array.length+1
  
[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem4KtTest.kt)

## Problem 5
This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    return lambda f : f(a, b)
Implement car and cdr.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem5.kt)
- In **cons**, pass args **a & b**, inside of it
  1. Define function **pair** with arguement as function **f**.
  2. Function **f**, which takes two ints and return pair of them.
- In **car** and **cdr**, takes pair return first and second respectively.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem5KtTest.kt)

## Problem 6
This problem was asked by Google.

An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem6.kt)
- **XOR List** will point **both**, which is xor of addresses of previous and next nodes.
- XOR is special operaion, where a xor b = c, a xor c = b and b xor c = a always exists. Hence, if you have prev and both you can tell next
while next and both can say about prev. Hence can be traversed in both directions.
- Head will be xor of 0 and next, and Tail will be of xor of 0 and prev.

No Test Unit Cases in Kotlin as it doesn't support pointer arithmetics.Hence used functions about addresses only for logic.  

## Problem 7
This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem7.kt)
- Make string to char-array and from char-array to list of integers.
- List of integers will be traversed recursively, with checking of arr[0] and lastElem if they are in 1 to 26,which is nothing but arr[0] from inner recursive cycle.
- Recursion will be stopped when list_length becomes 1.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem7KtTest.kt)

## Problem 8
This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:
```
   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
 ```
[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem8.kt)

- Using recursion check till both child1 and child2 are null.
- Return noOfTrees and flag i.e. if value of root and childs are same then make flag true and increase noOfTrees by 1.
- If both childs are null then increase noOfTrees and make flag = true

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem8KtTest.kt)

## Problem 9
This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 8] should return 12, since we pick 4 and 8. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem9.kt)
- Make Head and Tail different fromm array.Use divide-and-rule.
- Define two sums:
  1. sum1 = arr[0] + prevSum2      Here,sum1 will be considering number what will be sum
  2. sum2 = max(prevSum1, prevSum2)   Here, without considering what will be sum
- Atlast return whichever is maximum.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Problem9KtTest.kt)

## Problem 10
This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Problem10.kt)
- Pass any function and delay required in milliseconds to jobScheduler.
- In jobScheduler, sleep Thread for that particular time.

## Solved 1
Return a new sorted merged list from K sorted lists, each with size N.

For example, if we had [[10, 15, 30], [12, 15, 20], [17, 20, 32]], the result should be [10, 12, 15, 15, 17, 20, 20, 30, 32].

For brute-force method, time complexity for that would be O(KN log KN), since we have K * N total elements.

Use heap,The time complexity for this would be O(KN log K), since we remove and append to the heap K * N times.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/1-10/Solved1.kt)

- Since, K arrays are already sorted, we just have to check element from one element from each k array.
- For that pinter array is used which points to checking element of every array.
- If element is added to output array pinter will be move forward till-end

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/1-10/Solved1KtTest.kt)
