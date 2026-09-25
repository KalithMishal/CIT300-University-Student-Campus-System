import java.util.Locale;

/** A custom hash table using separate chaining to handle collisions. */
public class StudentHashTable {
    private static final int TABLE_SIZE = 11;

    private static class Node {
        private final Student student;
        private Node next;

        private Node(Student student, Node next) {
            this.student = student;
            this.next = next;
        }
    }

    // Each array position is a bucket; nodes in a bucket form a linked chain.
    private final Node[] buckets = new Node[TABLE_SIZE];

    /** Inserts a student; returns false for null or a duplicate ID. */
    public boolean insert(Student student) {
        if (student == null || search(student.getStudentId()) != null) return false;
        int index = hash(student.getStudentId());
        buckets[index] = new Node(student, buckets[index]);
        return true;
    }

    /** Searches by ID and returns null if there is no matching student. */
    public Student search(String studentId) {
        if (studentId == null) return null;
        int index = hash(studentId);
        Node current = buckets[index];
        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId)) return current.student;
            current = current.next;
        }
        return null;
    }

    /** Deletes a student by ID; returns false when the ID is missing. */
    public boolean delete(String studentId) {
        if (studentId == null) return false;
        int index = hash(studentId);
        Node current = buckets[index];
        Node previous = null;
        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {
                if (previous == null) buckets[index] = current.next;
                else previous.next = current.next;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    /** Displays all stored students, grouped by bucket. */
    public void display() {
        boolean foundAny = false;
        for (int i = 0; i < buckets.length; i++) {
            Node current = buckets[i];
            if (current != null) {
                foundAny = true;
                System.out.println("Bucket " + i + ":");
                while (current != null) {
                    System.out.println("  " + current.student);
                    current = current.next;
                }
            }
        }
        if (!foundAny) System.out.println("Student hash table is empty.");
    }

    /** Lowercase IDs first so case-insensitive IDs use the same bucket. */
    private int hash(String studentId) {
        return Math.floorMod(studentId.toLowerCase(Locale.ROOT).hashCode(), TABLE_SIZE);
    }
}
