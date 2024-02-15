import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> Q = new LinkedList<>();
		for (int i=0;i<N;i++){

			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			switch (s) {

				case "push":
					int A = Integer.parseInt(st.nextToken());
					Q.offer(A);
					break;
				case "pop":
					if (Q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(Q.poll()).append("\n");
					break;
				case "size": sb.append(Q.size()).append("\n");
					break;
				case "empty": sb.append(Q.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					if (Q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(Q.getFirst()).append("\n");
					break;
				case "back" :
					if (Q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(Q.getLast()).append("\n");
					break;
			}
		}

		System.out.println(sb);

	}
}