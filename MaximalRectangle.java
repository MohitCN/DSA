class Solution {

  static class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }
  }

  public static int largestRectangleArea(int[] input) {

    int n = input.length;
    Pair[] NSR = nextSmallerElementToRight(input, n);
    Pair[] NSL = nextSmallerElementToLeft(input, n);
    int maxResult = 0;

    for (int i = 0; i < n; i++) {

      int rightArea = 0;
      int leftArea = 0;

      if (NSR[i].idx == -1) {
        rightArea = (n - i) * input[i];
      } else {
        rightArea = (NSR[i].idx - i) * input[i];
      }
      if (NSL[i].idx == -1) {
        leftArea = i * input[i];
      } else {
        leftArea = ((i - NSL[i].idx) - 1) * input[i];
      }

      maxResult = Math.max(rightArea + leftArea, maxResult);
    }
    return maxResult;
  }

  //[{-1,-1}, {-1,-1}, {2,1},{2,1},{4,3},{-1,-1},{1,5}]
  public static Pair[] nextSmallerElementToLeft(int[] input, int n) {

    ArrayDeque < Integer > helperStack = new ArrayDeque < > ();
    Pair[] result = new Pair[n];

    for (int i = 0; i < n; i++) {
      while (!helperStack.isEmpty() &&
        input[helperStack.peek()] >= input[i]) {
        helperStack.pop();
      }
      if (helperStack.isEmpty()) {
        helperStack.push(i);
        result[i] = new Pair(-1, -1);
      } else if (input[helperStack.peek()] < input[i]) {
        result[i] = new Pair(input[helperStack.peek()], helperStack.peek());
        helperStack.push(i);
      }
    }
    // for(int i = 0; i<n; i++) {
    //     System.out.println("{ " +result[i].val+" ,"+result[i].idx+" }");
    // }
    return result;
  }

  //[{2,1}, {1,5}, {4,3},{1,5},{1,5},{-1,-1},{-1,-1}]
  public static Pair[] nextSmallerElementToRight(int[] input, int n) {
    ArrayDeque < Integer > helperStack = new ArrayDeque < > ();
    Pair[] result = new Pair[n];

    for (int i = n - 1; i >= 0; i--) {
      while (!helperStack.isEmpty() &&
        input[helperStack.peek()] >= input[i]) {
        helperStack.pop();
      }
      if (helperStack.isEmpty()) {
        helperStack.push(i);
        result[i] = new Pair(-1, -1);
      } else if (input[helperStack.peek()] < input[i]) {
        result[i] = new Pair(input[helperStack.peek()], helperStack.peek());
        helperStack.push(i);
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.println("{ " + result[i].val + " ," + result[i].idx + " }");
    }
    return result;
  }

  public int maximalRectangle(char[][] input) {
    int rows = input.length;
    int col = input[0].length;
    int maxArea = 0;
    int[] helper = new int[col];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < col; j++) {
        int currElement = input[i][j] - '0';
        if (currElement != 0) {
          helper[j] = currElement + helper[j];
        } else {
          helper[j] = currElement;
        }
      }
      int currArea = largestRectangleArea(helper);
      maxArea = Math.max(currArea, maxArea);
    }
    return maxArea;

  }

}
