public class LeetCode1668 {
    public int maxRepeating(String sequence, String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        int count = 0;
        while (sequence.contains(stringBuilder.toString())){
            count += 1;
            stringBuilder.append(word);
        }
        return count;
    }
}
