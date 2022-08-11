import java.lang.*;
import java.util.*;

public class SortKSortedArray {
  public static void main(String args[]) {
    KthSmallestElement obj = new KthSmallestElement();
    int[] input = obj.sortKSortedArray(w int[] {6,5,3,2,8,10,9}, 3);
    System.out.println(Arrays.toString(input));
  }

  public static int[] sortKSortedArray(int[] input, int k) {
    int n = input.length;
    PriorityQueue < Integer > pQueue = new PriorityQueue < > ();
    int sortedTillIdx = -1;
    for (int i = 0; i < n; i++) {
      pQueue.add(input[i]);
      if (pQueue.size() > k) {
        input[i - k] = pQueue.poll();
        sortedTillIdx = i - k;
      }
    }

    while (pQueue.size() != 0) {
      sortedTillIdx++;
      input[sortedTillIdx] = pQueue.poll();

    }
    return input;
  }

  public class myComparator implements Comparator < Integer > {
    public int compare(Integer n1, Integer n2) {
      int value = n1.compareTo(n2);
      if (value > 0) {
        return -1;
      } else if (value < 0) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
