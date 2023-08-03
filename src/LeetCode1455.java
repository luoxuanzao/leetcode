public class LeetCode1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] splits  =sentence.split(" ");
        for(int i = 0;i< splits.length;i++){
            if(splits[i].startsWith(searchWord)){
                return i + 1;
            }
        }
        return -1;
    }
}
