class Pair{
    String word; int lev;
    Pair(String word, int lev){
        this.word = word;
        this.lev = lev;
    }
}
class Solution {
    public int ladderLength(String start, String end, List<String> words) {
        HashSet<String> set = new HashSet<>();
        for(String str : words){
            set.add(str);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 1));
        set.remove(start);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int lev = q.poll().lev;
            if(word.equals(end)){
                return lev;
            }
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char arr[] = word.toCharArray();
                    arr[i] = ch;
                    String str = new String(arr);
                    if(set.contains(str)){
                        q.add(new Pair(str, lev+1));
                        set.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}