class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 == 1) return false;
        int tar = sum/2;
        int dp[][] = new int[n+1][tar+1];
        return func(n, tar, nums, dp)==1 ? true : false;
    }

    public int func(int n, int tar, int nums[], int[][] dp){
        int prev[] = new int[tar+1];
        prev[0] = 1;
        for(int i=0; i<n+1; i++) dp[i][0] = 1;
        
        for(int i=1; i<n+1; i++){
            int curr[] = new int[tar+1];
            for(int j=1; j<tar+1; j++){
                int pick = 0;
                if(nums[i-1]<=j) pick = prev[j-nums[i-1]];
                int notPick = prev[j];
                curr[j] = (pick==1 || notPick==1) ? 1 : 0;
            }
            prev = curr;
        }
        return prev[tar];
    }
}