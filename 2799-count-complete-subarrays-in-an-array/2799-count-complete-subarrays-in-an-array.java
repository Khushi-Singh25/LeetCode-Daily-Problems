class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int tar = map.size();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int i=0, j=0, cnt=0;
        while(j<n){
            map2.put(nums[j], map2.getOrDefault(nums[j],0)+1);
            while(map2.size() == tar){
                cnt += (n-j);
                map2.put(nums[i], map2.get(nums[i])-1);
                if(map2.get(nums[i]) == 0) map2.remove(nums[i]);
                i++;
            }
            j++;
        }
        return cnt++;
    }
}