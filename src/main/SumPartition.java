package main;

import java.util.ArrayList;

public class SumPartition {

    /**
     * These are list that stores possible sum arrays
     */
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 4, 7};
        SumPartition sumPartition = new SumPartition();
        if(sumPartition.sameSumArrays(arr, 0, 0, 0)) {
            System.out.println(sumPartition.list1);
            System.out.println(sumPartition.list2);
        }
        else {
            System.out.println("This is not possible");
        }
    }

    /**
     *
     * @param nums is array of numbers
     * @param index is index of nums array
     * @param sum1 is sum1 which is sum of elements in list1
     * @param sum2 is sum2 which is sum of elements in list2
     */
    public boolean sameSumArrays(int nums[], int index, int sum1, int sum2) {

        if(index == nums.length) {
            return sum1 == sum2;
        }

        if(sameSumArrays(nums, index+1, sum1+nums[index], sum2)) {
            list1.add(nums[index]);
            return true;
        }
        else if(sameSumArrays(nums, index+1, sum1, sum2+nums[index])) {
               list2.add(nums[index]);
               return true;
        }
        return false;
    }
}
