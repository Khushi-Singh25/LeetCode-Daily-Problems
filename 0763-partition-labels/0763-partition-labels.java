class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int arr[] = new int[26];
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            arr[ch-'a'] = i;
        }
        int i=0;
        int start=0, end=0;
        while(i<n){
            char ch = s.charAt(i);
            end = Math.max(end, arr[ch-'a']);
            if(i==end){
                ans.add(end-start+1);
                start = end+1;
            }
            i++;
        }
        return ans;
    }
}