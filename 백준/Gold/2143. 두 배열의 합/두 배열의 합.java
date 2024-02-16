import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int[] arrA = new int[A];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<A;i++) arrA[i] = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(br.readLine());
		int[] arrB = new int[B];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<B;i++) arrB[i] = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> hashA = new HashMap<>();
		HashMap<Integer, Integer> hashB = new HashMap<>();

		for (int i=1;i<=A;i++){
			int sum = 0;
			for (int j=0;j<i;j++) sum+=arrA[j];
			hashA.put(sum, hashA.getOrDefault(sum,0)+1);
			for (int k=0;k+i<A;k++) {
				sum+=(arrA[k+i]-arrA[k]);
				hashA.put(sum, hashA.getOrDefault(sum,0)+1);
			}
		}

		for (int i=1;i<=B;i++){
			int sum = 0;
			for (int j=0;j<i;j++) sum+=arrB[j];
			hashB.put(sum, hashB.getOrDefault(sum,0)+1);
			for (int k=0;k+i<B;k++) {
				sum+=(arrB[k+i]-arrB[k]);
				hashB.put(sum, hashB.getOrDefault(sum,0)+1);
			}
		}

		long result = 0;
		for (int keyA : hashA.keySet()) {
			result += 1l*hashA.get(keyA)*hashB.getOrDefault(T-keyA,0);
		}

		System.out.println(result);

	}
}