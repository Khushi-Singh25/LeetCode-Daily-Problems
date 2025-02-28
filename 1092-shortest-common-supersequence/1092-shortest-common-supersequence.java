class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){                                                     
            for(int j=0; j<n+1; j++) dp[i][j]=0;
        }
        for(int j=0; j<n+1; j++) dp[0][j]=0;
        for(int i=0; i<m+1; i++) dp[i][0]=0;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder("");
        int i=m, j=n;
        while(i>0 && j>0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                sb.append(s.charAt(i-1)); i--; j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(s.charAt(i-1)); i--;
            }else{
                sb.append(t.charAt(j-1)); j--;
            }
        }
        while(i>0){
            sb.append(s.charAt(i-1)); i--;
        }
        while(j>0){
            sb.append(t.charAt(j-1)); j--;
        }
        sb.reverse();
        return sb.toString();
    }
}