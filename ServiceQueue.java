/** A custom first-in, first-out queue for student service requests. */
public class ServiceQueue {
    private static class Node {
        private final String request;
        private Node next;

        private Node(String request) {
            this.request = request;
        }
    }

    private Node front;
    private Node rear;

    /** Adds a service request at the rear of the queue. */
    public void enqueue(String request) {
        Node newNode = new Node(request);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    /** Removes and returns the earliest request, or null if empty. */
    public String dequeue() {
        if (isEmpty()) return null;
        String request = front.request;
        front = front.next;
        if (front == null) rear = null;
        return request;
    }

    /** Returns the earliest request without removing it, or null if empty. */
    public String peek() {
        return isEmpty() ? null : front.request;
    }

    public boolean isEmpty() {
        return front == null;
    }

    /** Displays requests from the front to the rear of the queue. */
    public void display() {
        if (isEmpty()) {
            System.out.println("Service request queue is empty.");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.println(current.request);
            current = current.next;
        }
    }
}
