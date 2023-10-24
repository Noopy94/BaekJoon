import java.util.*;

class Solution {
    
     static class Node implements Comparable<Node> {

		int citynum, cost;

		public Node(int citynum, int cost) {

			this.citynum = citynum;
			this.cost = cost;

		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
    
    
    public int solution(int N, int[][] road, int K) {
        
        int[] result = new int[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        ArrayList<Node>[] list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        
        for (int i=0;i<road.length;i++){
            list[road[i][0]].add(new Node(road[i][1],road[i][2]));
            list[road[i][1]].add(new Node(road[i][0],road[i][2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        result[1] = 0;
        while (!pq.isEmpty()){
            
            int now = pq.poll().citynum;
            for (Node c : list[now]){
                
                if (result[c.citynum] > result[now]+c.cost){
                    result[c.citynum] = result[now]+c.cost;
                    pq.add(new Node(c.citynum,result[c.citynum]));
                }
            }
        }
        
        int answer = 1;
        for (int i=2;i<=N;i++){
           if( result[i]<=K) answer++;
        }
        
        return answer;
        
        
    }
}