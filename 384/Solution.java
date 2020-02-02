import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Solution {
    int[] array;
    int[] original;
    Random random=new Random();
    List<Integer>result=new LinkedList<>();
    public int randRange(int i,int j){
        return random.nextInt(j-i)+i;
    }

    /**
     * 打乱数组 使其各种排列组合以相同的概率返回
     * 暴力思路
     * 不放回地取每个数字 每个元素第k次取到的概率是相同的 所以可以复制一个arraylist 取一个删一个然后组成一个数组
     *
     * Fisher-Yates 洗牌算法
     * 类似于暴力算法 不过是用swap交换已经取到的和没取到的可以减少删除用的时间消耗
     *
     *
     * java 中数组赋值的是引用  想要的到新的副本应该用.clone()方法
     * @param nums
     */
    public Solution(int[] nums) {
        array=nums;
        original=nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array=original;
        original=original.clone();
        return array;
    }
    public void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<array.length;i++){
            int index=randRange(i,array.length);
            swap(i,index);
        }
        return array;
    }

}