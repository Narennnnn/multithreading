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

    // Preorder traversal (Root -> Left -> Right)
    private void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }

    // Inorder traversal (Left -> Root -> Right)
    private void inorder(Node root) {
        if (root != null) {
            inorder(root.leftChild); 
            System.out.print(root.data + " ");
            inorder(root.rightChild); 
        }
    }

    // Postorder traversal (Left -> Right -> Root)
    private void postorder(Node root) {
        if (root != null) {
            postorder(root.leftChild); 
            postorder(root.rightChild);
            System.out.print(root.data + " ");
        }
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

        // Traversals
        System.out.println("\nPreOrder Traversal: ");
        treeOps.preorder(treeNode);

        System.out.println("\nInOrder Traversal: ");
        treeOps.inorder(treeNode);

        System.out.println("\nPostOrder Traversal: ");
        treeOps.postorder(treeNode);
    }
}
