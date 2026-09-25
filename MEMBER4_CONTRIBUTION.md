# Member 4 Contribution

## Responsibility

Member 4 was responsible for the Campus Graph component of the CIT300 Data Structures and Algorithms project.

## Main File

* CampusGraph.java

## Graph Features Verified

The Campus Graph component was tested and verified for the following requirements:

* Adding campus locations
* Removing campus locations
* Adding connections between campus locations
* Removing connections between campus locations
* Displaying the campus network
* Breadth-First Search (BFS)
* Depth-First Search (DFS)
* Duplicate location validation
* Duplicate connection validation
* Invalid location handling
* Invalid connection handling
* Removing a location and its related connections

## Testing Performed

The graph component was tested using multiple campus locations and connections.

### Location Testing

* Added locations A, B, and C.
* Verified that the locations were displayed correctly.
* Tested duplicate location handling.
* Tested removal of an existing location.
* Verified that removing a location also removed its related connections.

### Connection Testing

* Added connections A-B, B-C, and A-C.
* Verified the campus network using the display option.
* Tested duplicate connection handling.
* Tested invalid connection input.
* Removed the A-C connection and verified the updated network.

### BFS Testing

* Performed BFS starting from location A.
* Verified that connected campus locations were traversed successfully.

### DFS Testing

* Performed DFS starting from location A.
* Verified that connected campus locations were traversed successfully.

### Invalid Input Testing

The following invalid cases were tested:

* Empty location name
* Non-existing location
* Duplicate location
* Duplicate connection
* Invalid connection removal
* Invalid traversal starting location

The application displayed appropriate validation messages for invalid inputs.

## Integration Verification

The Campus Graph component was tested through the integrated Main.java menu system.

The following graph menu operations were verified:

* Add campus location
* Remove campus location
* Add campus connection
* Remove campus connection
* Display campus network
* BFS traversal
* DFS traversal

The graph functionality worked correctly with the integrated application.

## Compilation

The complete project was compiled successfully using:

javac *.java

Compilation completed successfully without errors.

## Contribution Summary

Member 4 contributed to the project by testing and verifying the Campus Graph functionality, including campus locations, connections, BFS, DFS, validation, removal operations, and integration with the main application.

The graph component was verified as part of the complete group project.


