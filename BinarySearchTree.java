public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    private Node<E> root;
    private int size = 0;

    public BinarySearchTree() {
        root = null;
    }
    public BinarySearchTree(E val) {
        root = new Node(val);
        size = 1;
    }
    
    // returns true if BST has val else false.
    public boolean contains (E val) {
        return containsRecursive(root, val);
    }

    // This method is recursive in that it will run through all the nodes of the binary tree
    // until the value is either found or it does not exist
    // The node parameter is created because if the method were to only use root, then it would recurse only on the root
    // and not the left or right child.
    public boolean containsRecursive(Node<E> node, E val){
        if(node == null){
            return false;
        }
        // If the value and the value at the node is the same it will return true
        if(val.compareTo(node.getInfo()) == 0){
            return true;
        }
        // If val is < node.getInfo(), starting at the root, then it will return negative, so it checks that it is below 0
        // and if it is below 0 then it knows to search the left child.
        // If the conditions are met then it will return containsRecursive(node.left, val)
        // which will search through the left child and runs a recursive loop until either the value found
        // is false or true.
        else if(val.compareTo(node.getInfo()) < 0 && node.left != null){
            return containsRecursive(node.left, val);
        }
        // If val is > node.getInfo(), starting at the root, then it will return negative, so it checks that it is above 0
        // and if it is above 0 then it knows to search the right child.
        // If the conditions are met then it will return containsRecursive(node.right, val)
        // which will search through the right child and runs a recursive loop until either the value found
        // is false or true.
        else if(val.compareTo(node.getInfo()) > 0 && node.right != null){
            return containsRecursive(node.right, val);
        }
        else
            return false;
    }

    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
    // if value is already there then don’t insert it again
    public void insert(E val) {
        // If no root is found then it will create one for the BST
        if (root == null){
            root = new Node<E>(val);
        }
        else
            returnRecursive(root, val);
    }

    // This method works in a similar way that the containsRecursive() method runs.
    // It will check to see if the node already exists, and if it does not then it will
    // continue through the BST accordingly. It will check to see that each value it is compared
    // to will either be less or above the current node. This will loop until a node is created
    // for the value in the correct place and if it already exists then nothing will change.
    public void returnRecursive(Node<E> node, E val) {
        // Will check if the node already exists and if it doesn't then it will create a new node
        // otherwise will run recursively on the left node
        // node.left is the left node from the Node class.
        if (val.compareTo(node.getInfo()) < 0){
            if(node.left == null)
                node.left = new Node(val);
            else
                returnRecursive(node.left, val);

        }
        // Will check if the node already exists and if it doesn't then it will create a new node
        // otherwise will run recursively on the right node
        // node.right is the right node from the Node class.
        if(val.compareTo(node.getInfo()) > 0)
            if(node.right == null)
                node.right = new Node(val);
            else
                returnRecursive(node.right, val);

    }
    // returns the minimum value stored in the tree
    public E findMin() {
        Node<E> temp = root;
        // while loop will run until there is no longer a node that has a left child.
        // temp is then assigned to the next node in the left child and will return
        // the node with the minimum value in the BST. The node that does not have a left
        // child will be the minimum value.
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.getInfo();
    }

    // returns the maximum value stored in the tree
    public E findMax() {
        Node<E> temp = root;
        // while loop will run until there is no longer a node that has a right child.
        // temp is then assigned to the next node in the right child and will return
        // the node with the maximum value in the BST. The node that does not have a right
        // child will be the maximum value.
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.getInfo();
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
        bt.inOrder(bt.root);
        System.out.println();
        System.out.println(bt.findMin());
        System.out.println(bt.findMax());
        System.out.println(bt.contains(20));

        System.out.println();

        BinarySearchTree<Integer> bt2 = new BinarySearchTree<>(30);
        bt2.insert(7);
        bt2.insert(11);
        bt2.insert(35);
        bt2.insert(23);
        bt2.insert(87);
        bt2.insert(41);
        bt2.inOrder(bt2.root);
        System.out.println();
        System.out.println(bt2.findMin());
        System.out.println(bt2.findMax());
        System.out.println(bt2.contains(20));
    }
    
             
}