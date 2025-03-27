class Solution {
public:
    int minimumIndex(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int,int> map1;
        unordered_map<int,int> map2;

        for(int &num : nums){
            map2[num]++;
        }
        for(int i=0; i<n; i++){
            int num = nums[i];
            map1[num]++; map2[num]--;
            int n1 = i+1, n2 = n-i-1;
            if(map1[num]>n1/2 && map2[num]>n2/2){
                return i;
            }
        }
        return -1;
    }
};