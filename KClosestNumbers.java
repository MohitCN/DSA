import java.lang.*;
import java.util.*;

public class KClosestNumbers {
  public static void main(String args[]) {
    KClosestNumbers obj = new KClosestNumbers();
    int[] input = obj.kClosestNumbers(new int[] {6,5,3,2,8,10,9},3,5);
    System.out.println(Arrays.toString(input));
  }

  public int[] kClosestNumbers(int[] input, int k, int x) {
    int n = input.length;
    PriorityQueue < Pair > pQueue = new PriorityQueue < > (new customComparator());
    int[] result = new int[k];
    for (int i = 0; i < n; i++) {
      pQueue.add(new Pair(Math.abs(input[i] - x), input[i]));
      if(pQueue.size() > k) {
          pQueue.poll();
      }
    }

    int counter = 0;
    while (pQueue.size() != 0 && counter < k) {
      Pair tempResult = pQueue.poll();
      result[counter++] = tempResult.originalValue;
    }
    return result;
  }

}

class Pair {
  int absValue;
  int originalValue;
  Pair(int a, int b) {
    this.absValue = a;
    this.originalValue = b;
  }
}

class customComparator implements Comparator < Pair > {
  public int compare(Pair p1, Pair p2) {
    Integer n1 = p1.absValue;
    Integer n2 = p2.absValue;
    int value = n1.compareTo(n2);
    if (value > 0) {
      return -11;
    } else if (value < 0) {
      return 1;
    } else {
      return 0;
    }
  }
}
