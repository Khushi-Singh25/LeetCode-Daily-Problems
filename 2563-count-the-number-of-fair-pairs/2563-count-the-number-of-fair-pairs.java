class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        for(int i=0; i<n; i++){
            int lb = lowerBound(nums, i+1, lower-nums[i]);
            int ub = upperBound(nums, i+1, upper-nums[i]);
            ans += (ub-lb);
        }
        return ans;
    }

    public int lowerBound(int arr[], int idx, int k){
        int l=idx, r=arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] >= k) r=mid;
            else l=mid+1;
        }
        return l;
    }

    public int upperBound(int arr[], int idx, int k){
        int l=idx, r=arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] > k) r=mid;
            else l=mid+1;
        }
        return l;
    }
}