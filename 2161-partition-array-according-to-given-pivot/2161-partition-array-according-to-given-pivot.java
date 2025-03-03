class Solution {
    public int[] pivotArray(int[] nums, int piv) {
        int n = nums.length;
        int ans[] = new int[n];
        int m = 0;
        for(int i=0; i<n; i++){
            if(nums[i] < piv){
                ans[m++] = nums[i]; 
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] == piv){
                ans[m++] = nums[i]; 
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] > piv){
                ans[m++] = nums[i]; 
            }
        }
        return ans;
    }
}