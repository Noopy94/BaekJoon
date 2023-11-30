import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Tree{
        long[] tree;

        public Tree(int n){

            double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
            long treeNodeCnt = Math.round(Math.pow(2,treeHeight));
            tree = new long[Math.toIntExact(treeNodeCnt)];

        }

        public long init(long[] arr, int node, int start, int end){
            if (start==end) return tree[node] = arr[start];
            return tree[node] = init(arr, node*2,start, (start+end)/2)+
                    init(arr, node*2+1,(start+end)/2+1, end);
        }

        public long sum(int node, int start, int end, int left, int right){

            if (end<left||right<start) return 0;
            if (left<=start && end<=right) return tree[node];
            return sum(node*2,start, (start+end)/2, left, right)
                    +sum(node*2+1, (start+end)/2+1,end,left,right);

        }

        public long update(int node, int start, int end, int index, long changeValue) {
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



    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) arr[i] = Long.parseLong(st.nextToken());
        Tree segmentTree = new Tree(N);
        segmentTree.init(arr,1,1,N);
        for (int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            int num4 = Integer.parseInt(st.nextToken());
            if (num1>num2) sb.append(segmentTree.sum(1,1,N,num2,num1)).append("\n");
            else sb.append(segmentTree.sum(1,1,N,num1,num2)).append("\n");
            segmentTree.update(1,1,N,num3,num4);

        }

        System.out.println(sb);


    }
}