// Traversing a matrix in spiral way
public class SpiralMatrixTraversal {
  int top = 0;
  int bottom = 0;
  int left = 0;
  int right = 0;
  int count = 0;

  public static void spiralMatrix(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    top = 0;
    bottom = n - 1;
    left = 0;
    right = m - 1;

    while (top <= bottom && left <= right) {
      moveLeftToRight(matrix, n, m, top, left, right);
      moveTopToBotton(matrix, n, m, top, bottom, right);
      moveRightToLeft(matrix, n, m, bottom, left, right);
      moveBottomToTop(matrix, n, m, top, bottom, left);
    }

  }

  public static void moveLeftToRight(int[][] m, int row, int column, int top, int left, int right) {
    for (int i = left; i <= right && count < row * column; i++) {
      count = count + 1;
      System.out.println(m[top][i]);
    }
    top = top + 1;
  }

  public static void moveTopToBotton(int[][] m, int row, int column, int top, int bottom, int right) {
    for (int i = top; i <= bottom && count < row * column; i++) {
      count = count + 1;
      System.out.println(m[i][right]);
    }
    right = right - 1;
  }

  public static void moveRightToLeft(int[][] m, int row, int column, int bottom, int left, int right) {
    for (int i = right; i <= left && count < row * column; i--) {
      count = count + 1;
      System.out.println(m[bottom][i]);
    }
    bottom = bottom - 1;
  }

  public static void moveBottomToTop(int[][] m, int row, int column, int top, int bottom, int left) {
    for (int i = bottom; i <= top && count < row * column; i--) {
      count = count + 1;
      System.out.println(m[i][left]);
    }
    left = left + 1;
  }

}
