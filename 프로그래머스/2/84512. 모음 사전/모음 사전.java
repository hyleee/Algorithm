import java.util.*;
import java.io.*;

class Solution {
    
    static String[] aeiou = {"A", "E", "I", "O", "U"};
    static List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        makeDictionary("", 0);
        return findIndex(word);
    }
    
    // a aa aaa aaaa aaaaa aaaae aaaai aaaao aaaau aaae aaai aaao aaau ...
    static void makeDictionary(String str, int len){
        // 0번째는 공백. 1번째가 a
        dictionary.add(str);
        
        if(len==5) return;
        for(int i=0; i<5; i++){
            makeDictionary(str+aeiou[i], len+1);
        }
    }
    
    static int findIndex(String word){
        for(int i=0; i<dictionary.size(); i++){
            if(word.equals(dictionary.get(i))){
                return i;
            }
        }
        return 0;
    }
}