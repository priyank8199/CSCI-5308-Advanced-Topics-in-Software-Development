package Assignment2;

public class BinaryTree extends SearchTree{

    public NodeManager nodeManager;
    public NodeManager rootNode;
    public Type type;
    public BinaryTree(){

    }

    public static class Type{
        String name;
        public Type(){
            name = "Binary Tree";
        }
    }

    @Override
    public int find(String key) {
        return super.find(key);
    }
}
