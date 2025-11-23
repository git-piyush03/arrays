/*
LONGEST CONSECUTIVE SEQUENCE PRESENT IN AN ARRAY:
    -> [102 4 100 1 101 3 2 1 1] : here the longest consecutive sequence is [1,2,3,4] therefore output 4(length)
*/
/*
BRUTE FORCE APPROACH:
    -> checks for x+1 element in the entire array for each element using linear search
    -> if found increase the count by 1 and after checking the entire array...update the longest value
    -> take max of count and longest
    -> TC: O(n^2)
    -> SC: O(1)
*/
/*
public class longest_consecutive_sequence {
    public static boolean linear(int a[],int x){
        for(int i=0;i<a.length;i++){
            if(a[i]==x)
                return true;
        }
        return false;
    }
    public static int longestSuccessive(int a[]){
        int n=a.length;
        int count=0;
        int longest=1;
        if(n==0) return 0;
        for(int i=0;i<n;i++){
            int x=a[i];
            count=1;
            while(linear(a,x+1)){
                count+=1;
                x+=1;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        System.out.println("The longest consecutive sequence is " + longestSuccessive(a));
    }

}
*/
/*BETTER APPROACH:
    -> First, we will sort the entire array.
    -> To begin, we will utilize a loop(say i) to iterate through each element one by one.
    -> For every element, we will check if this can be a part of the current sequence like the following:
            ->  If arr[i]-1 == lastSmaller: The last element in our sequence is labeled as 'lastSmaller' and the current element 'arr[i]' is exactly 'lastSmaller'+1.
                It indicates that 'arr[i]' is the next consecutive element. To incorporate it into the sequence, 
                we update 'lastSmaller' with the value of 'arr[i]' and increment the length of the current sequence, denoted as 'cnt', by 1.

            ->  If arr[i] == lastSmaller: If the current element, arr[i], matches the last element of the sequence,
                we can skip it since we have already included it before.
            
            -> Otherwise, if lastSmaller != arr[i]: On satisfying this condition, we can conclude that the current element, arr[i] > lastSmaller+1.
                It indicates that arr[i] cannot be a part of the current sequence. So, we will start a new sequence from arr[i] by updating ‘lastSmaller’ with the value of arr[i]. 
                And we will set the length of the current sequence(cnt) to 1.
Every time, inside the loop, we will compare ‘cnt’ and ‘longest’ and update ‘longest’ with the maximum value. longest = max(longest, cnt)
Finally, once the iteration is complete, we will have the answer stored in the variable ‘longest’. 

        -> TC: O(nlogn) for sorting + O(n)
        -> SC: O(1)
*/
/*
import java.util.Arrays;
public class longest_consecutive_sequence {
    public static int longest(int a[]){
        int n=a.length;
        if(n==0) return 0;
        Arrays.sort(a);
        int lastSmaller=Integer.MIN_VALUE;
        int longest=1;
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]-1 == lastSmaller){
                lastSmaller=a[i];
                count+=1;
            }
            else if(a[i] != lastSmaller){
                count=1;
                lastSmaller=a[i];
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        System.out.println("The longest consecutive sequence is " + longest(a));
    }
}
*/
/*
OPTIMAL APPROACH: USING A SET DATA STRUCTURE
    -> First, we will put all the array elements into the set data structure.
    -> If a number, num, is a starting number, ideally, num-1 should not exist. So, for every element, x, in the set, we will check if x-1 exists inside the set. :
    -> If x-1 exists: This means x cannot be a starting number and we will move on to the next element in the set.
    -> If x-1 does not exist: This means x is a starting number of a sequence. So, for number, x, we will start finding the consecutive elements.

How to search for consecutive elements for a number, x:

Instead of using linear search, we will use the set data structure itself to search for the elements x+1, x+2, x+3, and so on.

*/

import java.util.HashSet;
import java.util.Set;

public class longest_consecutive_sequence {
    public static int longest(int a[]){
        int n = a.length;
        if (n == 0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longest(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }

}