import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) throws IOException {

     PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>((o1, o2) -> o1-o2);
     PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
     int[] answer = new int[2];
    int min =0;
    int max =0;

        for (String c: operations){
              StringTokenizer st = new StringTokenizer(c," ");
             String s = st.nextToken();
                if (s.equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    pq1.offer(num);
                    pq2.offer(num);
                } else {//s가 D이면
                    int num = Integer.parseInt(st.nextToken());
                    if (num==-1&&!pq1.isEmpty()) {
                        int A = pq1.poll();
                        pq2.remove(A);
                    } else if(num==1&&!pq2.isEmpty()) {
                        int A = pq2.poll();
                        pq1.remove(A);
                    }
                }
            }
        
        answer[0]=0;
        answer[1]=0;
        if (pq1.size()>0){
        answer[0] = pq2.peek();
        answer[1] = pq1.peek();
        }
        
            return answer;
        }
    }