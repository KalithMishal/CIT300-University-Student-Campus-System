/** A custom binary search tree ordered by student ID. */
public class StudentBST {
    private static class Node {
        private Student student;
        private Node left;
        private Node right;

        private Node(Student student) {
            this.student = student;
        }
    }

    private Node root;

    /** Inserts a student; returns false for null or a duplicate ID. */
    public boolean insert(Student student) {
        if (student == null || student.getStudentId() == null) return false;
        if (search(student.getStudentId()) != null) return false;
        root = insertAt(root, student);
        return true;
    }

    private Node insertAt(Node current, Student student) {
        if (current == null) return new Node(student);
        int comparison = student.getStudentId().compareToIgnoreCase(current.student.getStudentId());
        if (comparison < 0) current.left = insertAt(current.left, student);
        else current.right = insertAt(current.right, student);
        return current;
    }

    /** Searches by ID and returns null if there is no matching student. */
    public Student search(String studentId) {
        if (studentId == null) return null;
        Node current = root;
        while (current != null) {
            int comparison = studentId.compareToIgnoreCase(current.student.getStudentId());
            if (comparison == 0) return current.student;
            current = comparison < 0 ? current.left : current.right;
        }
        return null;
    }

    /** Deletes the student with this ID; returns false when it is missing. */
    public boolean delete(String studentId) {
        if (studentId == null) return false;
        if (search(studentId) == null) return false;
        root = deleteAt(root, studentId);
        return true;
    }

    private Node deleteAt(Node current, String studentId) {
        int comparison = studentId.compareToIgnoreCase(current.student.getStudentId());
        if (comparison < 0) {
            current.left = deleteAt(current.left, studentId);
        } else if (comparison > 0) {
            current.right = deleteAt(current.right, studentId);
        } else {
            // A missing child means this node can be replaced by its other child.
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // With two children, copy the smallest student from the right subtree.
            Node successor = findSmallest(current.right);
            current.student = successor.student;
            current.right = deleteAt(current.right, successor.student.getStudentId());
        }
        return current;
    }

    private Node findSmallest(Node current) {
        while (current.left != null) current = current.left;
        return current;
    }

    /** Displays students in ascending student ID order. */
    public void displayInorder() {
        if (root == null) {
            System.out.println("Student BST is empty.");
            return;
        }
        inorder(root);
    }

    /** Public name for the inorder traversal/display operation. */
    public void inorderTraversal() {
        displayInorder();
    }

    private void inorder(Node current) {
        if (current == null) return;
        inorder(current.left);
        System.out.println(current.student);
        inorder(current.right);
    }
}
