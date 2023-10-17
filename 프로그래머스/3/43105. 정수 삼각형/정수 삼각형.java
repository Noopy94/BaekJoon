class Solution {
    public int solution(int[][] triangle) {
        
        for (int i=1;i<triangle.length;i++){
            
            int[] arr1 = triangle[i-1];
            int[] arr2 = triangle[i];
            arr2[0] += arr1[0];
            for (int j=1;j<i;j++) arr2[j] += Math.max(arr1[j-1],arr1[j]);
            arr2[i] += arr1[i-1];
            
        }
        
        int answer = 0;
        for (int i=0;i<triangle.length;i++){
            answer = Math.max(answer, triangle[triangle.length-1][i]);
        }
        
        return answer;
    }
}