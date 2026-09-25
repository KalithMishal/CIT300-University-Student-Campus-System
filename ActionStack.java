/** A custom last-in, first-out stack for recent system actions. */
public class ActionStack {
    private static class Node {
        private final String action;
        private Node next;

        private Node(String action, Node next) {
            this.action = action;
            this.next = next;
        }
    }

    private Node top;

    /** Adds an action to the top of the stack. */
    public void push(String action) {
        top = new Node(action, top);
    }

    /** Removes and returns the most recently added action, or null if empty. */
    public String pop() {
        if (isEmpty()) return null;
        String action = top.action;
        top = top.next;
        return action;
    }

    /** Returns the most recent action without removing it, or null if empty. */
    public String peek() {
        return isEmpty() ? null : top.action;
    }

    public boolean isEmpty() {
        return top == null;
    }

    /** Displays actions from newest to oldest. */
    public void display() {
        if (isEmpty()) {
            System.out.println("Action history is empty.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println(current.action);
            current = current.next;
        }
    }
}
