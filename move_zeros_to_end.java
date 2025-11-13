//MOVE ALL THE ZEROS IN AN ARRAY TO END

import java.util.Arrays;
/*
BRUTE FORCE APPROACH:
    -> create a temp array to store all non-zero elements
    -> add the non-zero elements from the beginning of the original array
    -> then add zeros to the remaining part of the array
    -> TC: O(2n)
    -> SC: extra space O(x)(due to temp which stores non-zero elements), worst can go to O(n)
 */
/*
public class move_zeros_to_end {
    public static void move(int a[]){
        ArrayList<Integer> temp=new ArrayList<>();
        int n=a.length;
        for(int i:a){ //TC: O(n)
            if(i!=0)
                temp.add(i);
        }

        for(int i=0;i<temp.size();i++){ //TC: O(x), where x is the no. of non-zero elements
            a[i]=temp.get(i);
        }

        for(int i=temp.size();i<n;i++){ //TC: O(n-x)
            a[i]=0;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int a[]={1,0,2,3,4,0,0,5,0};
        move(a);
    }
}
*/
/*
OPTIMAL APPROACH:
    -> 1st pass: find the 1st zero in the array and mark its position
    -> 2nd pass: two pointer approach, swap the zero from a non-zero no.
    -> TC: O(n)
    -> SC: O(1)
 */

public class move_zeros_to_end {
    public static void move(int a[]) {
        int j=-1;
        int n=a.length;
        for(int i=0;i<n;i++){ //TC: O(x), where x is the posi of the 1st zero found
            if(a[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1){
            System.out.println(Arrays.toString(a));
            System.exit(0);
        }
        for(int i=j+1;i<n;i++) //TC: O(n-x)
        {
            if(a[i]!=0){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int a[]={1,0,2,3,4,0,0,8,0};
        move(a);
    }
}