import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N+1]; // arr는 1등은 0, N등은 N-1값을 갖는다.
			int[] score = new int[N+1]; //작년 등수

			for (int i=0;i<N;i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[temp] = i;
				score[temp] = i;
			}
			int M = Integer.parseInt(br.readLine());
			for (int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				if (score[A]>score[B]){
					arr[A]--;
					arr[B]++;
				} else {
					arr[A]++;
					arr[B]--;
				}
			}

			int[] visited = new int[N];
			boolean check = true;

			for (int i=1;i<=N;i++){
				if (arr[i]<0||arr[i]>=N) {
					check = false;
					break;
				} else {
					if (visited[arr[i]]!=0) {
						check = false;
						break;
					}
					visited[arr[i]] = i;
				}
			}

			if (check) {
				for (int i=0;i<N;i++) sb.append(visited[i]).append(" ");
				sb.append("\n");
			} else sb.append("IMPOSSIBLE").append("\n");

		}

		System.out.println(sb);

	}
}