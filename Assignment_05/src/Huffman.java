import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PriorityQueue<BinaryTree<Pair>> S = readFile();
        BinaryTree<Pair> head = buildHuffmanTree(S);


        String str;

        System.out.print("Enter a line of text (uppercase letters only): ");
        str = input.nextLine();


        String[] huffmanCodes = findEncoding(head);


        String encodedText = encodeText(str, huffmanCodes);
        String decodedText = decodeText(encodedText, head);

        System.out.println("\nHere’s the encoded line: "+encodedText);

        System.out.println("\nThe decoded line is: "+decodedText);

    }

    private static PriorityQueue<BinaryTree<Pair>> readFile() {
        PriorityQueue<BinaryTree<Pair>> S = new PriorityQueue<>((a, b) -> {
            double diff = a.getData().getProbability() - b.getData().getProbability();
            return Double.compare(diff, 0);
        });

        try {
            FileReader file = new FileReader("src/LettersProbability.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if(line==null) break;

                String[] split = line.split("\\s+");


                char letter = split[0].charAt(0);
                double probability = Double.parseDouble(split[1]);

                Pair pair = new Pair(letter, probability);
                BinaryTree<Pair> tree = new BinaryTree<Pair>();
                tree.makeRoot(pair);
                S.add(tree);
            }
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }

        return S;
    }

    private static BinaryTree<Pair> buildHuffmanTree(PriorityQueue<BinaryTree<Pair>> S) {
        PriorityQueue<BinaryTree<Pair>> T = new PriorityQueue<>((a, b) -> {
            double diff = a.getData().getProbability() - b.getData().getProbability();
            return Double.compare(diff, 0);
        });

        while (S.size() + T.size() > 1) {
            BinaryTree<Pair> A = getSmaller(S, T);
            BinaryTree<Pair> B = getSmaller(S, T);

            Pair newPair = new Pair((char) 0, A.getData().getProbability() + B.getData().getProbability());
            BinaryTree<Pair> P = new BinaryTree<>();
            P.makeRoot(newPair);
            P.attachLeft(A);
            P.attachRight(B);

            T.add(P);
        }
        return T.poll();
    }

    private static BinaryTree<Pair> getSmaller(PriorityQueue<BinaryTree<Pair>> S, PriorityQueue<BinaryTree<Pair>> T) {
        if (T.isEmpty() || (S.size()>0 && S.peek().getData().getProbability() < T.peek().getData().getProbability())) {
            return S.poll();
        }
        else {
            return T.poll();
        }
    }

    private static String[] findEncoding(BinaryTree<Pair> binaryTree) {
        String[] result = new String[26];
        findEncoding(binaryTree, result, "");
        return result;
    }

    private static void findEncoding(BinaryTree<Pair> binaryTree, String[] str, String prefix) {
        if (binaryTree != null && binaryTree.getData() != null) {

            if (binaryTree.getData().getValue() != 0) {
                str[binaryTree.getData().getValue() - 'A'] = prefix;
            }

            if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
                return;
            }
            else{
                findEncoding(binaryTree.getLeft(), str, prefix + "0");
                findEncoding(binaryTree.getRight(), str, prefix + "1");
            }
        }
    }

    private static String encodeText(String text, String[] huffmanCodes) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if(c==' '){
                encodedText.append(' ');
                continue;
            }
            int index = c - 'A';
            encodedText.append(huffmanCodes[index]);
        }
        return encodedText.toString();
    }

    private static String decodeText(String encodedText, BinaryTree<Pair> huffmanTree) {
        StringBuilder decodedText = new StringBuilder();
        BinaryTree<Pair> current = huffmanTree;
        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = current.getLeft();
            }
            else if (bit == '1') {
                current = current.getRight();
            }
            else{
                decodedText.append(' ');
                continue;
            }

            if (current != null && current.getData() != null) {
                char decodedChar = current.getData().getValue();
                if (decodedChar != 0) {
                    decodedText.append(decodedChar);
                    current = huffmanTree; // Reset to the root for the next character
                }
            }
        }
        return decodedText.toString();
    }

}
