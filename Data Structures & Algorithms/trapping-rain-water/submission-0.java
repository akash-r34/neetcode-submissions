class Solution {
    public int max(int a, int b){
        return a>b?a:b;
    }
    public int min(int a, int b){
        return a<b?a:b;
    }

    public int trap(int[] height) {
        int res=0;
        int left=0;
        int right=height.length-1;
        int maxLeft=height[left];
        int maxRight=height[right];
        while(left<right){
            if(height[left]<height[right]){
                left++;
                maxLeft=max(maxLeft, height[left]);
                res+=maxLeft-height[left];
            }
            else{
                right--;
                maxRight=max(maxRight, height[right]);
                res+=maxRight-height[right];
            }
        }
        return res;
    }
}
