//Min deletions required to form longest palindromin subsequence
//Input : aebcbda
//Output : 2
//Remove characters 'e' and 'd'
//Resultant string will be 'abcba'
//which is a palindromic string
//reverse the input and calculate count of LCS with inoutStr and its reverse  
//and substract it from inputStr.length(). that is ans.

public class MinDeletionsToLongestPalindromicSubsequence {
  static int LCS(String s1, String s2, int n) {
    int[][] t = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
            t[i][j] = 1 + t[i - 1][j - 1];
        } else {
            t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
        }
      }
    }

    return t[n][n];
  }

  static int minDeletions(String input) {
    int inputSize = input.length();
    StringBuilder sb = new StringBuilder();
    for (int i = inputSize - 1; i >= 0; --i) {
      sb.append(input.charAt(i));
    }

    int lcs = MinDeletionsToLongestPalindromicSubsequence.LCS(input, sb.toString(), inputSize);
    return inputSize - lcs;
  }

  public static void main(String[] args) {
    int result = MinDeletionsToLongestPalindromicSubsequence.minDeletions("aebcbda");
    System.out.println(result);
  }
}
