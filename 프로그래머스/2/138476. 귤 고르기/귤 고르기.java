import java.util.*;

class Solution {

    class Node implements Comparable<Node> {

        int size;
        int cnt;

        @Override
        public int compareTo(Node o) {
            return o.cnt-this.cnt;
        }

        public Node(int size, int cnt){
            this.size = size;
            this.cnt= cnt;
        }

    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int c: tangerine) {

            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) + 1);
            } else {
                hash.put(c, 1);
            }
        }

        List<Node> list = new ArrayList<>();

        hash.forEach((key,value) ->{
            list.add(new Node(key,value));
        });

        Collections.sort(list);
        int sum= 0;
        for (Node node: list){
            sum+= node.cnt;
            answer++;
            if (sum>=k) break;
        }

        return answer;
    }
}