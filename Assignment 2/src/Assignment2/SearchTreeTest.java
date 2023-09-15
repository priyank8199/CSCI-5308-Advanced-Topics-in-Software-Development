package Assignment2;

/**
 * Class SearchTreeTest is driver class tp test SearchTree class
 * @Author Priyank Patel
 */
public class SearchTreeTest {

    /**
     * Main Method (Entry point of the Program)
     * @param args String array
     */
    public static void main(String args[]){


        // Creating Object of Search Tree Class
        SearchTree st = new SearchTree();

        AVLTree avlTree = new AVLTree();

        avlTree.find("Egg");

        // Calling find method to check in an empty tree
        st.find("Egg");

        // Printing empty tree
        System.out.println(st.printTree());

        // Adding empty and null value to the tree
        st.add("");
        st.add(null);


        // Checking if empty and null value is added in the tree or not
        System.out.println("Depth is " + st.find(""));
        System.out.println("Depth is " + st.find(null));

        //System.out.println(st.printTree());

        // adding elements into the tree
        st.add("Egg");
        st.add("Date");
        st.add("Lentil");
        st.add("Carrot");
        st.add("Parrot");
        st.add("Grape");
        st.add("Yak");
        st.add("Apple");
        st.add("Deer");
        st.add("Dog");
        st.add("Elephant");
        st.add("Fruit");
        st.add("Halifax");
        st.add("Tomato");
        st.add("Zebra");

        //Printing tree
        //System.out.println(st.printTree());

        //Calling find method
        System.out.println("Depth is " + st.find("Egg"));
        System.out.println("Depth is " + st.find("Date"));
        System.out.println("Depth is " + st.find("Lentil"));
        System.out.println("Depth is " + st.find("Carrot"));
        System.out.println("Depth is " + st.find("Parrot"));
        System.out.println("Depth is " + st.find("Grape"));
        System.out.println("Depth is " + st.find("Yak"));
        System.out.println("Depth is " + st.find("Apple"));
        System.out.println("Depth is " + st.find("Dog"));
        System.out.println("Depth is " + st.find("Deer"));
        System.out.println("Depth is " + st.find("Elephant"));
        System.out.println("Depth is " + st.find("Fruit"));
        System.out.println("Depth is " + st.find("Halifax"));
        System.out.println("Depth is " + st.find("Tomato"));
        System.out.println("Depth is " + st.find("Zebra"));
        System.out.println("Depth is " + st.find("Apple"));
        System.out.println("Depth is " + st.find("Apple"));
        System.out.println("Depth is " + st.find("Apple"));

        BinaryTree bt = new BinaryTree();
        bt.find("Egg");

        // Printing tree
        //System.out.println(st.printTree());

        //Calling reset
        st.reset();

        //System.out.println(st.printTree());

        //Calling reset twice
        st.reset();
        st.reset();

        //Adding single character
        st.add("a");

        //Adding large string
        st.add("asdfghjklqwertyyui");

        //finding both strings
        System.out.println(st.find("a"));
        System.out.println(st.find("asdfghjklqwertyyui"));

        //adding Linked List
        st.add("ABC");
        st.add("ABC");
        st.add("BCD");
        st.add("CDE");
        st.add("EFG");

        //printing linked lust
        //System.out.println(st.printTree());

        //Finding item not in the key
        //System.out.println(st.find("QWE"));

    }

}
