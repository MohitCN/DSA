class MajorityElement_II {
  public List < Integer > majorityElement(int[] nums) {
    int n = nums.length;
    List < Integer > result = new ArrayList < > (2);
    int firstMajor = Integer.MAX_VALUE;
    int fmCount = 0;
    int secondMajor = Integer.MIN_VALUE;
    int smCount = 0;

    for (int i = 0; i < n; i++) {
      //vote for any one candidate avaialbe
      if (nums[i] == firstMajor) {
        fmCount++;
      } else if (nums[i] == secondMajor) {
        smCount++;
      }

      //if do not want to vote for any one present, nominate yourself
      else if (fmCount == 0) {
        fmCount++;
        firstMajor = nums[i];
      } else if (smCount == 0) {
        smCount++;
        secondMajor = nums[i];
      }

      //else cancle votes of each one
      else {
        fmCount--;
        smCount--;
      }
    }

    fmCount = 0;
    smCount = 0;
    //validate both major elements are indeed major
    for (int i = 0; i < n; i++) {
      if (nums[i] == firstMajor) {
        fmCount++;
      } else if (nums[i] == secondMajor) {
        smCount++;
      }
    }

    if (fmCount > n / 3) {
      result.add(firstMajor);
    }
    if (smCount > n / 3) {
      result.add(secondMajor);
    }
    return result;

  }
}
