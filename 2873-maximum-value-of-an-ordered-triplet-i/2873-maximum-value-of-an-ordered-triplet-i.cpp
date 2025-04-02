class Solution {
public:
    long long maximumTripletValue(vector<int>& nums) {
        int n = nums.size();
        long long maxV = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    long long diff = nums[i] - nums[j];
                    long long val = 0;
                    if(diff>0) val = diff * nums[k];
                    maxV = max(maxV, val);
                }
            }
        }
        return maxV;
    }
};