import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static long P = 1000000007;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long numer = factorial(N);
        long denom = factorial(K) * factorial(N - K) % P;

        System.out.println(numer * pow(denom, P - 2) % P);

    }

    // 페르마의 소정리 보고 따라서 침.
    // 나중에 한번 다시 쳐볼것.
    static long factorial(long N) {

        long fac = 1l;

        while (N > 1) {
            fac = (fac * N) % P;
            N--;
        }

        return fac;

    }

    static long pow(long base, long expo) {

        if (expo == 1) {
            return base % P;
        }

        long temp = pow(base, expo / 2);

        if (expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }

        return temp * temp % P;
    }

}