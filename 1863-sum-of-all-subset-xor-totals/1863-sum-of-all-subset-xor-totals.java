class Solution {
    int xor = 0;
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return func(0, 0, nums);
    }

    public int func(int i, int xor, int[] nums){
        if(i >= nums.length){
            return xor;
        }
        int pick = func(i+1, nums[i]^xor, nums);
        int notPick = func(i+1, xor, nums);
        return pick + notPick;
    }
}