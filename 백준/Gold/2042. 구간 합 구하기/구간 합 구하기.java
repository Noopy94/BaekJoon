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
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        SegmentTree segmentTree = new SegmentTree(N);

        for (int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        segmentTree.init(arr,1,1,N);


        for (int tc=0;tc<M+K;tc++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A==1){
                long C = Long.parseLong(st.nextToken());
                segmentTree.update(1,1,N,B,C);
            }
            if (A==2){
                int C = Integer.parseInt(st.nextToken());
                sb.append(segmentTree.sum(1,1,N,B,C)).append("\n");
            }

        }

        System.out.println(sb);
    }

    static class SegmentTree{

        private long[] tree;
        SegmentTree(int n){

            double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNodeCount)];

        }

        public long init(long[] arr, int node, int start, int end){
            if (start == end) {
                return tree[node] = arr[start];
            }else{
                return tree[node] = init(arr, node*2, start, (start+end)/2)
                        + init(arr, node*2+1, (start+end)/2+1, end);
            }
        }

        long sum(int node, int start, int end, int left, int right) {
            // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하지 않는 경우 0리턴
            if (end < left || right < start) {
                return 0;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                return sum(node*2, start, (start+end)/2, left, right)
                        + sum(node*2+1, (start+end)/2+1, end, left, right);
            }
        }

        long update(int node, int start, int end, int index, long changeValue) {
            // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우
            if (index < start || end < index) {
                return tree[node];
            } else if (start == index && end == index) {
                return tree[node] = changeValue;
            } else {
                return tree[node] = update(node * 2, start, (start + end) / 2, index, changeValue) +
                        update(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue);
            }
        }



    }


}