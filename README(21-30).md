# Daily-Coding-Problems 21-30
Solutions to problems sent by dailycodingproblem.com solved in **Kotlin** with **JUnit** test cases.

## Problem 21
This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem21.kt)
- getFreeIntervals as global arraylist which has intervals which are free.
- isNewRoomRequired function will tell if particular interval can be fitted in free intervals Hence newRequired or not. - Here, getFreeIntervals is also updated.
- updateFreeIntervals function is used for not having repetition of code.
- minimumRequiredRooms will add in noOfRooms if newRequired or not

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem21KtTest.kt)

## Problem 22
This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem22.kt)
1. 1st function:
- Initialise newArray where we will add new elem if that contains in array.
- For each elem of array, if string contains elem, add elem in NewArray and remove that part from string
- Return that newArray.
- But problem here is newArray elems are not in order as in string.

2. 2nd function:
- Instead of iterating array , here we are iterating on string.
- Add character to word and check if that contains in set(for having better efficiency), If yes add elem and make word blank.
- Return newArray

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem22KtTest.kt)

## Problem 23
This problem was asked by Google.

You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:
```
[[f, f, f, f],
 [t, t, f, t],
 [f, f, f, f],
 [f, f, f, f]]
 ```
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem23.kt)
- Coin can move in 4 directions wherever it can.Hence tree structure will be there.
- We are using set to check if that coordinate already visited or not on each level of tree.
- 2 conditions will be checked before moving to that point
1. That desired place is not already visited.
2. That place is not wall i.e. it is 'false'
- Get minimum of branches - no of steps and add 1 at each level.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem23KtTest.kt)

## Problem 24
This problem was asked by Google.

Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true. unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true. You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem24.kt)
- Create global variable RootNode which will be nothing but root node of Tree, which can be called from anywhere.
- Make class for node and have properties required for making node and make constructors for the same.
- Function isNodeLocked can be simply checked by accessing property isLocked.
- For functions lock and unlock nodes, we have to first see  if all ancestors and descendants are unlocked or not.
- For checking ancestors, we will parse whole tree from starting until we get the element.
- For  descendants, it is simple enough to just parse tree from that node.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem24KtTest.kt)

## Problem 25
This problem was asked by Facebook.

Implement regular expression matching with the following special characters:

- '.' (period) which matches any single character
- '*' (asterisk) which matches zero or more of the preceding element That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.
For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem25.kt)
We will break expression and string and use them in recursive function.
Its all about conditions
1. If Expr is empty, return false.
2. Expr cant begin with *
3. If expr length is 1 then string has to be of length 1.
4. Check if 2nd element is '*', and if 1st is '.', then check till next elem is of expr gets in string.
   And if 1st is not '.', then check till repetition of that character.
5. If 2nd is not '*', just check simply if that 1st char in expr is same as 1st char in string, except for '.'
6. Program will break into recursions step by step and base-case will be 3rd case.
- Given stream which will be flow of data, random element will be considered by checking which one is bigger.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem25KtTest.kt)

## Problem 26
This problem was asked by Google.

Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem26.kt)
- Make class for Node and Linked List, add function for adding th nodes in it.
 - In function `21-30`.removeKthLastNode, k is less than  length of list  hence we will traverse till k, making first as kthLastNode.
- Introduce variable for node previous to kthLastNode and put the value  of kthLastNode in iteration making kthLastNode next one.
- Hence we  are traversing all list nodes in one pass and in constant space.

No Test Unit Cases, check the results by printing the list.

## Problem 27
This problem was asked by Facebook.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])", you should return true.

Given the string "([)]" or "((()", you should return false.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem27.kt)
- Make arrays of opening and closing brackets.
- We will use Stack data structure here.
- Push to stack if opening bracket,
else check peek element if prevChar opening bracket and current char closing bracket are of same type, if yes continue otherwise return false.
- After traversing whole string, check the size of stack, if zero then true otherwise false.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem27KtTest.kt)

## Problem 28
This problem was asked by Palantir.

Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the quick brown", # 1 extra space on the left "fox jumps over", # 2 extra spaces distributed evenly "the lazy dog"] # 4 extra spaces distributed evenly.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem28.kt)
- Here, we can solve using sliding window approach.
- Add words normally(with one space) till strLength k.
- When it exceeds k, make stringLine of those words adjusting spaces as per asked.
- Return the list of those stringLines.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem28KtTest.kt)

## Problem 29
This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem29.kt)
1. encodeString : function will traverse string through character by character,
- Check if char is same as previous one, if not add noOfRepetitions and char in encodedStr.
- After the loop add the remained one in encodedStr.

2. decodeString : function will traverse encoded string through character by character,
- if at even index, get noOfRepetitions
- else, add char in decodedStr noOfRepetitions times
- return decodedStr

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem29KtTest.kt)

## Problem 30
You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.

[Solution:](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/main/kotlin/21-30/Problem30.kt)
- We will divide it different windows i.e, whenever middle is greater than both ends, slide the window.
- Initialise midValues and midNumbers for the calculation of noOfSpots for each window.
- Update the values only when middle is lesser than both ends.
- Whenever window is slided, calculate spots for that window, and re-initialise midValues and midNumbers.
- Find the spots at the end,  because sliding condition will not be there
- Return final spots.

[Test Unit Cases](https://github.com/adityapatil123/Daily-Coding-Problems/blob/master/src/test/kotlin/21-30/Problem30KtTest.kt)