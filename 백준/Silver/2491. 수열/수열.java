import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr  = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

		System.out.println(findMaxLength(N,arr));

	}

	private static int findMaxLength(int N, int[] seq) {
		int maxLength = 1;

		// 증가하는 부분 수열 찾기
		for (int i = 0; i < N; i++) {
			int seqLength = 1;
			while (i + 1 < N && seq[i] <= seq[i + 1]) {
				seqLength++;
				i++;
			}
			maxLength = Math.max(maxLength, seqLength);
		}

		// 감소하는 부분 수열 찾기
		for (int i = 0; i < N; i++) {
			int seqLength = 1;
			while (i + 1 < N && seq[i] >= seq[i + 1]) {
				seqLength++;
				i++;
			}
			maxLength = Math.max(maxLength, seqLength);
		}

		return maxLength;
	}

}