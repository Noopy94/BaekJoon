import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> hash = new HashMap<>();
		hash.put("ChongChong",1);
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if (hash.getOrDefault(a,0)==1||hash.getOrDefault(b,0)==1) {
				hash.put(a,1);
				hash.put(b,1);
			}
		}
		int answer = 0;
		for (Integer value : hash.values()) {
			answer += value;
		}
		System.out.println(answer);

	}

}