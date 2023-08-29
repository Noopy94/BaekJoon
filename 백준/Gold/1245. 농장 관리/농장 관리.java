import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M;
	static int[][] arr;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (visited[i][j]) continue;
				Queue<Node> Q = new LinkedList<>();
				Q.offer(new Node(i,j));
				visited[i][j] = true;
				boolean check = true;
				while (!Q.isEmpty()) {
					Node temp = Q.poll();
					for (int k=0;k<8;k++) {
						int x = temp.x+dx[k];
						int y = temp.y+dy[k];
						if (0<=x&&x<N&&0<=y&&y<M) {
							if (arr[x][y]<arr[temp.x][temp.y]) continue;
							else if (arr[x][y]>arr[temp.x][temp.y]) {
								check  = false;
								continue;
							} else {
								if (visited[x][y]) continue;
								else {
									visited[x][y] = true;
									Q.offer(new Node(x,y)); 
								}
							}
						}
					}
				}
				if (check) cnt++;
			}
		}
		
		System.out.println(cnt);
		
	
	}


}