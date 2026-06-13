class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> indexStack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        indexStack.push(0);
        int i=1;
        while(i<temperatures.length){ 
            while(!indexStack.isEmpty() && (temperatures[i]>temperatures[indexStack.peek()])){
                int index=indexStack.pop();
                result[index]=i-index;
            }
            indexStack.push(i);
            i++;
        }
        return result;
    }
}
