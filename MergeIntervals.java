import java.util.*;
import java.util.List;
import java.util.ArrayList;

class MergeIntervals {
  public static void main(String[] args) {
    int[][] input = {{5,6},{1,3},{7,9},{2,3},{11,14},{12,13},{7,11}};
    int[][] result = MergeIntervals.merge(input);
    System.out.println(Arrays.deepToString(result));
  }

  public static int[][] merge(int[][] input) {
    if (input.length <= 1) {
      return input;
    }
    int n = input.length;
    int m = input[0].length;

    List < int[] > result = new ArrayList < > ();

    Arrays.sort(input, ((a, b) -> Integer.compare(a[0], b[0])));

    for (int i = 0; i < n; i++) {

      if (result.size() == 0) {
        result.add(input[i]);
      }
      int[] previousInterval = result.get(result.size() - 1);
      if (previousInterval[1] >= input[i][0]) {
        previousInterval[1] = Math.max(input[i][1], previousInterval[1]);
      } else {
        result.add(input[i]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }

}
