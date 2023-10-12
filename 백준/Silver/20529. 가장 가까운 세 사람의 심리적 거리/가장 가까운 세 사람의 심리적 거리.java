import java.io.*;
import java.util.*;

public class Main {
	
	static int min;
	static List<String> slist;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (N>=33) {
				sb.append(0).append("\n");
				continue;
			}
			HashMap<String, Integer> hash = new HashMap<String, Integer>(); 
			for (int j=0;j<N;j++) {
				String s= st.nextToken();
				if (!hash.containsKey(s)) hash.put(s, 1);
				else hash.put(s,hash.get(s)+1);
			}
			
			slist = new LinkedList<String>();
			min = Integer.MAX_VALUE;
			for (String s: hash.keySet()) {
				if (hash.get(s)>=3) {
					min = 0;
					break;
				} else if (hash.get(s)==2) {
					slist.add(s);
					slist.add(s);
				} else slist.add(s);
			}
		
			if (min !=0) def(0,1,2,slist.size());
			sb.append(min).append("\n");
		}

		System.out.println(sb);
	}
	
	static void def(int a, int b, int c, int size) {
		
		if (a>=size-2) return;
		
		if (b>=size-1) {
			def(a+1,a+2,a+3,size);
			return;
		}
		
		if (c>=size) {
			def(a,b+1,b+2,size);
			return;
		}
		
		int result = 0;
		result+=compare(a,b);
		result+=compare(a,c);
		result+=compare(b,c);
		
		min = Math.min(min, result);
		if (min ==0) return;
		def(a,b,c+1,size);
		
	}
	
	static int compare(int A, int B) {

		String s1 = slist.get(A);
		String s2 = slist.get(B);
		int cnt = 0;
		for (int i=0;i<4;i++) if(s1.charAt(i)!=s2.charAt(i)) cnt++;
		return cnt;
	}

}