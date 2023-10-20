import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        int A = (char)'a' - (char)'A';
        int length = s.length();
        String answer = "";
        if ('a'<=s.charAt(0)&&s.charAt(0)<='z') {
            answer+=(char)(s.charAt(0)-32);
        } else answer +=s.charAt(0);
        
        for (int i=1;i<length;i++){
            
            if (s.charAt(i-1)==' '){
                if ('a'<=s.charAt(i)&&s.charAt(i)<='z') answer+=(char)(s.charAt(i)-32);
                else answer+=s.charAt(i);
            } else {
                 if ('A'<=s.charAt(i)&&s.charAt(i)<='Z') answer+=(char)(s.charAt(i)+32);
                else answer+=s.charAt(i);
            }
        }
        
        return answer;
    }
}