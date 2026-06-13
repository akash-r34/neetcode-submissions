class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num); 
        }
        
        for(int num: nums){
            if(!numsSet.contains(num-1)){
                int length=1;
                while(numsSet.contains(num+1))
                {
                    length++;
                    num++;
                }
                    
                if(length>maxLength)
                    maxLength=length;
            }
        }
        return maxLength;
    }
}
