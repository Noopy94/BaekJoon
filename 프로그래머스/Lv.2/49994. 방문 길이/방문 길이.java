class Solution {
    
    public int solution(String dirs) {
        int answer = 0;
        int nowX = 5;
        int nowY = 5;
        boolean[][] visitedX = new boolean[11][11];
        boolean[][] visitedY = new boolean[11][11];
        
        for (int i=0;i<dirs.length();i++){
            
            Character c = dirs.charAt(i);
            
            if (c=='U') {
                if(nowY<10) nowY++;
                else continue;
                
                if (!visitedY[nowX][nowY]) {
                    visitedY[nowX][nowY] = true;
                    answer++;
                }

            } else if (c=='D') {
                
                if(nowY>0) nowY--;
                else continue;
                
                if (!visitedY[nowX][nowY+1]) {
                    visitedY[nowX][nowY+1] = true;
                    answer++;
                }
                
            } else if (c=='R') {
                
                if(nowX<10) nowX++;
                else continue;
                
                if (!visitedX[nowX][nowY]) {
                    visitedX[nowX][nowY] = true;
                    answer++;
                }
                
            } else  { 
                
                if(nowX>0) nowX--;
                else continue;
                
                if (!visitedX[nowX+1][nowY]) {
                    visitedX[nowX+1][nowY] = true;
                    answer++;
                }
                
            }
            
        }
        
        
        return answer;
    }
}