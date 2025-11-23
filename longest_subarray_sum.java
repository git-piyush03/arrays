//LONGEST SUB-ARRAY WITH SUM K

//import java.util.HashMap;

/*
BRUTE FORCE:
    ->TC: O(n^3)
    ->TC can be reduced to O(n^2) by moving the m loop inside the j loop and calculating sum as we traverse
    ->SC: O(1)
*/
/*
public class longest_subarray_sum {
    public static int subarray(int a[], int k) {
        int n=a.length;
        int maxLen=0;
        long sum=0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                sum=0;
                for(int m=i;m<=j;m++) {
                    sum+=a[m];
                }
                if(sum==k){
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int a[]={1,2,4,5,1,1,1,2,3};
        System.out.println("Maximum length of subarray: "+subarray(a,3));
    }
}
*/

/*
BETTER APPROACH:
    -> use hash map to put the prefix sum along with its current index
    -> check if the sum is unique, then put in the hash map
    -> check if prefix-k exists; if yes we have a subarray summing to k; check its length and take max
    -> this better approach is the optimal for array with negatives and zeros
    -> TC: O(n)
    -> SC: O(n)
*/
/*
public class longest_subarray_sum {
    public static int subarray(int a[],int k) {
        int n=a.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int prefix=0;
        map.put(0,-1); //prefix sum 0 before array starts
        for(int i=0;i<n;i++) {
            prefix+=a[i];
            if(!map.containsKey(prefix)){
                map.put(prefix,i);
            }
            if(map.containsKey(prefix-k)){
                int j=map.get(prefix-k);
                maxLen=Math.max(maxLen,i-j);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int a[]={2,0,0,0,3};
        System.out.println("Maximum length of subarray: "+subarray(a,3));
    }
}
/*
OPTIMAL APPROACH:
    -> go right, exceed the sum k, trim from the left then again the same process
    -> works for positives and zeros only
    -> TC: O(2n), outer while loop O(n) whereas inner loop does not go for n in every iteration, hence O(n+n)
    -> SC: O(1)
 */
public class longest_subarray_sum {
    public static int subarray(int a[],int k) {
        int n=a.length;
        int left=0,right=0,maxLen=0;
        long sum=a[0];
        while(right < n){ //right < n, checks for out of bounds
            while(left <= right && sum>k){ //subarray exists between left and right
                sum-=a[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
            if(right < n)
                sum+=a[right];
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int a[]={1,2,1,2,1};
        System.out.println("Maximum length of subarray: "+subarray(a,3));
    }
}