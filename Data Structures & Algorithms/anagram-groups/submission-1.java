class Solution {

    public boolean isAnagram(String str1, String str2){
        int[] alphabetCounts = new int[26];
        if(str1.length()!=str2.length())
            return false;
        for(int i=0;i<str1.length();i++){
            alphabetCounts[str1.charAt(i)-'a']++;
            alphabetCounts[str2.charAt(i)-'a']--;
        }
        for(int count:alphabetCounts){
            if(count!=0)
                return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> bkpStrs = new ArrayList<>(Arrays.asList(strs));
        while(bkpStrs.size()>0){
            String groupKey=bkpStrs.remove(0);
            List<String> tmpList = new ArrayList<>();
            tmpList.add(groupKey);
            for(int j=0; j<bkpStrs.size(); j++){
                if(isAnagram(groupKey, bkpStrs.get(j))){
                    tmpList.add(bkpStrs.remove(j));
                    j--;
                }
            }
            result.add(tmpList);
        }
        return result;
    }
}
