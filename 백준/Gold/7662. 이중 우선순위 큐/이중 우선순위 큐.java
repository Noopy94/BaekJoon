import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0;tc<T;tc++) {
			int K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tree = new TreeMap<>();
			for(int i=0;i<K;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String A = st.nextToken();
				int B = Integer.parseInt(st.nextToken());
				if (A.equals("I")) {
					tree.put(B, tree.getOrDefault(B, 0)+1);
				} else {
					if(tree.size()==0) continue;
					
					int C = 0;
					
					if (B==1) {
						C = tree.lastKey();
					} else {
						C = tree.firstKey();
					}
					
					// 이렇게 하는 이유는 put은 동일 key값에 이미 값이 있으면 값을 바꿔준다.
					// 그래서 하나씩 낮춰주다가 그렇게 반환된 값이 1이면 
					if (tree.put(C,tree.get(C)-1)==1) tree.remove(C);
				}
				
			}
		
			sb.append(tree.size()==0 ? "EMPTY": tree.lastKey()+" "+tree.firstKey()).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}