import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		int[] arrC = new int[N];
		int[] arrD = new int[N];
		int[] arrE = new int[N*N];
		int[] arrF = new int[N*N];
		long answer = 0l;

		for (int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			arrA[i] = A;
			arrB[i] = B;
			arrC[i] = C;
			arrD[i] = D;
		}

		for (int i=0;i<N;i++){
			for (int j=0;j<N;j++) {
				arrE[i*N+j] = arrA[i]+arrB[j];
				arrF[i*N+j] = arrC[i]+arrD[j];
			}
		}

		// arrE와 arrF를 정렬하고 투포인터로 0인거 찾기
		Arrays.sort(arrE);
		Arrays.sort(arrF);

		int eIndex = 0;
		int fIndex = N*N-1;

		while(!(eIndex>=N*N||0>fIndex)){

			int A = arrE[eIndex]+arrF[fIndex];
			if (A==0) {

				int tempE = arrE[eIndex];
				int tempF = arrF[fIndex];
				long cntE = 1;
				long cntF = 1;

				while(eIndex<N*N-1){
					if (tempE==arrE[eIndex+1]) {
						cntE++;
						eIndex++;
					} else break;
				}

				while (0<fIndex){
					if(tempF==arrF[fIndex-1]){
						cntF++;
						fIndex--;
					} else break;
				}
				answer+=cntE*cntF;
				eIndex++;
				fIndex--;
				continue;
			}

			if (A>0) {
				fIndex--;
				continue;
			}

			if (A<0) {
				eIndex++;
			}

		}

		System.out.println(answer);


	}
}