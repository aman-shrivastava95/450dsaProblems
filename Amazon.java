import java.util.ArrayList;
import java.util.List;

public class Amazon {
    static List<String> list = new ArrayList<>();
    public static List<String>  wordBreak(String s, List<String> dict) {
        backtrack(s, dict, 0, "");
        return list;
    }
    
    public static void backtrack(String s, List<String> dict, int start, String temp) {
        if(start==s.length()) {
            list.add(temp.substring(0, temp.length()-1));
            return;
        }
        
        for(int i=start; i<s.length(); i++) {
            if(isValid(s.substring(start, i+1), dict)){
                backtrack(s, dict, i+1, temp+s.substring(start, i+1)+" ");
            }
        }
    }
    
    public static boolean isValid(String s, List<String> dict) {
        return dict.contains(s);
    }

    public static void main(String[] args) {
         List<String> dict = new ArrayList<>();
         dict.add("happy") ;
         dict.add("rise");
         dict.add("for");
         dict.add("set");
         dict.add("sunrise");
         dict.add("su");
         dict.add("nset");
         dict.add("sunset");
         dict.add("mind");
         dict.add("happymind");
         dict.add("n");
         dict.add("rise");
         dict.add("happysunrise");
         List<String> result = wordBreak("sunrise", dict) ;
         result.remove("sunrise");
         System.out.println(result);

    }
}