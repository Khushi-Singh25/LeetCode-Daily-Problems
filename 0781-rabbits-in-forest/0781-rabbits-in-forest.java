class Solution {
    public int numRabbits(int[] ans) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int zero = 0;
        for(int num : ans){
            if(num==0) zero++;
            else map.put(num, map.getOrDefault(num,0)+1);
        }
        int rabbit = 0;
        for(int key : map.keySet()){
            int cnt = map.get(key);
            int times = 0;
            if(cnt % (key+1) == 0) times = cnt/(key+1);
            else times = (cnt/(key+1))+1;
            rabbit += ((key+1)*times);
        }
        return rabbit + zero;
    }
}