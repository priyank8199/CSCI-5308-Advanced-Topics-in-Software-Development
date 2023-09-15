package Assignment2;


public class NodeManager {

    public SearchTree searchTree;

    public NodeManager rootNode;

    /**
     * key value to store String value in the Node
     */
    public String key;

    /**
     * count variable to store the number of occurance of key when find() is called
     */
    public int count;

    /**
     * node to store child nodes and parent node
     */
    NodeManager left, right, parent;

    /**
     * Constructor Node to initialize node values
     * @param key String value
     * @param count int value of occurance of key
     * @param left Node left node of tree
     * @param right Node right node of tree
     * @param parent Node parent or root node of tree
     */
    public NodeManager(String key, int count, NodeManager left, NodeManager right, NodeManager parent) {
        this.key = key;
        this.count = count;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }






    public String print(SearchTree searchTree){
        String tree= "";
        NodeManager current, pre;

        if (rootNode == null) {
            return null;
        }

        current = rootNode;
        while (current != null) {
            if (current.left == null) {
                int height = searchTree.depth(current.key);
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
                    int height = searchTree.depth(current.key);
                    tree += current.key + " " + height + '\n';
                    current = current.right;
                }

            }

        }
        return tree;
    }
    public int getDepth(SearchTree searchTree) {
        int depth = 0;
        searchTree.find("ABC");
        NodeManager currentNode = this;

        while (currentNode != null) {
            currentNode = currentNode.parent;
            depth++;
        }

        return depth - 1;
    }
}
