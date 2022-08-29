// (input) a g b c b a -> input gets reversed and we apply longest common subsequence on it which givews us LCS.
// (revered input) a b c b g a
// LCS -> abcba


public class LongestPalindromicSubsequence {

  private static int LCS(String s1, String s2) {
    int m = s1.length();
    int[][] t = new int[m + 1][m + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    return t[m][m];
  }

  public static int LPS(String input) {
    StringBuilder sb = new StringBuilder();
    for (int i = input.length() - 1; i >= 0; --i) {
      sb.append(input.charAt(i));
    }
    return Solution.LCS(input, sb.toString());
  }

  public static void main(String[] args) {
    int result = Solution.LPS("agbcba");
    System.out.println(result);
  }
}
