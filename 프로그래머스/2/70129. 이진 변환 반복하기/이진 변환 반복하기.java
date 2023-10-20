import java.util.*;

class Solution {
    
    static int trans = 0;
    static int cnt = 0;
    
    public int[] solution(String s) {
        
        while (s.length()>1){
             s = def(s);
             trans++;
        }
        
        int[] answer = new int[2];
        answer[0] = trans;
        answer[1] = cnt;
        return answer;
    }
    
    static String def(String A){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<A.length();i++){
            if (A.charAt(i)!='0') sb.append(1);
            else cnt++;
        }
        int result = sb.toString().length();
        return Integer.toBinaryString(result);
    }
    
}