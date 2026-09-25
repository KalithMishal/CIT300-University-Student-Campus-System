/** An undirected campus graph stored as custom adjacency lists. */
public class CampusGraph {
    private static class Location {
        private final String name;
        private Location next;
        private Connection firstConnection;
        private boolean visited;

        private Location(String name) {
            this.name = name;
        }
    }

    private static class Connection {
        private final Location destination;
        private Connection next;

        private Connection(Location destination, Connection next) {
            this.destination = destination;
            this.next = next;
        }
    }

    /** Linked list of all locations (vertices). */
    private Location firstLocation;

    /** Adds a location unless its name already exists. */
    public boolean addLocation(String name) {
        if (!isValidName(name) || findLocation(name) != null) return false;
        Location newLocation = new Location(name.trim());
        if (firstLocation == null) {
            firstLocation = newLocation;
        } else {
            Location current = firstLocation;
            while (current.next != null) current = current.next;
            current.next = newLocation;
        }
        return true;
    }

    /** Removes a location and all connections that point to it. */
    public boolean removeLocation(String name) {
        Location target = findLocation(name);
        if (target == null) return false;

        // Remove this location from every other location's adjacency list.
        Location current = firstLocation;
        while (current != null) {
            removeConnectionTo(current, target);
            current = current.next;
        }

        if (firstLocation == target) {
            firstLocation = target.next;
        } else {
            current = firstLocation;
            while (current.next != target) current = current.next;
            current.next = target.next;
        }
        return true;
    }

    /** Adds a bidirectional road between two different existing locations. */
    public boolean addConnection(String firstName, String secondName) {
        Location first = findLocation(firstName);
        Location second = findLocation(secondName);
        if (first == null || second == null || first == second) return false;
        if (hasConnection(first, second)) return false;

        first.firstConnection = new Connection(second, first.firstConnection);
        second.firstConnection = new Connection(first, second.firstConnection);
        return true;
    }

    /** Removes a bidirectional road if it exists. */
    public boolean removeConnection(String firstName, String secondName) {
        Location first = findLocation(firstName);
        Location second = findLocation(secondName);
        if (first == null || second == null || !hasConnection(first, second)) return false;

        removeConnectionTo(first, second);
        removeConnectionTo(second, first);
        return true;
    }

    /** Displays each location and its directly connected locations. */
    public void displayConnections() {
        if (firstLocation == null) {
            System.out.println("Campus graph has no locations.");
            return;
        }
        Location current = firstLocation;
        while (current != null) {
            System.out.print(current.name + " -> ");
            Connection connection = current.firstConnection;
            if (connection == null) {
                System.out.println("No connections");
            } else {
                while (connection != null) {
                    System.out.print(connection.destination.name);
                    if (connection.next != null) System.out.print(", ");
                    connection = connection.next;
                }
                System.out.println();
            }
            current = current.next;
        }
    }

    /** Traverses the connected part of the graph in breadth-first order. */
    public void bfs(String startingName) {
        Location start = findLocation(startingName);
        if (start == null) {
            System.out.println("Starting location not found.");
            return;
        }

        resetVisited();
        LocationQueue queue = new LocationQueue();
        start.visited = true;
        queue.enqueue(start);
        System.out.print("BFS: ");
        boolean firstOutput = true;

        while (!queue.isEmpty()) {
            Location current = queue.dequeue();
            if (!firstOutput) System.out.print(" -> ");
            System.out.print(current.name);
            firstOutput = false;

            Connection connection = current.firstConnection;
            while (connection != null) {
                Location neighbor = connection.destination;
                if (!neighbor.visited) {
                    neighbor.visited = true;
                    queue.enqueue(neighbor);
                }
                connection = connection.next;
            }
        }
        System.out.println();
    }

    /** Traverses the connected part of the graph in depth-first order. */
    public void dfs(String startingName) {
        Location start = findLocation(startingName);
        if (start == null) {
            System.out.println("Starting location not found.");
            return;
        }

        resetVisited();
        System.out.print("DFS: ");
        dfsFrom(start, true);
        System.out.println();
    }

    private void dfsFrom(Location current, boolean firstOutput) {
        current.visited = true;
        if (!firstOutput) System.out.print(" -> ");
        System.out.print(current.name);

        Connection connection = current.firstConnection;
        while (connection != null) {
            if (!connection.destination.visited) dfsFrom(connection.destination, false);
            connection = connection.next;
        }
    }

    private void resetVisited() {
        Location current = firstLocation;
        while (current != null) {
            current.visited = false;
            current = current.next;
        }
    }

    private Location findLocation(String name) {
        if (name == null) return null;
        Location current = firstLocation;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name.trim())) return current;
            current = current.next;
        }
        return null;
    }

    private boolean hasConnection(Location from, Location to) {
        Connection current = from.firstConnection;
        while (current != null) {
            if (current.destination == to) return true;
            current = current.next;
        }
        return false;
    }

    private void removeConnectionTo(Location from, Location target) {
        Connection current = from.firstConnection;
        Connection previous = null;
        while (current != null) {
            if (current.destination == target) {
                if (previous == null) from.firstConnection = current.next;
                else previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /** Small custom queue used by BFS; no collection classes are needed. */
    private static class LocationQueue {
        private static class QueueNode {
            private final Location location;
            private QueueNode next;

            private QueueNode(Location location) {
                this.location = location;
            }
        }

        private QueueNode front;
        private QueueNode rear;

        private void enqueue(Location location) {
            QueueNode node = new QueueNode(location);
            if (rear == null) front = node;
            else rear.next = node;
            rear = node;
        }

        private Location dequeue() {
            Location location = front.location;
            front = front.next;
            if (front == null) rear = null;
            return location;
        }

        private boolean isEmpty() {
            return front == null;
        }
    }
}
