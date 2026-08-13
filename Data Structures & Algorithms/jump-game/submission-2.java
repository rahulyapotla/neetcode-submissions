class Solution {
    public boolean canJump(int[] nums) {
        // int jumpC = nums[0];
        // int i=nums[0];
        // while(i<nums.length-1) {
        //     if(nums[i] == 0) {
        //         return false;
        //     }
        //    // jumpC += nums[i];
        //     i+= nums[i];
        // }
        // return true;

        int maxJump = 0, n=nums.length;
        for(int i=0;i<=n-1;i++) {
           if(i>maxJump) {
            return false;
           } 
           maxJump = Math.max(maxJump, i+nums[i]);
        }
        return true;
    }
}
