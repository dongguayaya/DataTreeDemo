import java.util.ArrayList;

public class TrieTest {
    public static void main(String[] args) {

        System.out.println("Pride");
        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)){
            long start=System.nanoTime();
            Trie  trie=new Trie();
            for(String word:words)
                trie.add(word);
            for(String word:words)
                trie.contains(word);
            long  end=System.nanoTime();
            double time2=(end-start)/1000000000.0;
            System.out.println("Total different words"+trie.getSize());
            System.out.println("BSTSet: "+time2+"s");
        }

    }
}
