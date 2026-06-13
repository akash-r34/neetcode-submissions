class Solution {
    public int getMax(int a, int b){
        return a>b?a:b;
    }
    public int getMin(int a, int b){
        return a<b?a:b;
    }
    public int getAreaContainer(int[] heights, int left, int right){
            return getMin(heights[left], heights[right])*(right-left);
    }
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxarea=0;
        while(left<right){
            maxarea=getMax(maxarea,  getAreaContainer(heights, left, right));
            if(heights[left]<heights[right])
                left++;
            else
                right--;
        }
        return maxarea;
    }
}
