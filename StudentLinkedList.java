/** A simple custom singly linked list for storing students. */
public class StudentLinkedList {
    private static class Node {
        private final Student student;
        private Node next;

        private Node(Student student) { this.student = student; }
    }

    private Node head;

    /** Adds a student unless the ID is already in the list. */
    public boolean addStudent(Student student) {
        if (student == null || findStudent(student.getStudentId()) != null) return false;
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        return true;
    }

    /** Finds and returns a student by ID, or null if there is no match. */
    public Student findStudent(String studentId) {
        Node current = head;
        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId)) return current.student;
            current = current.next;
        }
        return null;
    }

    /** Updates the non-ID details of a student. */
    public boolean updateStudent(String studentId, String name, String programme, double marks) {
        Student student = findStudent(studentId);
        if (student == null) return false;
        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);
        return true;
    }

    /** Removes a student by ID. */
    public boolean deleteStudent(String studentId) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {
                if (previous == null) head = current.next;
                else previous.next = current.next;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    /** Prints every student, or a message when the list is empty. */
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}
