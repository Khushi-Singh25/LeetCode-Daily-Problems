class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totB = 0;

        for(int i=0; i<n; i++){
            int freq[] = new int[26];
            for(int j=i; j<n; j++){
                int ch = s.charAt(j);
                freq[ch-'a']++;
                totB += getB(freq);
            }
        }
        return totB;
    }

    public int getB(int[] freq){
        int maxC = 0; int minC = Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                maxC = Math.max(maxC, freq[i]);
                minC = Math.min(minC, freq[i]);
            }
        }
        return maxC - minC;
    }    
}