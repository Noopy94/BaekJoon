import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int A = score.length-1;
        while (A>=m-1){
            A-=m;
            answer+=score[A+1]*m;
        }

        return answer;
    }
}