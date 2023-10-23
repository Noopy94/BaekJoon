import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
       int[] answer = new int[2];
        HashSet<String> hash = new HashSet<>();
        
        for (int i=0;i<words.length;i++){
            
            if (hash.contains(words[i])) {
                answer[0] = 1+i%n;
                answer[1] = 1+i/n;
                break;
            } else {
                hash.add(words[i]);
            }
            
            if (i>0&&words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                answer[0] = 1+i%n;
                answer[1] = 1+i/n;
                break; 
            }
            
        }
        
        return answer;
    }
}