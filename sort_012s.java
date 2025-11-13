//SORT AN ARRAY CONTAINING ONLY 0's, 1's AND 2's

/*
BRUTE FORCE APPROACH: use a sorting algorithm
    -> merge sort gives O(nlogn)
*/

/*
BETTER APPROACH: keeping track of the count of 0,1,2

    -> keep a count of the no. of 0's,1's and 2's in the array
    -> change the values in original array using 3 different loops
    -> TC: O(2n), O(n) for storing count and another O(n) for changing the values
    -> SC: O(1)
*/
/*
import java.util.Arrays;
public class sort_012s {
    public static int[] sort(int a[]) {
        int n=a.length;
        int c0=0, c1=0, c2=0;
        for(int i=0;i<n;i++) {
            if(a[i]==0)
                c0++;
            if(a[i]==1)
                c1++;
            if(a[i]==2)
                c2++;
        }
        for(int i=0;i<c0;i++)
            a[i]=0;
        for(int i=c0;i<c0+c1;i++)
            a[i]=1;
        for(int i=c0+c1;i<n;i++)
            a[i]=2;
        return a;
    }
    public static void main(String[] args) {
        int a[]={1,1,1,2,2,0,1,0,0,2,1};
        System.out.println(Arrays.toString(sort(a)));
    }
}
*/

/*
OPTMAL APPROACH: Dutch National Flag Algorithm

    -> using three pointers: low,mid,high
    -> between 0 and low-1 we have all the zeros, between low and mid-1 we have all the 1s
    -> and between mid and high all unsorted elements and between high and n-1 all the 2s
    -> if a[mid]==0 => swap(a[low],a[mid]), low++, mid++
    -> if a[mid]==1 just mid++
    -> if a[mid]==2 => swap(a[mid],a[high]), high--
    -> TC: O(n)
    -> SC: O(1)
 */
import java.util.Arrays;
public class sort_012s {
    public static int[] sort(int a[]) {
        int n=a.length;
        int low=0, mid=0, high=n-1;
        while(mid<=high){
            if(a[mid]==0){
                a[low]=a[low] ^ a[mid];
                a[mid]=a[low] ^ a[mid];
                a[low]=a[low] ^ a[mid];
                low++;
                mid++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else{
                a[mid]=a[mid] ^ a[high];
                a[high]=a[mid] ^ a[high];
                a[mid]=a[mid] ^ a[high];
                high--;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int a[]={1,1,1,2,2,0,1,0,0,2,1};
        System.out.println(Arrays.toString(sort(a)));
    }
}