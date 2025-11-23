/*
CALCULATE THE NEXT PERMUTATION:
    -> [3,1,2] can be re-arranged in 3! ways ,i.e., 6
    -> [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
    -> the above possibilities are sorted
    -> next permutation becomes [3,2,1]
    -> if there is no one after the arrangement we move to the start
    -> for example next permutation of [3,2,1] becomes [1,2,3] 
 */
/*
    1. longer prefix match => find the breakpoint a[i] < a[i+1]
    2. find > 1, but the smallest one, so that u stay close (slightly greater)
    3. try to place remaining in sorted order

    -> [2 1 || 5 4 3 0 0], || => breakpoint...the no.s from the last are increasing and we observe a dip in the curve at 1, i.e., sudden dip found
    -> get the index of 1, from where the breakpoint starts
    -> n-2 to 0, if a[i]<a[i+1], index=i
    -> if index==-1, it means we are at the highest no. so reverse it to get the answer
 */
import java.util.Arrays;
public class next_permutation {
    public static int[] next(int a[]) {
        int index=-1, n=a.length;
        for(int i=n-2;i>=0;i--) {
            if(a[i]<a[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(a,0,n-1);
        }
        for(int i=n-1;i>index;i--){
            if(a[i]>a[index]){
                int temp=a[i];
                a[i]=a[index];
                a[index]=temp;
                break;
            }
        }
        reverse(a,index+1,n-1);
        return a;
    }
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
    public static void main(String[] args) {
        int a[]={2,3,5,4,1,0,0};
        System.out.println(Arrays.toString(next(a)));
    }
}
