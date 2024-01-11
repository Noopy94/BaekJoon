import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] phone_number = new String[N];

			for (int i = 0; i < N; i++) {
				phone_number[i] = br.readLine();
			}
			Arrays.sort(phone_number);

			if (isConsistent(N, phone_number)) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb);
	}

	public static boolean isConsistent(int N, String[] phone_number) {
        
        // 아이디어 생각이 안나서 고민하다가 검색해서 알게되었다. startsWith 굿 : )

		for (int i = 0; i < N - 1; i++) {
			if (phone_number[i + 1].startsWith(phone_number[i])) {
				return false;
			}
		}

		return true;
	}

}