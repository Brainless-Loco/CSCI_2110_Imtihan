import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str;
        ArrayList<String> strs = new ArrayList<String>();

        System.out.println("Enter data for binary tree:");
        str = input.nextLine();

        String[] tempstrs = str.split("\\W+");
        for(int i =0;i<tempstrs.length;i++){
            strs.add(tempstrs[i]);
        }

        ArrayList<BinaryTree<String>> temp = new ArrayList<BinaryTree<String>>();
        BinaryTree<String> root=null;

        while(strs.isEmpty()==false){
            BinaryTree<String> t;
            if(root==null) {
                t = new BinaryTree<>();
                t.makeRoot(strs.get(0));
                root = t;
                strs.remove(0);
            }
            else{
                t=temp.get(0);
                temp.remove(0);
            }
            if(strs.size()>0){
                BinaryTree<String> l = new BinaryTree<>();
                l.makeRoot(strs.get(0));
                t.attachLeft(l);
                strs.remove(0);
                temp.add(l);
            }
            if(strs.size()>0){
                BinaryTree<String> r = new BinaryTree<>();
                r.makeRoot(strs.get(0));
                t.attachRight(r);
                strs.remove(0);
                temp.add(r);
            }
        }


        System.out.printf("Height of the tree is: %d\n", BinaryTree.height(root));

        System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(root));

        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(root);
        System.out.println();

        System.out.print("Preorder:\t");
        BinaryTree.preorder(root);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(root);
        System.out.println();

        System.out.print("Level order:\t");
        BinaryTree.levelOrder(root);
        System.out.println();
        System.out.println();

        System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(root) ? "Yes!" : "No.");

        System.out.println();


    }
}
