import java.util.ArrayList;
import java.util.Random;

public class MainRd {
    public static void main(String[] args) {
        int n=2000000;
        Random random=new Random();
        ArrayList<Integer> testData=new ArrayList<>();
        for (int i=0;i<n;i++){
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        //TestBST
        long startTime=System.nanoTime();
        BST<Integer,Integer> bst=new BST<>();
        for(Integer x:testData)
            bst.add(x,null);
        long endtime=System.nanoTime();
        double time=(endtime-startTime)/1000000000.0;
        System.out.println("BST: "+time+" s");

        //Test AVL
        startTime=System.nanoTime();
        AVLTree<Integer,Integer> avl=new AVLTree<>();
        for(Integer x:testData)
            avl.add(x,null);
        endtime=System.nanoTime();
        double time2=(endtime-startTime)/1000000000.0;
        System.out.println("AVL: "+time2+" s");

        //Test RBtree
        startTime=System.nanoTime();
        RBTree<Integer,Integer> rbt=new RBTree<>();
        for(Integer x:testData)
            rbt.add(x,null);
        endtime=System.nanoTime();
        double time3=(endtime-startTime)/1000000000.0;
        System.out.println("RBT: "+time3+" s");


    }
}
