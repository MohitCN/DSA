import java.util.Stack;
import java.util.*;

public class nextGreaterElement_II {
  public static void main(String[] args) {
    int[] re = nextGreaterElement_II.nextGreaterElements(new int[] {4,5,3,6,5,1});
    for (int a: re) {
      System.out.println(a);
    }
  }
  public static int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack < Integer > helperStack = new Stack < > ();

    for (int i = n - 1; i >= 0; i--) {
      helperStack.push(nums[i]); // o(n)
    }

    for (int i = n - 1; i >= 0; i--) {

      while (!helperStack.isEmpty() && nums[i] >= helperStack.peek()) {
        helperStack.pop();
      }

      if (helperStack.isEmpty()) {
        result[i] = -1;
        helperStack.push(nums[i]);
      } else if (nums[i] < helperStack.peek()) {
        result[i] = helperStack.peek();
        helperStack.push(nums[i]);
      }
    }
    return result;
  }
}
