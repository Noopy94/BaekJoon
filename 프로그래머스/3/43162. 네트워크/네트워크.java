import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i=0;i<n;i++){
            if (visited[i]) continue;
            answer++;
            
            Queue<Integer> Q = new LinkedList<>();
            Q.add(i);
            while(!Q.isEmpty()){
                int temp = Q.poll();
                if (!visited[temp]) {
                    visited[temp] = true;

                    for (int j=0;j<n;j++){
                        if (computers[temp][j]==1&&!visited[j]) {
                            Q.add(j);
                        }
                    }
                }
                
            }
            
        }
        
        return answer;
    }
}