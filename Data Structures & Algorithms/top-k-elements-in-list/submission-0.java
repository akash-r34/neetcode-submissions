class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==1){
            return new int[]{nums[0]};
        }
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            freqCount.putIfAbsent(nums[i], 0);
            freqCount.put(nums[i], freqCount.get(nums[i])+1);
        }
        // Sort by value in DESCENDING order
        Map<Integer, Integer> sortedMap = freqCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // <-- The magic happens here
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new  // Preserves the descending order
                ));

        // Slice from 0 to k and convert keys to int[]
        int[] topKKeys = sortedMap.keySet()
                .stream()
                .limit(k)                        // Slices from 0 to k
                .mapToInt(Integer::intValue)     // Unboxes Integer to int
                .toArray();                      // Collects into int[]
        return topKKeys;
    }
}
