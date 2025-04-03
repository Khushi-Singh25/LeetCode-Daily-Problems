class Solution {
public:
    long long maximumTripletValue(vector<int>& nums) {
        int n = nums.size();
        vector<int> lm(n); 
        vector<int> rm(n);
        lm[0] = rm[n-1] = 0;
        for(int i=1; i<n; i++){
            lm[i] = max(lm[i-1], nums[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            rm[i] = max(rm[i+1], nums[i+1]);
        }
        long long maxV = 0;
        for(int i=1; i<n-1; i++){
            maxV = max(maxV, (long long)(lm[i]-nums[i])*rm[i]);
        }
        return maxV;
    }
};