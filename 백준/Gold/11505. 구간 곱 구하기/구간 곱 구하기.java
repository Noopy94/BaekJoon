import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final long INF = 1_000_000_007l;

	static class SegmentTree{

		private long[] tree;
		SegmentTree(int n){
			double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
			long treeNodeCount = Math.round(Math.pow(2,treeHeight));
			tree = new long[Math.toIntExact(treeNodeCount)];
		}

		public long init(long[] arr, int node, int start, int end){

			if(start==end) {
				return tree[node] = arr[start];
			}
			else {
				return tree[node] = init(arr,node*2,start,(start+end)/2)*
						init(arr,node*2+1,(start+end)/2+1,end)%INF;
			}

		}

		/*  문제에 따라 코드에 따라 당연히 int node값이나 int start, end값이 자명하므로 생략해도 된다.
		언제 어느 상황에서도 변형할 수 있는 세그먼트 트리 공식을 외워보려고 전부 쓰는 것일뿐 문제에 맞춰서 수정해주는 것이 옳다.
		*/

		public long update(int node, int start, int end, int index, long changeValue){

			if (index < start || end < index) {
				return tree[node];
			} else if (start == index && end == index) {
				return tree[node] = changeValue;
			} else {
				return tree[node] = update(node * 2, start, (start + end) / 2, index, changeValue) *
						update(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue)%INF;
			}

		}

		public long multiplication(int node, int start, int end, int left, int right){

			if (end<left||right<start) return 1;
			if (left<=start && end<=right) return tree[node];
			return multiplication(node*2,start, (start+end)/2, left, right)
					*multiplication(node*2+1, (start+end)/2+1,end,left,right)%INF;

		}


	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cntM = 0;
		int cntK = 0;
		long[] arr = new long[N+1];
		for (int i=1;i<=N;i++) arr[i] = Long.parseLong(br.readLine());
		SegmentTree segmentTree = new SegmentTree(N);
		segmentTree.init(arr,1,1,N);

		while (true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (A==1) {
				cntM++;
				segmentTree.update(1,1,N,B,C);
			}
			if (A==2) {
				cntK++;
				sb.append(segmentTree.multiplication(1,1,N,B,C)).append("\n");
			}

			if (cntM==M&&cntK==K) break;
		}

		System.out.println(sb);
	}
}