/*RE-ARRANGE ELEMENT BY SIGN
    -> FOR EXAMPLE: [3,1,-2,-5,2,-4] gives the output [3,-2,1,-5,2,-4]
    -> the order is maintained
    -> re arranged in alterantive +ve and -ve elements
*/

/*
BRUTE FORCE APPROACH
    -> create 2 arraylists to store the +ve and -ve elements
    -> add the element inserted back into the original array
    -> note that all +ve elements fall under even indexes and -ve elements fall under odd indexes
    -> TC: O(N)+O(N/2)
    -> SC: O(N/2)+O(N/2) = O(N)
 */
/*
import java.util.ArrayList;
import java.util.Arrays;
public class rearrange_by_sign {
    public static int[] rearrange(int a[]) {
        int n=a.length;
        ArrayList <Integer> pos=new ArrayList<>();
        ArrayList <Integer> neg=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(a[i]>0)
                pos.add(a[i]);
            else
                neg.add(a[i]);
        }
        if(pos.size() > neg.size()) { //the if-else is used if no. of pos elements != neg
            for(int i=0;i<neg.size();i++){ //this one loop is enough for equal pos and neg
                a[2*i]=pos.get(i);
                a[2*i+1]=neg.get(i);
            }
            int index=2*neg.size();
            for(int i=neg.size();i<pos.size();i++){
                a[index]=pos.get(i);
                index++;
            }
        }
        else{
            for(int i=0;i<neg.size();i++){
                a[2*i]=pos.get(i);
                a[2*i+1]=neg.get(i);
            }
            int index=2*pos.size();
            for(int i=pos.size();i<neg.size();i++){
                a[index]=neg.get(i);
                index++;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int a[]={3,1,-2,-5,2,-4,9,6,8};
        System.out.println(Arrays.toString(rearrange(a)));
    }
}
*/
/*
OPTIMAL APPROACH:
    -> the thing done using 2 arrays is optimized to be done in a single extra array
    -> we work on even and odd index and add these into an external array
    -> TC: O(N)
    -> SC: O(N)
 */

import java.util.Arrays;
public class rearrange_by_sign {
    public static int[] rearrange(int a[]) {
        int n=a.length, pos=0, neg=1;
        int ans[]=new int[n];
        for(int i=0;i<n;i++) {
            if(a[i]>0){ 
                ans[pos]=a[i];
                pos+=2;
            }
            else{
                ans[neg]=a[i];
                neg+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int a[]={3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrange(a)));
    }
}
/*
Another variety of qn:
    -> it states that no. of +ves and -ves are not equal
    -> if any of the positive and negative numbers are left, add them at the end without altering the order
    -> USE THE BRUTE FORCE APPROACH
    -> TC: O(n) + O(m(pos,neg)) + O(leftovers)
        => O(n) + O(n) = O(2n)
    -> SC: O(n)
 */
