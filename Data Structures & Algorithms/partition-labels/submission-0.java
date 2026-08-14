class Solution {
    public List<Integer> partitionLabels(String s) {
        //  the goal is to partition the entire string into as many substrings a sposiisble, by minimizing the length of each substring and making sure that each letter appears in just one substring.

        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        for(int i=0;i<s.length();i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if(i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
