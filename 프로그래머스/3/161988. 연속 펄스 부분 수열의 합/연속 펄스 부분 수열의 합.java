class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int N = sequence.length;
        int[] arr1 = new int[N+1];
        int[] arr2 = new int[N+1];
        for (int i=1;i<=N;i++){
            int temp = (i % 2 == 0) ? 1 : -1;
            arr1[i] = sequence[i-1]*temp;
            arr2[i] = sequence[i-1]*-temp;
        }
        
        long[] arrsum1 = new long[N+1];
        long[] arrsum2 = new long[N+1];
        arrsum1[0] = 0;
        arrsum2[0] = 0;
        long max1 = 0;
        long max2 = 0;
        long min1 = 0;
        long min2 = 0;
        
        for (int i=1;i<=N;i++){
            arrsum1[i] = arrsum1[i-1]+arr1[i];
            arrsum2[i] = arrsum2[i-1]+arr2[i];
            
            max1 = Math.max(arrsum1[i]-min1, max1);
            max2 = Math.max(arrsum2[i]-min2, max2);

            if (arrsum1[i]<min1) min1 = arrsum1[i];
            if (arrsum2[i]<min2) min2 = arrsum2[i];
            
        }
        
        return Math.max(max1,max2);
    }
}