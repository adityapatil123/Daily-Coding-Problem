# Daily-Coding-Problems 31-40
Solutions to problems sent by dailycodingproblem.com solved in **Kotlin** with **JUnit** test cases.

## Problem 31
This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between "kitten" and "sitting" is three: substitute the "k" for "s", substitute the "e" for "i", and append a "g".

Given two strings, compute the edit distance between them.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem31.kt)
- First find out that if there is any difference between lengths of two strings, those will be insertions/deletions.
- Then traverse through any string till where characters of both strings are present.
- If characters are not then those will be required substitutions.
- Return (insertions/deletions) + substitutions.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/31-40/Problem31KtTest.kt)

## Problem 32
This problem was asked by Jane Street.

Suppose you are given a table of currency exchange rates, represented as a 2D array. Determine whether there is a possible arbitrage: that is, whether there is some sequence of trades you can make, starting with some amount A of any currency, so that you can end up with some amount greater than A of that currency.

There are no transaction costs and you can trade fractional quantities.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem32.kt)
- We will be solving this problem using Bellman-Ford method.Know more here:
[Link](https://www.dailycodingproblem.com/blog/how-to-find-arbitrage-opportunities-in-python/)
- First we will find the minimum distances between the nodes.
- In second we will check if they are correct or not, if not return True, else return False. 

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/31-40/Problem32KtTest.kt)

## Problem 33
This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
```
2
1.5
2
3.5
2
2
2
```

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem33.kt)
- At  first we  want sorted list if we want to find the median, hence from start we will maintain that sorted list.
- **insertToSortedArrayList** function will take previously sorted list and give new sorted list with added element instead of making whole list from scratch.
- Traverse our unsorted list elements, if element is odd, just return element at index of size by 2, else if even it will average of size/2 and (size/2) -1.
- Add median for each element, and return that list of medians.s 

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/31-40/Problem33KtTest.kt)

## Problem 34
This problem was asked by Quora.

Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make a palindrome). There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem34.kt)
- We will use recursive approach.
- First check if given string is only palindrome, if yes return the same string.
- There will be 2 conditions:
1. If start and end character is same, if yes call the function for middle string and return output of that middle string with prefix, suffix as that first character.
2. If start and end is not same, check palindromes, one with beginning and ending as start and other with end character.
- Return the with string as least length, if lengths are same, then check alphabetically and return.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/31-40/Problem34KtTest.kt)

## Problem 35
This problem was asked by Google.

Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem35.kt)
- Approach is to sort all 'R's first, then 'G's and automatically 'B's, complexity will be 2*n i.e. O(n)
- **segregateForChar** function will take start, end indices and letter which will be all come at the start.
- In this function, we will rotate till start(i) is less than end(j), 3 conditions:
1. arr[i] is your letter,  hence it is at right position only, increase i by 1.
2. arr[j] is your letter, hence swap it to first, increase i by 1
3. arr[j] is not your letter, decrease j i.e. make range less.
- Return this function with **i**, which is **sortedTillBeforeIndex** i.e. if it is 3, till 3 everything is sorted.
- Call the function for 'R' and 'G' and return array.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/31-40/Problem35KtTest.kt)

## Problem 36
This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem36.kt)
- As we have given binary search tree, hence the rightmost node will be largest.
- For second largest 2 things can be there:
1. If biggest doesn't have any child, then parent of biggest will be second-largest.
2. If biggest does have left child, rightmost(largest) of that tree from left child of biggest will be nothing but second-largest.Function **getLargestNode** will provide the largest node in that tree.
- Return the value of second-largest node.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/31-40/Problem36KtTest.kt)

## Problem 37
This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem37.kt)
Here I have solved it by 2 approaches:
1. Brute-Force approach first add null array and then add arrays by looping for n*(n-1) times
2. Recursive approach where get the power set from next element and again add sets with adding that first element.Here, we are making the use previously calculated power set instead of creating from scratch.


[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/31-40/Problem37KtTest.kt)

## Problem 38
This problem was asked by Microsoft.

You have an N by N board. Write a function that, given N, returns the number of possible arrangements of the board where N queens can be placed on the board without threatening each other, i.e. no two queens share the same row, column, or diagonal.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem38.kt)
- This problem will be solved using back-tracking
- Approach will be to consider each column at a time and try putting queen there, it can be put is it is safe to put, we will check using **isSafe** function.
- In main function, iterate over rows, where we will place and make  recursive call for right columns.Return 1 if column exceeds n(input n).
- In safe-checking function danger conditions will be queen is on same row, or on left upper diagonal or on left lower diagonal.  

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/38-40/Problem38KtTest.kt)

## Problem 39
This problem was asked by Dropbox.

Conway's Game of Life takes place on an infinite two-dimensional board of square cells. Each cell is either dead or alive, and at each tick, the following rules apply:

Any live cell with less than two live neighbours dies.
Any live cell with two or three live neighbours remains living.
Any live cell with more than three live neighbours dies.
Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates and the number of steps it should run for. Once initialized, it should print out the board state at each step. Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem39.kt)
- Main function **makeIteration**, takes the set of coordinates(which are alive) and print the updated table with new coordinates.
- In that function, iterate over coordinates, get adjacent coordinates, how many of them are alive and update the neighbourhood.If alive cell gets dead add that to deadCoordinates.Iterate over neighbourhood and them to set if needed.
- Function **playGame** will just repeat function **makeIteration** for number given.
- Other function will provide the necessary working.

No Test Unit Cases, as we are just printing the results for each step.

## Problem 40
Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/31-40/Problem40.kt)
- Here time complexity is 10*n i.e. O(n) where 10 is maximum binary length number in array can have, if number is bigger than that, increase that number.
- Duplicate number will be found using bits operation, if that is present add to **sumOfBits**.
- If those sumOfBits is not in multiple of 3, add to those bits to non-duplicate number.
- After iterating for all, return non-duplicate number.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/38-40/Problem40KtTest.kt)