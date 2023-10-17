import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] indexarr;
	static List<Integer> list;
	static int lastnum = -1000000001;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		indexarr = new int[N];
		list = new ArrayList<Integer>();
		list.add(-1000000001);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			def(arr[i],i);
		}
		
		int[] result = new int[cnt+1];
		int cnt2 = cnt;
		
		for (int i=N-1;i>=0;i--) {
			if (indexarr[i]==cnt2) {
				result[cnt2]=arr[i];
				cnt2--;
			}
		}

		sb.append(cnt).append("\n");
		for (int i=1;i<=cnt;i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);

	}

	static void def(int a,int index) {

		if (lastnum < a) {

			list.add(a);
			lastnum = a;
			cnt++;
			indexarr[index] = cnt;

		} else {

			int start = 0;
			int end = list.size() - 1;
			int mid = (start + end) / 2;

			while (start <= end) {

				if (list.get(mid) < a) {

					start = mid + 1;
					mid = (start + end) / 2;

				} else if (list.get(mid) > a) {

					end = mid - 1;
					mid = (start + end) / 2;

				} else {
					start = mid;
					break;
				}

			}
			indexarr[index] = start;
			list.set(start, a);

			if (start == cnt) {

				lastnum = a;

			}

		}

	}

}