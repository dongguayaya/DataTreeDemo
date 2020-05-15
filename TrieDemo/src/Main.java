import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Pride");
        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)){
            long start=System.nanoTime();
            BSTSet<String> set=new BSTSet<>();
            for(String word:words)
                set.add(word);
            for(String word:words)
                set.contains(word);

            long end=System.nanoTime();
            double time=(end-start)/1000000000.0;
            System.out.println("Total different words"+set.getSize());
            System.out.println("BSTSet: "+time+"s");

        }

    }
}
