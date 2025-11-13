//MISSING NUMBER IN AN ARRAY FROM 1 TO N 

/*
 BRUTE FORCE APPROACH:
    -> run a loop, 1 to n
    -> check each element of array with a single number using a nested loop
    -> keep the record of found elements using flag
    -> if flag remains zero after iterating through the array then print that number
    -> TC: O(N^2) HYPOTHETICAL since we have break statement for every element found
    -> SC: O(1)
 */
/*
public class missing_number {
    public static void missing(int a[]) {
        int n=a.length;
        int flag;
        for(int i=1;i<=n;i++){
            flag=0;
            for(int j=0;j<n-1;j++)
            {
                if(a[j]==i){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("Missing number: "+i);
                break;
            }
        }
    }
    public static void main(String[] args) {
        int a[]={1,2,3,3,5};
        missing(a);
    }
}

/*
 BETTER APPROACH:
    -> using HashMap, map the number as key and an integer to keep the record of visited numbers
    -> iterate and insert the 
*/
/*
import java.util.HashMap;
public class missing_number {
    public static void missing(int a[]) {
        int n=a.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:a){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int missing=-1;
        for(int i=1;i<=n;i++){
            if(map.getOrDefault(i,0)==0){
                missing=i;
                break;
            }
        }
        System.out.println("Missing Number: "+missing);
    }
    public static void main(String args[]){
        int a[]={1,2,4,5,6,7};
        missing(a);
    }
}
/*
OPTIMAL APPROACH 1:
    -> sum of n numbers - sum of the array with the missing number
    -> suppose if we have 10^5 then n(n+1) will exceed 10^10 thereby exceeding integer storage
    -> TC: O(array.length)
    -> SC: O(1)
OPTIMAL APPROACH 2:
    -> using xor, it does not cross 10^5
    -> a xor a = 0 and 0 xor a = a
    -> TC: O(n)
    -> SC: O(1)
 */
/* 
public class missing_number {
    public static int missing(int a[], int n) {
        int s=(n*(n+1))/2;
        int s1=0;
        for(int i=0;i<a.length;i++) {
            s1=s1+a[i];
        }
        return (s-s1);
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        System.out.println("Missing number: "+missing(a,6));
    }
}
*/
public class missing_number {
    public static int missing(int a[], int n){
        int xor1=0,xor2=0;
        for(int i=0;i<a.length;i++){
            xor2=xor2 ^ a[i];
            xor1=xor1 ^ (i+1);
        }
        xor1=xor1 ^ n;
        return xor1 ^ xor2;
    }
    public static void main(String[] args) {
        int a[]={1,2,4,5};
        System.out.println("Missing number: "+missing(a,5));
    }
}
