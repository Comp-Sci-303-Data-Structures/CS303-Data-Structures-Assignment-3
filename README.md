# CS303-Data-Structures-Assignment-3

Question 1:
Create a generic queue class using linkedlist or circular array.
- Should be able to run the que methods offer(), poll(), peek(), size() and empty

Question 2:
Write a recursive linear search function with a recursive step that finds the last
occurrence of a target in a ArrayList, not the first.

Question 3:
Modify the source code for the insertion sort so that it can sort a list of Integers

How to Compile:
Open the corresponding java file you want to compile and run




Design Notes
Q1 – Generic Queue

Backed by a singly linked list with front and rear pointers.
offer(item) – appends to rear in O(1).
poll() – removes from front in O(1).
peek() – reads front without removing in O(1).
size() / empty() – O(1) via a maintained counter.
display() – polls each element, prints it, then re-offers it, restoring the queue in original order (uses only the required functions).
move_to_rear() – implemented with peek() + poll() + offer() as required.

Q2 – Recursive Last-Occurrence Search

Starts at the last index and walks left (index − 1) at each recursive call.
The first match encountered (walking from right to left) is therefore the last occurrence in the list.
Returns −1 when index < 0 (base case — not found).
Generic (<T>) so it works with any type that implements equals().

Q3 – Insertion Sort on LinkedList
Sorts in-place in O(n²) time.
Tested on: random, already-sorted, reverse-sorted, and duplicate-value lists.

----------
Outputs
----------
=== Q1 Part (a): Push 10 integers ===
  Offered: 10  | size = 1
  Offered: 20  | size = 2
  Offered: 30  | size = 3
  Offered: 40  | size = 4
  Offered: 50  | size = 5
  Offered: 60  | size = 6
  Offered: 70  | size = 7
  Offered: 80  | size = 8
  Offered: 90  | size = 9
  Offered: 100  | size = 10

=== Q1 Part (b): Display all elements ===
Queue (front → rear): 10 → 20 → 30 → 40 → 50 → 60 → 70 → 80 → 90 → 100
  peek()  = 10
  size()  = 10
  empty() = false

=== Q1 Part (c): move_to_rear ===
Before move_to_rear – Queue (front → rear): 10 → 20 → 30 → 40 → 50 → 60 → 70 → 80 → 90 → 100
After  move_to_rear – Queue (front → rear): 20 → 30 → 40 → 50 → 60 → 70 → 80 → 90 → 100 → 10
After 2nd move_to_rear – Queue (front → rear): 30 → 40 → 50 → 60 → 70 → 80 → 90 → 100 → 10 → 20

=== Q2 Recursive Last-Occurrence Search ===

List : [3, 7, 1, 9, 7, 4, 7, 2, 5]
Last occurrence of 7 → index 6
Last occurrence of 9 → index 3
Last occurrence of 99 → index -1
Last occurrence of 3 → index 0

List : [apple, banana, apple, cherry, apple, date]
Last occurrence of "apple" → index 4

=== Q3 Insertion Sort on LinkedList ===

Before sort: [64, 25, 12, 22, 11, 90, 3, 47, 55, 8]
After  sort: [3, 8, 11, 12, 22, 25, 47, 55, 64, 90]

Before sort (already sorted): [1, 2, 3, 4, 5]
After  sort                 : [1, 2, 3, 4, 5]

Before sort (reverse order): [9, 8, 7, 6, 5, 4, 3, 2, 1]
After  sort                : [1, 2, 3, 4, 5, 6, 7, 8, 9]

Before sort (with duplicates): [5, 3, 5, 1, 3, 2, 5]
After  sort                  : [1, 2, 3, 3, 5, 5, 5]