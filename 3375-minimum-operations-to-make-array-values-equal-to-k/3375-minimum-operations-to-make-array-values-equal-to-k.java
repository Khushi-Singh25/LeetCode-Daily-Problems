class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[0]<k) return -1;
        int c = 0;
        for(int i=n-1; i>0; i--){
            if(nums[i]==nums[i-1]){
                continue;
            }else{
                c++;
            }
        }
        if(k<nums[0]) c++;
        return c;
    }
}