class Solution
{
    public int solution(int n, int a, int b)
    {
    
        int answer = 1;
        if (a>b) {
            int temp = a;
            a= b;
            b= temp;
        }
        
        while (b-a>1||b%2!=0){
            
            a++;
            b++;
            a /=2;
            b /=2;
            answer++;
        }
        

        return answer;
    }
}