import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int N = players.length;
        String[] answer = players;
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i=0;i<N;i++){
            hash.put(players[i],i);
        }
        
        for (String s: callings){
            
            int num = hash.get(s); // 지금 등수 
            String player = answer[num-1];
            answer[num-1] = s;
            answer[num] = player;
            hash.put(s,num-1);
            hash.put(player,num);
        }


        return answer;
    }
    
}

