class TowerOfHanoi {
  public static void main(String[] args) {
    TowerOfHanoi.toh(3,1,3,2);
  }

  public static void toh(int n, int start, int end, int helper) {
    if (n == 1) {
      System.out.println("Move " + n + " from " + start + " to " + end);
      return;
    }

    toh(n - 1, start, helper, end);

    System.out.println("Move " + n + " from " + start + " to " + end);

    toh(n - 1, helper, end, start);

    return;
  }

}
