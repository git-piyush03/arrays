public class SimpleConsecutive {
    public static int minMissing(int[] a, int k) {
        int n = a.length, ans = 0;

        for (int i = 0; i + k <= n; i++) { /*i=0,4<=6,present[5],count=0*/
            boolean[] present = new boolean[k + 1];
            int count = 0;

            for (int j = i; j < i + k; j++) { /* j=1,1<4, */
                if (a[j] >= 1 && a[j] <= k && !present[a[j]]) {
                    present[a[j]] = true;
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return k - ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 6, 5, 4};
        int k = 4;
        System.out.println(minMissing(arr, k)); // prints 3
    }
}
