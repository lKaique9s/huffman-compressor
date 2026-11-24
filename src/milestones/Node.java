package milestones;


public class Node implements Comparable<Node> {
    private int symbol;
    private int freq;
    private Node leftChild;
    private Node rightChild;
    private int orderCreated;

    public Node(int symbol, int freq, Node leftChild, Node rightChild, int orderCreated){
        this.symbol = symbol;
        this.freq = freq;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.orderCreated = orderCreated;
    }

    @Override
    public int compareTo(Node other){
        int comparator = Integer.compare(this.freq, other.freq);
        if(comparator == 0)
            return Integer.compare(this.orderCreated, other.orderCreated);
        return comparator;
    }

    public int getSymbol() {
        return symbol;
    }

    public int getFreq() {
        return freq;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getOrderCreated(){
        return orderCreated;
    }

}
