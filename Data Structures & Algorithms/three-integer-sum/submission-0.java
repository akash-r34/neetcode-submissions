class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            int target = -1*nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                if(nums[start]+nums[end]<target)
                    start++;
                else if(nums[start]+nums[end]>target)
                    end--;
                else{
                    triplets.add(List.of(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                }
            }
        }
        return new ArrayList<>(new LinkedHashSet<>(triplets));  
    }
}
