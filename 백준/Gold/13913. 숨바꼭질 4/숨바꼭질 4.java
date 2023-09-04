import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int index;
        Node parent;

        public Node(int index, Node parent) {
            this.index = index;
            this.parent = parent;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_001];
        visited[N] = true;

        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(N, null));
        int cnt = 0;
        Node resultNode = null;

        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int j = 0; j < size; j++) {
                Node temp = Q.poll();
                if (temp.index == K) {
                    resultNode = temp;
                    break;
                }

                int[] A = new int[3];
                A[0] = temp.index + 1;
                A[1] = temp.index - 1;
                A[2] = temp.index * 2;

                for (int i = 0; i < 3; i++) {
                    if (0 <= A[i] && A[i] < 100_001 && !visited[A[i]]) {
                        visited[A[i]] = true;
                        Q.offer(new Node(A[i], temp));
                    }
                }
            }
            if (resultNode != null) {
                break;
            }
            cnt++;
        }

        System.out.println(cnt);

        // 역추적하여 경로 출력
        StringBuilder pathBuilder = new StringBuilder();
        while (resultNode != null) {
            pathBuilder.insert(0, resultNode.index + " ");
            resultNode = resultNode.parent;
        }
        System.out.println(pathBuilder.toString().trim());
    }
}