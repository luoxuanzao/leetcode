public class LeetCode1653 {


    /**
     * 动态规划
     * 如果新字符是b 直接s(n) = s(n-1)
     * 如果新字符是a Math.min(一步删除a，替换前面所有的b）
     *
     * @param s
     * @return
     */
    public int minimumDeletions(String s) {
        int f = 0;
        int countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                f = Math.min(f + 1, countB);
            } else {
                countB += 1;
            }
        }
        return f;
    }

    //    /**
//     * 两次遍历，模拟aabb切割线 切割线之前的都是a 切割线之后的都是b 计算需要删除的次数
//     * @param s
//     * @return
//     */
//    public int minimumDeletions(String s) {
//        int init = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == 'a') {
//                init += 1;
//            }
//        }
//        int result = init;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == 'a') {
//                init -= 1;
//            } else if (s.charAt(i) == 'b') {
//                init += 1;
//            }
//            result = Math.min(result, init);
//        }
//        return result;
//    }

}
