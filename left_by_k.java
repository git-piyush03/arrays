/*
Left Rotate array by k places
    Brute force approach:
        -> 1st pass: copy k elements in an array temp - O(k)
        -> 2nd pass: shift the remaining elements by k places - O(n-k)
        -> 3rd pass: add back the temp elements at the end of the array- O(k)
        -> TC: O(n+k)
        -> SC: O(k) beacuse we are using an extra array temp of size k
 */
/* 
import java.util.Arrays;
public class left_by_k {
    public static void rotate(int a[], int k){
        int i;
        int n=a.length;
        int temp[]=new int[k];
        for(i=0;i<k;i++) //1st pass: O(k)
            temp[i]=a[i];

        for(i=k;i<n;i++) //2nd pass: O(n-k)
            a[i-k]=a[i];

        for(i=n-k;i<n;i++) //3rd pass: O(k)
            a[i]=temp[i-(n-k)];
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        int k=3;
        rotate(a,k);
    }
}
*/
/*
OPTIMAL APPRAOCH:
    [1,2,3,4,5,6,7] k=3:
        -> take k elements and reverse it :[3,2,1] -O(k)
        -> take i+k elements to n and reverse it:[7,6,5,4] -O(n-k)
        -> now reverse the entire array again for the answer -O(n)
            [3,2,1,7,6,5,4] => [4,5,6,7,1,2,3]
        -> TC: O(2n)
        -> SC: O(1)
 */
import java.util.Arrays;
public class left_by_k {
    public static void reverse(int arr[], int start, int end) {
        while(start<=end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void rotate(int a[], int k) {
        int n=a.length;
        reverse(a,0,k-1);
        reverse(a,k,n-1);
        reverse(a,0,n-1);
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        int k=2;
        rotate(a,k);
    }
}