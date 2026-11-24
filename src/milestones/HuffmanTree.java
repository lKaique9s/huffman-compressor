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

}
