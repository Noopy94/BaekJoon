import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i=1;i<=s.length()/2;i++){
            
            String pattern = s.substring(0,i);
            int cnt = 1;
            int length = 0;
            
            for (int j=i;j<=s.length()-i;j+=i){
                
                String temp = s.substring(j,j+i);
                if (pattern.equals(temp)) cnt++;
                else {
                    if (cnt>1) length += (int) Math.log10(cnt)+1;
                        
                    length += i;
                    pattern = s.substring(j,j+i);
                    cnt = 1;
 
                }
            }
            
            if (cnt>1) length += (int) Math.log10(cnt)+1;
            length += pattern.length();
            int div = s.length()%i;
    		if(div>0) length += div;
            
            
            answer = Math.min(answer, length);
                    
        }
        
        
        return answer;
    }
}