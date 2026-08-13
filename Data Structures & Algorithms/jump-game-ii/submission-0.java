class Solution {
    public int jump(int[] nums) {
        int jumps = 0, n=nums.length-1;
        int l=0, r=0;
        while(r<n) {
            int farthest = 0;
            // once r reaches n-1, we reach the target
            for(int i=l;i<=r;i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
             l =r+1;
             r=farthest;
             jumps++;
        }
        return jumps;
    }
}
