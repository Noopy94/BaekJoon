import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        HashSet<Integer> hash1 = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<A;i++) hash1.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<B;i++) hash1.remove(Integer.parseInt(st.nextToken()));

        //A에 속하면서, B에 속하지 않는 원소
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int c : hash1) {
            pq.add(c);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");

        System.out.println(sb);

    }

}