import java.util.*;
import java.io.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        String genre;
        Integer cnt;
        
     @Override
	 public int compareTo(Node o) {
        return o.cnt-this.cnt;
	}
        
        public Node(String genre, Integer cnt){
            this.genre = genre;
            this.cnt = cnt;
        } 
        
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i=0;i<plays.length;i++){
            if (hash.containsKey(genres[i])) hash.put(genres[i],hash.get(genres[i])+plays[i]);
            else hash.put(genres[i],plays[i]);
        }
        
        List<Node> list = new ArrayList<>();
        for (java.util.Map.Entry<String, Integer> c: hash.entrySet()) {
	        	list.add(new Node(c.getKey(), c.getValue()));
	    }
        
        Collections.sort(list);
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            String genre = list.get(i).genre;
            List<Integer> tempnum = new ArrayList<>();
            for (int j=0;j<genres.length;j++){
                if (genres[j].equals(genre)) tempnum.add(j);
            }
            
            if (tempnum.size()==1) result.add(tempnum.get(0));
            else {
                int max = 0;
                int cnt = 0;
                for (int k=0;k<tempnum.size();k++){
                    if (plays[tempnum.get(k)]>max){
                    max= plays[tempnum.get(k)];
                    cnt= tempnum.get(k);
                }
                }
                
                int max2 = 0;
                int cnt2 = 0;
                for (int k=0;k<tempnum.size();k++){
                    if (plays[tempnum.get(k)]>max2&&tempnum.get(k)!=cnt){
                        max2= plays[tempnum.get(k)];
                        cnt2 = tempnum.get(k);
                    }
                }
                result.add(cnt);
                result.add(cnt2);
            }
        }
        
        return result;
    }
}