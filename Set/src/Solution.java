import java.util.TreeSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String > set=new TreeSet<>();
        for(String word1:words){
            StringBuilder res=new StringBuilder();
            for(int i=0;i<word1.length();i++){
                res.append(codes[word1.charAt(i)-'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
