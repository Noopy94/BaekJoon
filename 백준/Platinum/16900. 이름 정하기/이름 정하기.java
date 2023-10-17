import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] pi;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		int N = S.length();
		
		getPi(S);
		
		long sum = 0l+ N + (N-pi[N-1])*1l*(K-1); 
		
		System.out.println(sum);
		
		
	}
	
	//실패테이블 getPi()
		public static void getPi(String pt) {
			//접두사와 접미사가 일치하는 최대길이를 담을 배열
			pi = new int[pt.length()]; // 0~i까지 의 부분문자열에서 접미사/접두사 일치하는 길이 담음
			
			int j = 0; //현재여기까지는 같아요~~
			// i, j가 가리키는 값이 같다면 둘자 포인트를 증가해
			//i는 무조건 증가 
			for(int i=1; i<pt.length(); i++) {
				//두 포인트가 가리키는 값이 다르다면 
				while (j>0&& pt.charAt(i) != pt.charAt(j)) {
					j = pi[j-1]; // 요기가 어렵다. 
					// 
				}
				//지금 두 포인트가 가리키는 값이 같다면
				if(pt.charAt(i) == pt.charAt(j)) {
					pi[i] = ++j;
				}
			}
			
		}

}