/**
 * A simple hash table implemented using an array of linked lists. Each element
 * in the array can point to the first node of a chain of nodes.
 */
public class HashTable<E extends Comparable<E>> {

    /** Underlying array of Node chains */
    private Node[] underlying;

    /** Default size for the underlying array */
    private static final int DEFAULT_SIZE = 4;

    /** Basic constructor with user-specified size */
    public HashTable(int size) {
        this.underlying = new Node[size];
    }

    /** Default constructor */
    public HashTable() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adds a new node containing the specified content to the appropriate
     * position in the underlying array, determined by the content's hash code.
     * If a collision occurs (the spot is already occupied), the new node becomes
     * the head of the chain at that spot.
     */
    public void add(E content) {
        // Create the node
        Node<E> newNode = new Node<E>(content);

        // Get the hashcode and calculate index
        int hash = content.hashCode();
        int index = Math.abs(hash % this.underlying.length);

        // If the position is empty, place the new node
        if (this.underlying[index] == null) {
            this.underlying[index] = newNode;
        } else {
            // Collision: attach current head to newNode, then put newNode at the head
            newNode.setNext(this.underlying[index]);
            this.underlying[index] = newNode;
        }
    } // method add

    /**
     * Returns a formatted string that displays the contents of the hash table.
     * Each index shows its chain of nodes, if any.
     */
    public String toString() {
        String result = "HashTable contents:\n";
        for (int i = 0; i < this.underlying.length; i++) {
            result += "Index " + i + ": ";
            if (this.underlying[i] == null) {
                result += "empty\n";
            } else {
                Node current = this.underlying[i];
                while (current != null) {
                    result += current.toString();
                    if (current.hasNext()) {
                        result += " -> ";
                    }
                    current = current.getNext();
                }
                result += "\n";
            }
        }
        return result;
    } // method toString
} // class HashTable
