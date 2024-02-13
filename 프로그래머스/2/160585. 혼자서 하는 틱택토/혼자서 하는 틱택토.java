class Solution {
    public int solution(String[] board) {
        
        char[][] arr = new char[3][3];
        int Onum = 0;
        int OwinCnt = 0;
        int Xnum = 0;
        int XwinCnt = 0;
        
        for (int i=0;i<3;i++){
            String s = board[i];
            for (int j=0;j<3;j++) {
                char c = s.charAt(j);
                if (c == 'O') Onum++;
                else if (c=='X') Xnum++;
                arr[i][j]= c;
            }
        }
        
        for (int i=0;i<3;i++){
           
            if (arr[i][0]==arr[i][1]&&arr[i][1]==arr[i][2]) {
                if (arr[i][0]=='O') OwinCnt++;
                else if (arr[i][0]=='X') XwinCnt++;
            }
            
               if (arr[0][i]==arr[1][i]&&arr[1][i]==arr[2][i]) {
                if (arr[0][i]=='O') OwinCnt++;
                else if (arr[0][i]=='X') XwinCnt++;
            }
            
        }
        
         if (arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2]) {
                if (arr[0][0]=='O') OwinCnt++;
                else if (arr[0][0]=='X') XwinCnt++;
        }
        
        if (arr[0][2]==arr[1][1]&&arr[1][1]==arr[2][0]) {
                if (arr[0][2]=='O') OwinCnt++;
                else if (arr[0][2]=='X') XwinCnt++;
        }

        // X차례에 O를 놔서 O가 2개 더 많은 경우
        if (Onum>Xnum+1) return 0;
        // 실수로 O차례에 X를 놔서 X가 더 많은 경우
        if (Xnum>Onum) return 0;
        // O가 이겼는데도 게임을 계속한 경우
        if (OwinCnt>0&&Onum<=Xnum) return 0;
        // X가 이겼는데도 게임을 계속한 경우
        if (XwinCnt>0&&Onum>Xnum) return 0;

        return 1;
    }
}