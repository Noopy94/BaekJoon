import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		String s;
		int cnt;

		public Node(String s, int cnt){
			this.s = s;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				if (this.s.length()==o.s.length()) return this.s.compareTo(o.s);
				return o.s.length()-this.s.length();
			}
			return o.cnt-this.cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hash = new HashMap<>();
		for (int i=0;i<N;i++) {
			String s = br.readLine();
			if (s.length()<M) continue;
			hash.put(s, hash.getOrDefault(s,0)+1);
		}

		List<Node> list = new ArrayList<>();
		hash.forEach((key, value) -> {
			list.add(new Node(key, value));
		});

		Collections.sort(list);
		for (Node temp : list){
			sb.append(temp.s).append("\n");
		}

		System.out.println(sb);

	}
}