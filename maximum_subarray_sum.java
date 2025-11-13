//MAXIMAUM SUBARRAY SUM

/*
BRUTE FORCE APPROACH: O(N^3) can be optimized to O(N^2)
    -> traverse through the entire array taking each element
    -> can optimeze to n^2 by taking incremental sum and removing the k loop
    -> TC: O(n^3) => O(n^2) is the better approach
    -> SC: O(1)
*/
/*
public class maximum_subarray_sum {
    public static int maxSub(int a[]) {
        int n=a.length, sum=0, max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    sum+=a[k];
                }
                max=Math.max(sum,max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]={-7,-3,4,-1,-2,1,5,-3};
        System.out.println("Max subarray sum: "+maxSub(a));
    }
}
*/
/*
OPTIMAL APPROACH: KADANE'S ALGORITHM
    -> traverse through the array and also keep taking the sum
    -> if sum<0 then adding more negatives is useless, hence make it 0
    -> take the maximum between max and sum, return the max subarray sum
    -> TC: O(n)
    -> sc: O(1)
 */
public class maximum_subarray_sum {
    public static int maxSub(int a[]) {
        int n=a.length, start=-1, ansStart=-1, ansEnd=-1;
        int sum=0, max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(sum==0) //add this if the qn asks to print the start and end index of the subarray
                start=i;
            sum+=a[i];
            if(sum > max){
                max=sum;
                ansStart=start; //keeps the track of the start index of the subarrray
                ansEnd=i; //keeps the track of the end index
            }
            if(sum < 0)
                sum=0;
        }
        System.out.println("subarray: ["+ansStart+","+ansEnd+"]");
        return max<0?0:max; //did this as it was mentioned in the qn to take empty subarray if a we have negative max
        //and hence an empty subarray has a sum 0
    }
    public static void main(String[] args) {
        int a[]={-7,-3,4,-1,-2,1,5,-3};
        System.out.println("Max subarray sum: "+maxSub(a));
    }
}