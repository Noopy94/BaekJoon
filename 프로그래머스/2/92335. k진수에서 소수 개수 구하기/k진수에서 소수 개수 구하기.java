class Solution {
    
    static int answer = 0;
    static int index = 0;
    
    public int solution(int n, int k) {
        String s = Integer.toString(n,k);
        int length = s.length();
        
        for (int i=0;i<length;i++){
            if (s.charAt(i)=='0') {
                def(s, index, i);
                index = i+1;
            }

        }
        def(s,index,length);
        
        return answer;
    }
    
    private void def(String s, int start, int end){
        
        if (end>s.length()||start>s.length()) return;
        String num = s.substring(start,end);
        if (num.equals("")) return;
        Long N = Long.parseLong(num);
        if(N==1) return;
        boolean check = true;
        
        for (int i=2;i<=Math.sqrt(N);i++){
            if(N%i==0) {
                check = false;
                break;
            }
        }
        
        if (check) {
            answer++;
        }
        
    }
    
    
}