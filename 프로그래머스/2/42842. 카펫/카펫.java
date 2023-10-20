class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i=3;i<=(brown+4)/4;i++){
            int width = (brown - i*2 +4)/2;
            if (i*width-brown == yellow) {
                answer[0] = width;
                answer[1] = i;
                break;
            }
        }
    
        return answer;
    }
}