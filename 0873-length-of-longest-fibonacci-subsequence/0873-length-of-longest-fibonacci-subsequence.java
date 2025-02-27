class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) dp[i][j]=2;
        }
        int maxL = 0;
        for(int j=0; j<n; j++){
            for(int k=j+1; k<n; k++){
                int tar = arr[k] - arr[j];
                if(map.containsKey(tar) && map.get(tar)<j){
                    int i = map.get(tar);
                    dp[j][k] = dp[i][j] + 1;
                }
                maxL = Math.max(maxL, dp[j][k]);
            }
        }
        return maxL>=3 ? maxL : 0;
    }
}