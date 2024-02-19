import java.util.*;

class Solution {
    
    private class Node {
        int order;
        int priority;
        
        public Node(int order, int priority){
            this.order = order;
            this.priority = priority;
        }
    }
    
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Node> Q = new LinkedList<>();
        for (int i=0;i<priorities.length;i++) {
            PQ.add(priorities[i]);
            Q.add(new Node(i,priorities[i]));
        }
        
        int out = -1;
        
        while (out != location) {
            
            Node temp = Q.peek();
            if (temp.priority==PQ.peek()) {
                answer++;
                out = temp.order;
                Q.poll();
                PQ.poll();
            } else Q.add(Q.poll());
            
        }
        
        
        return answer;
    }
}