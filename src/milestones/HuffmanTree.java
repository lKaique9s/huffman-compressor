package milestones;

import java.util.PriorityQueue;

public class HuffmanTree {
    private Node root;
    private int counter = 0;


    public Node buildTree(int[] freq) {
        counter = 0;
        root = null;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                queue.add(new Node(i, freq[i], null, null, ++counter));
            }
        }
        if(queue.size() == 0){
            throw new IllegalArgumentException("Arquivo vazio!");
        }

        while (queue.size() > 1) {
            Node firstNode = queue.poll();
            Node secondNode = queue.poll();
            queue.add(new Node(-1,
                    firstNode.getFreq() + secondNode.getFreq(),
                    firstNode, secondNode, ++counter));
        }

        this.root = queue.poll();
        return this.root;
    }

    public void printTree(Node node, int depth){
        if(node == null)
            return;
        int aux = depth;
        while(aux>0){
            System.out.print("    ");
            aux--;
        }

        if(node.isLeaf()){
            System.out.println((char) node.getSymbol() + " | " + node.getFreq());
        }else {
            System.out.println(node.getFreq());
        }

        printTree(node.getLeftChild(),depth+1);
        printTree(node.getRightChild(), depth+1);
    }

}
