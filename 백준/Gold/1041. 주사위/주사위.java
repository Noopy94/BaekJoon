import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[6];
		
		int min1=50;
		int index1 = 0;
		
		for (int i=0;i<6;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min1 = Math.min(min1, arr[i]);
			if (min1==arr[i]) index1 = i;
		}
		
		int min2=50;
		int index2=0;
		
		for (int i =0;i<6;i++) {
			
			if (i==index1||i==5-index1) continue;
			min2 = Math.min(min2, arr[i]);
			if (min2==arr[i]) index2 = i;
			
		}

		int min3=50;
		
		for (int i=0;i<6;i++) {
			
			if (i==index1||i==5-index1) continue;
			if (i==index2||i==5-index2) continue;
			min3 = Math.min(min3, arr[i]);			
		}
		
		if (N==1) {
			Arrays.sort(arr);
			long sum = 0;
			for (int i =0;i<5;i++) {
				sum+= arr[i];
			}
			
			System.out.println(sum);
		} else {
			long sum = 0;
			sum+=min1*(5*N*N-16*N+12);
			sum+=(min1+min2)*(8*N-12);
			sum+=(min1+min2+min3)*4;
			
			System.out.println(sum);
			
		}
		
	}

}