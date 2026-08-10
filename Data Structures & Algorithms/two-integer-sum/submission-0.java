class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0 ; i < nums.length;i++) {
            int difference = target - nums[i];
            if(mp.containsKey(difference))
                return new int[] {mp.get(difference), i};
        
        mp.put(nums[i], i);
    }
    return new int[]{};
}
}
