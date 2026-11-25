import milestones.FrequencyCounter;
import milestones.HuffmanTree;
import milestones.Node;
import milestones.Reader;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            // 1. Ler o arquivo
            Reader reader = new Reader();
            byte[] data = reader.read(args);

            // 2. Contar as frequências
            FrequencyCounter frequencyCounter = new FrequencyCounter(data);

            System.out.println("\n===== TABELA DE FREQUÊNCIAS =====");

            for (Map.Entry<Integer, Integer> entry : frequencyCounter.getFrequencies()) {
                int symbol = entry.getKey();
                int frequency = entry.getValue();

                System.out.printf(
                        "Byte: %3d | Caractere: %c | Frequência: %d%n",
                        symbol,
                        (char) symbol,
                        frequency
                );
            }

            System.out.println("\nTotal de bytes: " +
                    frequencyCounter.calculateTotalFrequency());

            // 3. Construir a árvore de Huffman
            HuffmanTree huffmanTree = new HuffmanTree();

            Node root = huffmanTree.buildTree(frequencyCounter.getFreq());

            // 4. Imprimir a árvore
            System.out.println("\n===== ÁRVORE DE HUFFMAN =====");

            huffmanTree.printTree(root, 0);

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
