import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 2];

		// 0,N+1에는 0을 넣어놓고, 1~N까지 숫자 대입
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		sb.append(realmax(1, N) + "\n");

		System.out.println(sb);
	}

	static long realmax(int start, int end) {

		if (start > end)
			return 0;
		if (start == end)
			return arr[start];

		int mid = (start + end) / 2;

		long max = Math.max(Math.max(realmax(start, mid - 1), realmax(mid + 1, end)), histogram(start, end, mid));

		return max;
	}
	// K번째를 지나가는 (포함하는) 직사각형 중 가장 큰값

	static long histogram(int start, int end, int K) {

		long max = arr[K];
		int height = arr[K];
		int now = arr[K];
		int left = K;
		int right = K;

		while (start <= left && right <= end) {

			if (arr[right + 1] >= arr[left - 1]) {
				right++;
				now = arr[right];
			} else {
				left--;
				now = arr[left];
			}

			if (now < height) {

				max = Math.max(max, height * 1l * (right - left));
				height = now;
			}

		}

		return max;

	}

}