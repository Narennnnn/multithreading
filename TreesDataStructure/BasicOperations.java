package TreesDataStructure;
import java.util.*;

class Node {
    public int data;
    public Node leftChild;
    public Node rightChild;

    public Node() {}

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BasicOperations {
    // Method to insert a node in the binary search tree
    public void insert(Node root, int data) {
        Node tempNode = new Node(data); // Create a new node
        if (root == null) { // If root is null, make the new node the root
            root = tempNode;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;

                // Go to left of the tree
                if (data < parent.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = tempNode; // Insert to the left
                        return;
                    }
                } else { // Go to right of the tree
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = tempNode; // Insert to the right
                        return;
                    }
                }
            }
        }
    }

    // Method to search for a node in the binary search tree
    public Node search(int data, Node root) {
        Node current = root;
        System.out.print("Visiting elements: ");
        while (current != null && current.data != data) {
            System.out.print(current.data + " ");

            // Go to left tree
            if (current.data > data) {
                current = current.leftChild;
            } else { // Go to right tree
                current = current.rightChild;
            }
        }

        return current; // Return the found node, or null if not found
    }

    public static void main(String[] args) {
        BasicOperations treeOps = new BasicOperations();
        
        // Create the root node
        Node treeNode = new Node(100);

        // Insert nodes
        treeOps.insert(treeNode, 50);
        treeOps.insert(treeNode, 150);
        treeOps.insert(treeNode, 25);
        treeOps.insert(treeNode, 75);

        // Search for a node
        Node result = treeOps.search(75, treeNode);
        if (result != null) {
            System.out.println("\nNode found: " + result.data);
        } else {
            System.out.println("\nNode not found.");
        }
    }
}
