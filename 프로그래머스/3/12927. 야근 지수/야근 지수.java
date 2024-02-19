import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<works.length;i++) PQ.add(works[i]);
        while (n>0&&!PQ.isEmpty()) {
            int temp = PQ.poll();
            temp--;
            n--;
            if (temp != 0) PQ.add(temp);
        }
        
        while(!PQ.isEmpty()){
            int temp = PQ.poll();
            answer+=temp*temp;
        }
        
        return answer;
    }
}