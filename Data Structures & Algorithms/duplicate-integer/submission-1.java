class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>();
        for(int num:nums){
            if(hm.containsKey(num))
                return true;
            hm.put(num, 1);
        }
        return false;
    }
}