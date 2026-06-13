class Solution {
    public boolean isPalindrome(String s) {
        char sChars[] = s.toLowerCase()
                         .replaceAll("[^a-z0-9]", "")
                         .toCharArray();
        
        // Start at the absolute edges
        int left = 0;
        int right = sChars.length - 1;
        
        // Walk inward until they meet in the middle
        while (left < right) {
            if (sChars[left] != sChars[right]) {
                return false; 
            }
            left++;
            right--;
        }
        
        return true;
    }
}