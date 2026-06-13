class Solution {

    public String encode(List<String> strs) {
        String encodedString="";
        for(String str:strs){
            int num = str.length();
            encodedString+=(Integer.toString(num)+"#"+str);
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            // 1. Find where the delimiter '#' is located relative to current i
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            
            // 2. Everything between i and j is the length string (e.g., "12")
            int wordLength = Integer.parseInt(str.substring(i, j));
            
            // 3. The actual word starts right after '#' (at j + 1)
            //    And ends at (j + 1 + wordLength)
            result.add(str.substring(j + 1, j + 1 + wordLength));
            
            // 4. Move your pointer i to the start of the next encoded block
            i = j + 1 + wordLength;
        }
        return result;
    }
}
