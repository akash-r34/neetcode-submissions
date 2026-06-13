class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(hm1.containsKey(c1))
                hm1.put(c1, hm1.get(c1)+1);
            else{
                hm1.put(c1, 1);
            }
            if(hm2.containsKey(c2))
                hm2.put(c2, hm2.get(c2)+1);
            else{
                hm2.put(c2, 1);
            }
        }
        for(Map.Entry<Character, Integer> m:hm1.entrySet()){
            if(!m.getValue().equals(hm2.get(m.getKey())))
                return false;
        }
        return true;
    }
}
