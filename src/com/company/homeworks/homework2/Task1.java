package com.company.homeworks.homework2;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {

        int nums[] = {1, 4, 5, 3, 2, 3, 6, 3};
        int lastNumber = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = lastNumber;
        System.out.println(Arrays.toString(nums));
    }
}
