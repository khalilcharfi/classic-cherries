package org.paukov.exercise.array;

import java.util.Arrays;

/**
 * Created by dpaukov on 5/20/18.
 * <p>
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 */
public class DutchNationalFlag {

  static int[] partition(int[] array, int pivot) {
    int lt = 0;
    int gt = array.length - 1;
    int i = 0;
    while (i <= gt) {
      if (array[i] < pivot) {
        swap(array, i, lt);
        i++;
        lt++;
      } else if (array[i] > pivot) {
        swap(array, i, gt);
        gt--;
      } else {
        i++;
      }
    }
    return array;
  }

  static void swap(int[] array, int i, int j) {
    int t = array[i];
    array[i] = array[j];
    array[j] = t;
  }

  public static void main(String args[]) {
    System.out.println(
        "Partition: " + Arrays.toString(partition(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2}, 2)));
    System.out.println("Partition: " + Arrays
        .toString(partition(new int[]{0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0}, 0)));

    System.out.println(
        "Partition4: " + Arrays.toString(partition4(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3})));
  }

  // Given an array of objects with keys that takes only one of 4 values
  // reorder it so all objects with the same key appear together.
  static int[] partition4(int[] array) {
    int lt = 0;
    int gt = array.length - 1;
    int i = 0;
    while (i <= gt) {
      if (array[i] < 2) {
        swap(array, i, lt);
        i++;
        lt++;
      } else if (array[i] > 3) {
        swap(array, i, gt);
        gt--;
      } else {
        i++;
      }
    }
    i = lt;
    while (i <= gt) {
      if (array[i] == 3) {
        swap(array, i, gt);
        gt--;
      } else {
        i++;
      }
    }
    return array;
  }

}
