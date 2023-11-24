import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static class Node implements Comparable<Node>{
        int x;
        int heigth;

        @Override
        public int compareTo(Node o) {
            if (this.x==o.x) return o.heigth-this.heigth;
            return this.x-o.x;
        }

        public Node(int x, int heigth) {
            this.x = x;
            this.heigth = heigth;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>(Collections.reverseOrder());
        tree.put(0,1);

        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            PQ.add(new Node(A,B));
            PQ.add(new Node(C,-B));
        }

        int current = 0;

        while(!PQ.isEmpty()){

            Node temp = PQ.poll();
//            System.out.println("x : "+temp.x +" height : "+ temp.heigth);
//            System.out.println("current: " + current);
            if (temp.heigth>0){

                if (temp.heigth>current) {
                    current = temp.heigth;
                    sb.append(temp.x).append(" ").append(temp.heigth).append(" ");
                }
                tree.put(temp.heigth, tree.getOrDefault(temp.heigth,0)+1);

            }

            if (temp.heigth<0){

                int heigth = -temp.heigth;

                if (tree.get(heigth)<=1){
                    tree.remove(heigth);
                } else tree.put(heigth,tree.get(heigth)-1);

                if (heigth==current){
                        current = tree.firstKey();
                        if (heigth == current) continue;


                    sb.append(temp.x).append(" ").append(current).append(" ");
                }

            }

        }

        System.out.println(sb);

    }

}