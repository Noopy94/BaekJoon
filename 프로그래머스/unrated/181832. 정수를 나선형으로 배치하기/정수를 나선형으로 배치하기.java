class Solution {
    
    static int[][] answer;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N;
    static int finalx;
    static int finaly;
    
    public int[][] solution(int n) {
        N = n;
        if (N%2==0){
            finalx = N/2;
            finaly = N/2-1;
        } else {
            finalx = N/2;
            finaly = N/2;
            
        }
        answer = new int[n][n];
        answer[0][0]=1;
        def(0,0,0,2);
        return answer;
    }
    
    static void def(int x,int y, int direction, int num){
        
        
        int A = x+dx[direction];
        int B = y+dy[direction];

            if (0<=A&&A<N&&0<=B&&B<N&&answer[A][B]==0){
                answer[A][B] = num;
                def(A,B,direction,num+1);
            } else {
                if (x==finalx&&y==finaly) return;
                def(x,y,(direction+1)%4,num);
            }
            
            return;
        }
        
}