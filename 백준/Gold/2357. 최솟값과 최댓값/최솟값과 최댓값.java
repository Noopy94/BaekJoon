import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N+1];
		SegmentMinTree segmentMinTree = new SegmentMinTree(N);
		SegmentMaxTree segmentMaxTree = new SegmentMaxTree(N);

		for (int i=1;i<=N;i++){
			arr[i] = Long.parseLong(br.readLine());
		}

		segmentMinTree.init(arr,1,1,N);
		segmentMaxTree.init(arr,1,1,N);


		for (int tc=0;tc<M;tc++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			sb.append(segmentMinTree.find(1,1,N,A,B)).append(" ").append(segmentMaxTree.find(1,1,N,A,B)).append("\n");

		}

		System.out.println(sb);
	}

	static class SegmentMinTree{

		private long[] tree;
		SegmentMinTree(int n){

			double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
			long treeNodeCount = Math.round(Math.pow(2, treeHeight));
			tree = new long[Math.toIntExact(treeNodeCount)];

		}

		public long init(long[] arr, int node, int start, int end){
			if (start == end) {
				return tree[node] = arr[start];
			}else{
				return tree[node] = Math.min(init(arr, node*2, start, (start+end)/2)
						,init(arr, node*2+1, (start+end)/2+1, end));
			}
		}

		long find(int node, int start, int end, int left, int right) {
			if (end < left || right < start) {
				return 2000_000_000;
			} else if (left <= start && end <= right) {
				return tree[node];
			} else {
				return Math.min(find(node*2, start, (start+end)/2, left, right)
						,find(node*2+1, (start+end)/2+1, end, left, right));
			}
		}


	}

	static class SegmentMaxTree{

		private long[] tree;
		SegmentMaxTree(int n){

			double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
			long treeNodeCount = Math.round(Math.pow(2, treeHeight));
			tree = new long[Math.toIntExact(treeNodeCount)];

		}

		public long init(long[] arr, int node, int start, int end){
			if (start == end) {
				return tree[node] = arr[start];
			}else{
				return tree[node] = Math.max(init(arr, node*2, start, (start+end)/2)
						,init(arr, node*2+1, (start+end)/2+1, end));
			}
		}

		long find(int node, int start, int end, int left, int right) {
			if (end < left || right < start) {
				return 0;
			} else if (left <= start && end <= right) {
				return tree[node];
			} else {
				return Math.max(find(node*2, start, (start+end)/2, left, right)
						,find(node*2+1, (start+end)/2+1, end, left, right));
			}
		}


	}


}