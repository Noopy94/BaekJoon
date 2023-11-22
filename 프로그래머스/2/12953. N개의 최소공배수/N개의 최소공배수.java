class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i=1;i<arr.length;i++){
            answer = answer*arr[i]/gcd(answer, arr[i]);
        }
    
        return answer;
    }
    
    static int gcd(int a, int b){
        
        int c = a%b;
        if (c==0) return b;
        else return gcd(b,c);
    } 
    
}