class NextGreaterElement_I {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;

    int[] result = new int[n];

    Map < Integer, Integer > greaterElementMap = new HashMap < > ();
    Stack < Integer > helperStack = new Stack < > ();

    for (int i = 0; i < m; i++) {

      while (!helperStack.isEmpty() && nums2[i] > helperStack.peek()) {
        int temp = helperStack.pop();
        greaterElementMap.put(temp, nums2[i]);
      }

      if (helperStack.isEmpty() || nums2[i] <= helperStack.peek()) {
        helperStack.push(nums2[i]);
      }
    }

    for (int i = 0; i < n; i++) {
      if (greaterElementMap.containsKey(nums1[i])) {
        result[i] = greaterElementMap.get(nums1[i]);
      } else {
        result[i] = -1;
      }
    }

    return result;

  }
}
