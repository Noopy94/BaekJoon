import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][][] arr;
    static final int inf = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1][10][1024]; // N 몇번째 자리인지, 가장 끝 숫자, 1024는 현재 포함된 숫자들 확인
        for (int i=1;i<10;i++) arr[1][i][1<<i] = 1;

        for (int i=1;i<N;i++) {
            for (int j=0;j<10;j++){
                for (int k=1;k<1024;k++){
                    if (j==0) {
                        arr[i+1][1][k|1<<1] = (arr[i+1][1][k|1<<1]+arr[i][j][k])%inf;
                    } else if (j==9) {
                        arr[i+1][8][k|1<<8] = (arr[i+1][8][k|1<<8]+arr[i][j][k])%inf;
                    } else {
                        arr[i+1][j+1][k|1<<(j+1)] = (arr[i+1][j+1][k|1<<(j+1)]+arr[i][j][k])%inf;
                        arr[i+1][j-1][k|1<<(j-1)] = (arr[i+1][j-1][k|1<<(j-1)]+arr[i][j][k])%inf;
                    }
                }
            }
        }

        int result = 0;
        for (int i=0;i<10;i++)result = (result+arr[N][i][1023])%inf;
        System.out.println(result);

    }

}