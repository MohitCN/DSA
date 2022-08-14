public class MajorityElement_I {
    public int majorityElement(int[] num) {
        int major = num[0];
        int count = 1;
        int n = num.length;
        if(n == 1) {
            return num[0];
        }
        for(int i=1; i<n; i++) {
            if(count==0) {
                count = 1;
                major = num[i];
            } else if(major == num[i]) {
                count++;
            } else {
                count--;
            }   
        }
        return major;
    }
}
