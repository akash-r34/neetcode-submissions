class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int a[] = {0, 0};
        for(int i=0; i<nums.length; i++){
            int needed = target - nums[i];
            if(hm.containsKey(needed)){
                a[0] = hm.get(needed);
                a[1] = i;
                return a;
            }
            hm.put(nums[i], i);
        }
        return a;
    }
}
