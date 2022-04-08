package algorithms;

import java.util.HashMap;

public class stringSearch {
    public static void naiveSearch(String pattern, String txt){
        try {
            if (pattern == null || txt == null){
                throw new Exception("Strings can't be NULL value");
            }

            int window = pattern.length();
            if (window == 0 || txt.length() == 0 || window > txt.length() ){
                throw new Exception("Pattern length can't be greater than the original text length OR Strings can't be an empty strings");
            }
            else {
                for (int i = 0; i <= txt.length()-window; i++) {
                    String part = txt.substring(i,i+window);
                    if (pattern.equals(part)){
                        System.out.println(pattern+" founded at index ("+i+")");
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private static HashMap<Character,Integer> buildBadMatchTable(String pattern){
        HashMap<Character,Integer> BadMatch = new HashMap<>();
        for (int i = 0; i < pattern.length()-1; i++) {
            BadMatch.put(pattern.charAt(i),pattern.length()-i-1);
        }
        return BadMatch;
    }

    public static void boyerMooreHorspoolSearch(String pattern, String txt){
        try {
            if (pattern == null || txt == null){
                throw new Exception("Strings can't be NULL value");
            }

            int window = pattern.length();
            if (window == 0 || txt.length() == 0 || window > txt.length() ){
                throw new Exception("Pattern length can't be greater than the original text length OR Strings can't be an empty strings");
            }
            else {
                HashMap<Character,Integer> BadMatch = buildBadMatchTable(pattern);
                for (int i = 0; i <= txt.length()-window;) {
                    String part = txt.substring(i,i+window);
                    if(part.charAt(window-1) == pattern.charAt(window-1)){
                        if (pattern.equals(part)){
                            System.out.println(pattern+" founded at index ("+i+")");
                        }
                        i+=window;
                    }
                    else {
                        i+=BadMatch.getOrDefault(part.charAt(window-1),window);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
