# Daily-Coding-Problems 11-20
Solutions to problems sent by dailycodingproblem.com solved in **Kotlin** with **JUnit** test cases.

## Problem 11
This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem11.kt)
- Using **CharNode** class, created node objects of character.
- We will create where each level of it will be index of word added.
- In function **addNode**, we will add character node if at that level character is not there
- Function **find** will be called recursively by  dividing for every character.
- Function **findWords** will give list of all words possible from that character.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem11KtTest.kt)

## Problem 12
This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:
```
1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
```
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem12.kt)
Here, 2 functions for 1 or 2 steps, and for other array of steps, using func **getStepsLastSecondLast** which will return lastNoSteps and secondLastNoSteps, which will be added at every recursion step.
- **getStepsFor1_2 :** Time complexity is O(n) here.
- **getStepsForAny :** Here, time complexity is O(n2). For each stepSize, steps will be added.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem12KtTest.kt)

## Problem 13
This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem13.kt)
- **getMaxSubstringRecursive** function will return maxSubstring, prevGoingOnString(string which is going on, which will be checked using maxSubstring) and Hashset for set of characters which are in maxSubstring.
- In hashset, we will add and remove chars as substring is updated.Here hashset contains returning in O(1) time, Hence used.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem13KtTest.kt)

## Problem 14
This problem was asked by Google.

The area of a circle is defined as r^2. Estimate \pi to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x^2 + y^2 = r^2.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem14.kt)
Monte Carlo method is nothing but finding area of circle by taking no of points, pi = 4*(pts lying in circle)/totalPts
2 functions :
1. Estimating by order of points i.e. x in 0.100 and y in 0..100
2. Estimating by random points i.e. x and y are chosen randomly.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem14KtTest.kt)

## Problem 15
This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem15.kt)
- Given stream which will be flow of data, random element will be considered by checking which one is bigger.

No Test Unit Cases here as we are just printing any element from stream.

## Problem 16
This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N. You should be as efficient with time and space as possible.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem16.kt)
- Global variables **bigN** and **logList**
- In function record, longList will add record till bigN and if greater than bigN remove first elem.
- in function getLast, will return last element in logList.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem16KtTest.kt)

## Problem 17
This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
```
dir
    subdir1
    subdir2
        file.ext
```
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
```
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
```
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem17.kt)
- We will be making object from class **FileSystemNode**.
- Make tree using function **getTreeFromString**.
- Get maximum file path checking if any file extension is there from function **getMaximumLengthOfPath**.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem17KtTest.kt)

## Problem 18
This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
```
10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
```
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem18.kt)
- Create **maxValArray** array of maxVals of each sub-array, but here it not necessary that it will always have max.
- First, print the max element of first sub-array.
- For remaining, print max of that sub-array.

No Test Unit Cases as we are printing the results not saving anywhere.

## Problem 19
This problem was asked by Facebook.

A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem19.kt)
- 4 variables max, secondMax, maxIndex, secondMaxIndex which will get from recursive function from where those values will be updated.
- Using **getMinAndSecondMin**, those 4 variables are found for array i.e for colors of any house.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem19KtTest.kt)

## Problem 20
This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/11-20/Problem20.kt)
- Make node objects of class **LLNode** and Implement **SinglyLinkedList** from them.
- Function **findIfNodeAlreadyPresent** will return if Node present or not and SinglyLinkedList if present.
- When creating second list every value will  be checked with values from first list. If not present, make new node and if present just add list from func findIfNodeAlreadyPresent as nextNode.
- Return intersecting element which will be null or first of list from findIfNodeAlreadyPresent.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/11-20/Problem20KtTest.kt)
