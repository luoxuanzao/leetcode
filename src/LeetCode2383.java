public class LeetCode2383 {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int extraEnergy = 0;
        int extraExperience = 0;
        int totalExperience = 0;
        int length = energy.length;
        for (int i = 0; i < length; i++) {
            extraEnergy += energy[i];
            extraExperience = Math.max(extraExperience, experience[i] - totalExperience);
            totalExperience += experience[i];
        }
        int result = initialEnergy > extraEnergy ? 0 : extraEnergy - initialEnergy;
        result += (initialExperience > extraExperience ? 0 : extraExperience - initialExperience);
        return result;
    }

    public static void main(String[] args) {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int[] energy = new int[]{1, 4, 3, 2};
        int[] experience = new int[]{2, 6, 3, 1};
        leetCode2383.minNumberOfHours(5, 3, energy, experience);
    }
}
