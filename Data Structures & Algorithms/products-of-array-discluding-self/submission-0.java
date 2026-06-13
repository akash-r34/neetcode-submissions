class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int zeroCounter=0;
        int zeroPos=0;
        int totProd=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroPos=i;
                zeroCounter++;
            }
            else{
                totProd*=nums[i];     
            }
        }
        if(zeroCounter>1){
            return result;
        }
        else if(zeroCounter==1){
            result[zeroPos]=totProd;
             return result;
        }
        int[] prefixProduct = new int [nums.length];
        int[] postfixProduct = new int [nums.length];
        prefixProduct[0]=nums[0];
        postfixProduct[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefixProduct[i]=prefixProduct[i-1]*nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            postfixProduct[i]=postfixProduct[i+1]*nums[i];
        }
        result[0]=postfixProduct[1];
        result[nums.length-1]=prefixProduct[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            result[i]=prefixProduct[i-1]*postfixProduct[i+1];
        }
        return result;
    }
}  
