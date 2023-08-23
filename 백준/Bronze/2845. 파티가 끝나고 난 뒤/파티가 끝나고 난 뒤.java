import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<5;i++){
            sb.append(Integer.parseInt(st.nextToken())-result).append(" ");
        }
        System.out.println(sb);
    }
}