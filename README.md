\# University Student Record and Campus Route Management System



\## CIT300 – Data Structures and Algorithms



\### Project Description



The \*\*University Student Record and Campus Route Management System\*\* is a Java-based console application developed for the \*\*CIT300 Data Structures and Algorithms Graded Practical Assignment\*\*.



The system demonstrates the practical application of fundamental data structures and algorithms to manage university student records, student service requests, recent actions, efficient student searching, and campus locations and connections.



\## Team Members



| Member   | Name               | Student ID | Responsibility                          |

| -------- | ------------------ | ---------- | --------------------------------------- |

| Member 1 | M.J.Kalith Mish\_al | 23DA2-1176 | Student Management \& System Integration |

| Member 2 | M.I.M.Shihab       | 23DA2-0483 | Stack \& Queue                           |

| Member 3 | S.A.H. Kurzith     | 23DA2-0672 | Binary Search Tree \& Hashing            |

| Member 4 | M. S. F. Rinoza    | 23DA2-0549 | Campus Graph                            |



\## Data Structures Used



The project implements the following data structures:



\* Singly Linked List

\* Stack

\* Queue

\* Binary Search Tree (BST)

\* Hash Table

\* Graph



\## Main System Features



\### Student Management



\* Add student records

\* Update student records

\* Delete student records

\* Search student records

\* Display all student records using a Linked List



\### Stack



\* Store recent system actions

\* Push actions onto the stack

\* Pop the most recent action

\* Peek at the latest action

\* Display recent actions

\* Demonstrate LIFO behavior



\### Queue



\* Add student service requests

\* Process requests in FIFO order

\* Display service requests

\* Handle empty queue conditions



\### Binary Search Tree



\* Store student records using Student ID as the key

\* Insert student records

\* Search student records

\* Delete student records

\* Display student records in sorted Student ID order



\### Hash Table



\* Perform efficient Student ID searching

\* Handle hash collisions using chained entries

\* Insert student records

\* Search student records

\* Delete student records



\### Campus Graph



\* Add campus locations

\* Remove campus locations

\* Add campus connections or roads

\* Remove campus connections or roads

\* Display the campus network

\* Traverse campus locations using Breadth-First Search (BFS)

\* Traverse campus locations using Depth-First Search (DFS)



\## Team Contributions



\### Member 1 – M.J.Kalith Mish\_al



\*\*Student ID:\*\* 23DA2-1176



\*\*Responsibility:\*\* Student Management, System Integration \& Project Coordination



\*\*Contribution:\*\*



\* Developed the `Student.java` class for student record representation.

\* Developed the custom `StudentLinkedList.java` for student record management.

\* Implemented Add, Update, Delete, Search, and Display operations for student records.

\* Developed and integrated `InputValidator.java` for input validation.

\* Developed and integrated `Main.java` to connect all project components through the menu-driven system.

\* Integrated student records with the Binary Search Tree and Hash Table.

\* Performed complete system integration and testing.

\* Verified invalid input, duplicate data, and missing-record handling.

\* Coordinated the integration of team members' components.

\* Coordinated the project README and final documentation.

\* Managed GitHub repository integration and final project preparation.



\### Member 2 – M.I.M.Shihab



\*\*Student ID:\*\* 23DA2-0483



\*\*Responsibility:\*\* Stack \& Queue



\*\*Contribution:\*\*



\* Worked with the Stack component using `ActionStack.java`.

\* Worked with the Queue component using `ServiceQueue.java`.

\* Verified LIFO behavior of the Stack.

\* Verified FIFO behavior of the Queue.

\* Tested push, pop, and peek operations.

\* Tested enqueue, dequeue, and peek operations.

\* Tested empty Stack and Queue conditions.

\* Tested reuse of the Stack and Queue after becoming empty.

\* Verified Stack and Queue integration with `Main.java`.

\* Documented Stack and Queue testing and contribution.



\### Member 3 – S.A.H. Kurzith



\*\*Student ID:\*\* 23DA2-0672



\*\*Responsibility:\*\* Binary Search Tree \& Hashing



\*\*Contribution:\*\*



\* Worked with `StudentBST.java`.

\* Worked with `StudentHashTable.java`.

\* Verified BST insertion and searching.

\* Verified BST deletion for different node cases.

\* Verified sorted BST traversal.

\* Tested Hash Table searching and collision handling.

\* Tested duplicate and missing Student IDs.

\* Improved input validation for BST and Hash Table operations.

\* Verified BST and Hash Table integration with the complete system.



\### Member 4 – M. S. F. Rinoza



\*\*Student ID:\*\* 23DA2-0549



\*\*Responsibility:\*\* Campus Graph



\*\*Contribution:\*\*



\* Worked with the Campus Graph component using `CampusGraph.java`.

\* Verified adding and removing campus locations.

\* Verified adding and removing campus connections.

\* Tested campus network display.

\* Tested Breadth-First Search (BFS).

\* Tested Depth-First Search (DFS).

\* Tested duplicate and invalid locations and connections.

\* Verified that removing a location also removes its related connections.

\* Tested Graph integration with `Main.java`.

\* Documented Graph contribution and testing.



\## Input Validation and Error Handling



The system provides validation and error handling for common invalid conditions, including:



\* Invalid menu choices

\* Empty input

\* Invalid student marks

\* Duplicate Student IDs

\* Missing student records

\* Duplicate campus locations

\* Invalid campus locations

\* Duplicate campus connections

\* Invalid campus connections

\* Invalid BFS/DFS starting locations

\* Operations performed on empty Stack and Queue structures



\## System Menu



The application provides the following menu options:



1\. Add Student Record

2\. Update Student Record

3\. Delete Student Record

4\. Display All Student Records using Linked List

5\. Add Student Service Request to Queue

6\. Process Next Service Request

7\. Display Recent Actions using Stack

8\. Display Students using BST

9\. Search Student using Hashing

10\. Add Campus Location

11\. Remove Campus Location

12\. Add Campus Connection/Road

13\. Remove Campus Connection/Road

14\. Display Campus Connections

15\. Traverse Campus Locations using BFS or DFS

16\. Exit



\## Testing and Verification



The complete project was compiled and executed successfully using:



```text

javac \*.java

java Main

```



The system was tested for:



\* Student record management

\* Linked List operations

\* Stack operations

\* Queue operations

\* Binary Search Tree operations

\* Hash Table operations

\* Campus Graph operations

\* BFS and DFS traversal

\* Invalid input handling

\* Duplicate data handling

\* Missing data handling

\* Integration of all components through `Main.java`



\## Technologies Used



\* Java

\* Object-Oriented Programming

\* Data Structures and Algorithms

\* Git

\* GitHub



\## GitHub Collaboration



The project was developed collaboratively using GitHub branches, commits, and pull requests.



Each team member contributed according to their assigned responsibility. The individual components were integrated into the final system and tested as a complete Java console application.



\## How to Run



1\. Open the project folder in a terminal or Java IDE.

2\. Compile all Java source files:



```text

javac \*.java

```



3\. Run the application:



```text

java Main

```



4\. Select the required option from the system menu.



\## Project Status



The University Student Record and Campus Route Management System has been implemented as a complete Java console application.



The project components have been integrated, compiled, and tested as part of the CIT300 Data Structures and Algorithms Graded Practical Assignment.



