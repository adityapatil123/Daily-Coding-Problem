# Daily-Coding-Problems 41-50
Solutions to problems sent by dailycodingproblem.com solved in **Kotlin** with **JUnit** test cases.

## Problem 41
This problem was asked by Facebook.

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However, the first one is lexicographically smaller.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem41.kt)
- In here we will make recursive call till every elements, if all are traversed, hence return array of start of pairs.
- Using hash-set because finding, removing takes place at constant time.
- If more than one path is possible, check the one who is lexicographically smaller.
- Return null or array of starts of flights.  

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem41KtTest.kt)

## Problem 42
This problem was asked by Google.

Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem42.kt)
- We will use recursive approach, subsets will get added and will check for their sums.
- Worst Complexity will be O(nlogn), complexity will increase as output array length increases.
- Subsets will be added like Set(first), Set(Remaining)[which will be calculated in next iteration], Set(first+remaining)
- Check till sum of any subset is equal to 'k' and return that subset.
- If no subset is found, return null

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem42KtTest.kt)

## Problem 43
This problem was asked by Amazon.

Implement a stack that has the following methods:

- push(val), which pushes an element onto the stack
- pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
- max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem43.kt)
- Create class for stack-node, where there will be value, prev element and max till this node.
- Create class for stack, where these 3 functions are there.
1. **Push:** Update the last element with new node, max element will be assigned by comparing with last max.
2. **Pop:** Update last element as previous element, prev max will be assigned.
3. **Max:** Return the maxTillNode of last element.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem43KtTest.kt)

## Problem 44
This problem was asked by Google.

We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem44.kt)
- We will find noOfInversions using merge-sort algorithm, hence time complexity will be O(nlogn).
- According to merge-sort algorithm, divide array in middle and find the inversion if any.
- Merge these two arrays and find the inversions.
- Return those inversions.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem44KtTest.kt)

## Problem 45
This problem was asked by Two Sigma.

Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem45.kt)
- First find random element from 1-5.
- We want random element with equal probability in 1-7, hence set will for that element as 1-7 or 1-14 or 1-21.
- Make an equation from rand5 as **i = 5rand5() + rand5() - 5**, which will give elements from 1-25, cut it down to 21 for use.
- Check the probability for number if cases, which has to be 1/7(i.e. 0.143)

(No Test Unit Cases)

## Problem 46
This problem was asked by Amazon.

Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem46.kt)
- Check first whole string is palindrome, if yes return same string.
- Make recursive call for palindrome excluding first and one with excluding last, return maximum one.
- By recursion we will be having all substrings traversed, hence can find the maximum palindrome.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem46KtTest.kt)

## Problem 47
This problem was asked by Facebook.

Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem47.kt)
- Here, time complexity is linear.
- Find the minimum number is next one is lower than that, else make last minimum as asked-number.
- If size less than 2 or no case where profit is possible, return null.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem47KtTest.kt)

## Problem 48
This problem was asked by Google.

Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:
```
    a
   / \
  b   c
 / \ / \
d  e f  g
```
[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem48.kt)
- Make the first element of pre-order as root node, and check that char in in-order, to left elements will be left tree and right elements will be right tree.
- Have the same slicing for pre-order array.
- Make the recursive call for left and right tree till size of array is one. 

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem48KtTest.kt)

## Problem 49
This problem was asked by Amazon.

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem49.kt)
- This program will run for O(n) time recursively.
- We will be having two sums one with considering current element and other as maximum of last 2 sums.
- For last element we will check if negative, if yes, return with sums as 0.
- Return the maximum of 2 sums as output.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem49KtTest.kt)

## Problem 50
This problem was asked by Microsoft.

Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:
```
    *
   / \
  +    +
 / \  / \
3  2  4  5
```
You should return 45, as it is (3 + 2) * (4 + 5).

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/41-50/Problem50.kt)
- Check if root-node value is digit, if yes, return digit.
- Check if root child is digit or not, if yes, take that as left value and if not, call recursive function root node as that child node.
- Perform checking for both child.
- Make arithmetic operations as per the sign and return the result.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/41-50/Problem50KtTest.kt)