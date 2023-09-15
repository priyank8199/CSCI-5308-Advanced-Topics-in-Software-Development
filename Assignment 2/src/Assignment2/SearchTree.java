package Assignment2;

/**
 * Class SearchTree which implement an unbalanced Binary Search Tree
 * @Author Priyank Patel
 */
public class SearchTree {
    public NodeManager nodeManager;

    public SearchTree st;

    public SearchTree(){

    }


    /**
     * String tree to store the details of tree that is to be printed
     */
    public String tree = "";

    /**
     * Class Node to create new node
     */
    //private static class Node {
        /**
         * key value to store String value in the Node
         */
        //public String key;

        /**
         * count variable to store the number of occurance of key when find() is called
         */
        //public int count;

        /**
         * node to store child nodes and parent node
         */
        //Node left, right, parent;

        /**
         * Constructor Node to initialize node values
         * @param key String value
         * @param count int value of occurance of key
         * @param left Node left node of tree
         * @param right Node right node of tree
         * @param parent Node parent or root node of tree
         */
        /*public Node(String key, int count, Node left, Node right, Node parent) {
            this.key = key;
            this.count = count;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }*/

    /**
     * root node to store the root element
     */
    private NodeManager rootNode;

    /**
     * Search tree Constructor to initialize rootNode
     */
    /*public SearchTree() {
        rootNode = null;
    }*/

    /**
     * Add method to add elements to Binary Search Tree
     * @param key String value
     * @return true if element is added or else false
     */
    public boolean add(String key) {

        //Checking for null or empty key value
        if (key == null || key.isEmpty()) {
            return false;
        }
        //adding root node if no node is present
        if (rootNode == null) {
            rootNode = new NodeManager(key, 0, null, null, null);
            return true;
        }
        return add(rootNode, key);

    }

    /**
     * Private add method to add elements to BST
     * @param node
     * @param key
     * @return true is added or else false
     */
    private boolean add(NodeManager node, String key) {

        // if key value is less than root than adding in left nide
        if (key.toLowerCase().compareTo(node.key.toLowerCase()) > 0) {
            if (node.right == null) {
                node.right = new NodeManager(key, 0, null, null, node);
                return true;
            } else {
                return add(node.right, key);
            }

            //if jey value is greater than root than adding in right node
        } else if (key.toLowerCase().compareTo(node.key.toLowerCase()) < 0) {
            if (node.left == null) {
                node.left = new NodeManager(key, 0, null, null, node);
                return true;
            } else {
                return add(node.left, key);
            }
        } else {
            return false;
        }

    }

    /**
     * find method to find element in the BST
     * @param key
     * @return depth of the tree
     */
    public int find(String key) {
        // checking fir null or empty key
        if (key == null || key.isEmpty() || key == " ") {
            return 0;
        }
        return find(key, rootNode);
    }

    /***
     * Private find to get depth of BST
     * @param key
     * @param rootNode
     * @return depth of node
     */
    private int find(String key, NodeManager rootNode) {
        int depth = 1;
        NodeManager node = rootNode;
        if (rootNode == null) {
            return 0;
        }
        while (node != null) {

            if (key.toLowerCase().compareTo(node.key.toLowerCase()) < 0) {
                node = node.left;
                depth++;
            } else if (key.toLowerCase().compareTo(node.key.toLowerCase()) > 0) {
                node = node.right;
                depth++;
            } else {
                node.count++;
                //System.out.println(node.key + " " + node.count);
                shiftTreeStructure(node);
                return depth;
            }
        }
        return 0;
    }


    /**
     * shiftTreeStructure to rotate the BST according to count value
     * @param node
     */
    private void shiftTreeStructure(NodeManager node) {

        NodeManager parent = node.parent;

        NodeManager temp1;
        NodeManager temp2;

        if (parent == null) {
            return;
        } else {

            if (node.count > parent.count) {

                // Checks whether the node is on the left of the parent
                // Does right rotation on the BST
                if (parent.left == node) {
                    temp1 = node.right;
                    node.right = parent;

                    // Checking if the right of current node is not null
                    if (temp1 != null) {
                        temp1.parent = parent;
                    }
                    // Checking if the current node's parent's parent is null
                    // If yes then we assign the root to the current node
                    if (parent.parent == null) {
                        rootNode = node;
                    } else if (parent.parent.left == parent) {
                        parent.parent.left = node;
                    } else if (parent.parent.right == parent) {
                        parent.parent.right = node;
                    }
                    // Updating parent down link
                    temp2 = parent.parent;
                    parent.parent = node;
                    node.parent = temp2;
                    parent.left = temp1;

                    // Checks whether the node is on the right of the parent
                    // Does left rotation on the BST
                } else if (parent.right == node) {
                    temp1 = node.left;
                    node.left = parent;

                    // Checking if the left of current node is not null
                    if (temp1 != null) {
                        temp1.parent = parent;
                    }
                    // Checking if the current node's parent's parent is null
                    // If yes then we assign the root to the current node
                    if (parent.parent == null) {
                        rootNode = node;
                    } else if (parent.parent.left == parent) {
                        parent.parent.left = node;
                    } else if (parent.parent.right == parent) {
                        parent.parent.right = node;
                    }
                    // Updating parent down link
                    temp2 = parent.parent;
                    parent.parent = node;
                    node.parent = temp2;
                    parent.right = temp1;
                }
            }
        }
    }

    /**
     * resert node count value
     */
    public void reset() {
        reset(rootNode);
    }

    /**
     * private node count reset method
     * @param node
     */
    private void reset(NodeManager node) {

        if (node == null) {
            return;
        }

        reset(node.left);

        //set counter to 0
        node.count = 0;

        reset(node.right);
    }


    // Prints the sorted BST along with depth of each node
    public String printTree() {

        // Resetting the string tree after every printTree() is called
        tree = "";
        //nodeManager.print(new SearchTree(), nodeManager);
        return printTree(rootNode);
    }


    /**
     * private printTree method to print tree with depth
     * @param rootNode
     * @return String of tree
     */
    private String printTree(NodeManager rootNode) {
        NodeManager current, pre;

        if (rootNode == null) {
            return null;
        }

        current = rootNode;
        while (current != null) {
            if (current.left == null) {
                int height = depth(current.key);
                tree += current.key + " " + height + '\n';
                current = current.right;
            } else {

                //Find the inorder predecessor of current
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                //Make current as right child of its inorder predecessor
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                //Revert the changes made in the 'if' part to restore the original tree i.e., fix the right child of predecessor
                else {
                    pre.right = null;
                    int height = depth(current.key);
                    tree += current.key + " " + height + '\n';
                    current = current.right;
                }

            }

        }
        return tree;
    }

    /**
     * Gets the depth of node
     * @param key
     * @return int depth of node
     */
    public int depth(String key) {
        if (key == null || key.isEmpty()) {
            return 0;
        }
        //System.out.printf("Current Depth of node is:" + nodeManager.getDepth(st));
        return findDepth(key, rootNode);
    }

    /**
     * private method to get debth of node
     * @param key
     * @param rootNode
     * @return int depth
     */
    private int findDepth(String key, NodeManager rootNode) {
        int depth = 1;
        NodeManager node = rootNode;
        if (node == null) {
            return 0;
        }
        while (node != null) {

            if (key.toLowerCase().compareTo(node.key.toLowerCase()) < 0) {
                node = node.left;
                depth++;
            } else if (key.toLowerCase().compareTo(node.key.toLowerCase()) > 0) {
                node = node.right;
                depth++;
            } else {
                return depth;
            }
        }
        return 0;
    }
}
