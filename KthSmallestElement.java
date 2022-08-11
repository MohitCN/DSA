import java.lang.*;
import java.util.*;

public class KthSmallestElement {
  public static void main(String args[]) {
    KthSmallestElement obj = new KthSmallestElement();
    int ans = obj.kthSmallest(new int[]{7,5,2,9,8,0,3,-5}, 8, 3);

  }

  public int kthSmallest(int[] input, int n, int k) {
    PriorityQueue < Integer > pQueue = new PriorityQueue < > (new myComparator());

    for (int ele: input) {
      pQueue.add(ele);

      if (pQueue.size() > k) {
        pQueue.poll();
      }
    }
    return pQueue.peek();

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
