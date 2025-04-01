class Solution {
public:
    long long mostPoints(vector<vector<int>>& ques) {
        int n = ques.size();
        vector<long long> dp(n+1, -1);
        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            long long pick = ques[i][0];
            if(i+ques[i][1]+1 < n){
                pick += dp[i+ques[i][1]+1];
            }
            long long notPick = dp[i+1];
            dp[i] = max(pick, notPick);
        }
        return dp[0];
        //return func(0, n, ques, dp);
    }

    // long long func(int i, int n, vector<vector<int>>& ques, vector<long long>& dp){
    //     if(i>=n) return 0;
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }
    //     long long pick = ques[i][0] + func(i+ques[i][1]+1, n, ques, dp);
    //     long long notPick = func(i+1, n, ques, dp);
    //     return dp[i] = max(pick, notPick);
    // }
};