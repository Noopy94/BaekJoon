import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        for (int i=0;i<cities.length;i++){
            String cityName = cities[i].toUpperCase();
            
            if (list.contains(cityName)) {
                answer+=1;
                list.remove(cityName);
            }
            else answer+=5;
            
            list.add(cityName);
            if (list.size()>cacheSize){
                list.remove(0);
            }
            
        }
        
        
        return answer;
    }
}