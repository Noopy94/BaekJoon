class Solution {
    public int solution(int n) {
        
        int cnt1 = 0;
        String s = Integer.toBinaryString(n);
        for (int i=0;i<s.length();i++) if (s.charAt(i)=='1') cnt1++;
        
        while (true){
        n++;
        int cnt2 = 0;
        s = Integer.toBinaryString(n);
        for (int i=0;i<s.length();i++) if (s.charAt(i)=='1') cnt2++;
        if (cnt1==cnt2) break;
        
        }
        return n;
    }
}