class Solution {
    public int removeElement(int[] nums, int val) {
        int deletePointer = nums.length-1;
        int size=nums.length;
        int i=0;
        while(i<size){
            if(nums[i]==val){
                int tmp = nums[deletePointer];
                nums[deletePointer]=nums[i];
                nums[i]=tmp;
                size--;
                deletePointer--;
            }
            else{
                i++;
            }
        }
        return size;
    }
}