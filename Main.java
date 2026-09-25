import java.util.Scanner;

/** Main menu that connects the student, service, and campus data structures. */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList students = new StudentLinkedList();
        StudentBST studentTree = new StudentBST();
        StudentHashTable studentTable = new StudentHashTable();
        ActionStack actionHistory = new ActionStack();
        ServiceQueue serviceRequests = new ServiceQueue();
        CampusGraph campus = new CampusGraph();
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = InputValidator.readInt(scanner, "Choose an option (1-16): ");

            switch (choice) {
                case 1:
                    addStudent(scanner, students, studentTree, studentTable, actionHistory);
                    break;
                case 2:
                    updateStudent(scanner, students, actionHistory);
                    break;
                case 3:
                    deleteStudent(scanner, students, studentTree, studentTable, actionHistory);
                    break;
                case 4:
                    students.displayAllStudents();
                    break;
                case 5:
                    addServiceRequest(scanner, students, serviceRequests, actionHistory);
                    break;
                case 6:
                    processNextRequest(serviceRequests, actionHistory);
                    break;
                case 7:
                    actionHistory.display();
                    break;
                case 8:
                    studentTree.displayInorder();
                    break;
                case 9:
                    searchStudent(scanner, studentTable);
                    break;
                case 10:
                    addCampusLocation(scanner, campus, actionHistory);
                    break;
                case 11:
                    removeCampusLocation(scanner, campus, actionHistory);
                    break;
                case 12:
                    addCampusConnection(scanner, campus, actionHistory);
                    break;
                case 13:
                    removeCampusConnection(scanner, campus, actionHistory);
                    break;
                case 14:
                    campus.displayConnections();
                    break;
                case 15:
                    traverseCampus(scanner, campus);
                    break;
                case 16:
                    running = false;
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid menu choice. Please choose a number from 1 to 16.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== University Student Record and Campus Route System ===");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Student Records using Linked List");
        System.out.println("5. Add Student Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS or DFS");
        System.out.println("16. Exit");
    }

    private static void addStudent(Scanner scanner, StudentLinkedList students,
                                   StudentBST studentTree, StudentHashTable studentTable,
                                   ActionStack actionHistory) {
        String id = InputValidator.readRequiredText(scanner, "Student ID: ");
        if (students.findStudent(id) != null) {
            System.out.println("A student with that ID already exists.");
            return;
        }
        String name = InputValidator.readRequiredText(scanner, "Name: ");
        String programme = InputValidator.readRequiredText(scanner, "Programme: ");
        double marks = InputValidator.readMarks(scanner);
        Student student = new Student(id, name, programme, marks);

        // All structures keep the same Student object, so later edits stay consistent.
        if (students.addStudent(student)) {
            studentTree.insert(student);
            studentTable.insert(student);
            actionHistory.push("Added student " + id);
            System.out.println("Student added to Linked List, BST, and Hash Table.");
        } else {
            System.out.println("A student with that ID already exists.");
        }
    }

    private static void updateStudent(Scanner scanner, StudentLinkedList students,
                                      ActionStack actionHistory) {
        String id = InputValidator.readRequiredText(scanner, "Student ID to update: ");
        Student existing = students.findStudent(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }
        String name = InputValidator.readRequiredText(scanner, "New name: ");
        String programme = InputValidator.readRequiredText(scanner, "New programme: ");
        double marks = InputValidator.readMarks(scanner);
        students.updateStudent(id, name, programme, marks);
        actionHistory.push("Updated student " + id);
        System.out.println("Student updated in Linked List, BST, and Hash Table.");
    }

    private static void deleteStudent(Scanner scanner, StudentLinkedList students,
                                      StudentBST studentTree, StudentHashTable studentTable,
                                      ActionStack actionHistory) {
        String id = InputValidator.readRequiredText(scanner, "Student ID to delete: ");
        if (!students.deleteStudent(id)) {
            System.out.println("Student not found.");
            return;
        }
        studentTree.delete(id);
        studentTable.delete(id);
        actionHistory.push("Deleted student " + id);
        System.out.println("Student deleted from Linked List, BST, and Hash Table.");
    }

    private static void searchStudent(Scanner scanner, StudentHashTable studentTable) {
        String id = InputValidator.readRequiredText(scanner, "Student ID to search: ");
        Student student = studentTable.search(id);
        System.out.println(student == null ? "Student not found." : student);
    }

    private static void addServiceRequest(Scanner scanner, StudentLinkedList students,
                                          ServiceQueue serviceRequests, ActionStack actionHistory) {
        String id = InputValidator.readRequiredText(scanner, "Student ID for the request: ");
        if (students.findStudent(id) == null) {
            System.out.println("Student not found. Cannot add a service request.");
            return;
        }
        String description = InputValidator.readRequiredText(scanner, "Request description: ");
        String request = id + ": " + description;
        serviceRequests.enqueue(request);
        actionHistory.push("Queued service request for " + id);
        System.out.println("Service request added to the queue.");
    }

    private static void processNextRequest(ServiceQueue serviceRequests, ActionStack actionHistory) {
        String request = serviceRequests.dequeue();
        if (request == null) {
            System.out.println("There are no service requests to process.");
        } else {
            actionHistory.push("Processed service request: " + request);
            System.out.println("Processed request: " + request);
        }
    }

    private static void addCampusLocation(Scanner scanner, CampusGraph campus,
                                          ActionStack actionHistory) {
        String name = InputValidator.readRequiredText(scanner, "Campus location name: ");
        if (campus.addLocation(name)) {
            actionHistory.push("Added campus location " + name);
            System.out.println("Campus location added.");
        } else {
            System.out.println("Location already exists or the name is invalid.");
        }
    }

    private static void removeCampusLocation(Scanner scanner, CampusGraph campus,
                                             ActionStack actionHistory) {
        String name = InputValidator.readRequiredText(scanner, "Campus location to remove: ");
        if (campus.removeLocation(name)) {
            actionHistory.push("Removed campus location " + name + " and its connections");
            System.out.println("Campus location and its connections removed.");
        } else {
            System.out.println("Campus location not found.");
        }
    }

    private static void addCampusConnection(Scanner scanner, CampusGraph campus,
                                           ActionStack actionHistory) {
        String first = InputValidator.readRequiredText(scanner, "First location: ");
        String second = InputValidator.readRequiredText(scanner, "Second location: ");
        if (campus.addConnection(first, second)) {
            actionHistory.push("Added campus connection " + first + " - " + second);
            System.out.println("Campus connection added.");
        } else {
            System.out.println("Connection not added. Check that both locations exist, differ, and are not already connected.");
        }
    }

    private static void removeCampusConnection(Scanner scanner, CampusGraph campus,
                                              ActionStack actionHistory) {
        String first = InputValidator.readRequiredText(scanner, "First location: ");
        String second = InputValidator.readRequiredText(scanner, "Second location: ");
        if (campus.removeConnection(first, second)) {
            actionHistory.push("Removed campus connection " + first + " - " + second);
            System.out.println("Campus connection removed.");
        } else {
            System.out.println("Connection not found. Check that both locations exist and are connected.");
        }
    }

    private static void traverseCampus(Scanner scanner, CampusGraph campus) {
        System.out.println("1. Breadth-First Search (BFS)");
        System.out.println("2. Depth-First Search (DFS)");
        int method = InputValidator.readInt(scanner, "Choose traversal (1 or 2): ");
        if (method != 1 && method != 2) {
            System.out.println("Invalid traversal choice.");
            return;
        }
        String start = InputValidator.readRequiredText(scanner, "Starting campus location: ");
        if (method == 1) campus.bfs(start);
        else campus.dfs(start);
    }
}
