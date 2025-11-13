//MAJORITY ELEMENT (> N/2 TIMES)

/*
BRUTE FORCE APPROACH:
    -> Checking for each element in the entire array
    -> TC: O(n^2)
    -> SC: O(1)
 */
/*
public class majority_element {
    public static int majority(int a[]) {
        int n=a.length;
        int count;
        for(int i=0;i<n;i++) {
            count=0;
            for(int j=0;j<n;j++) {
                if(a[j]==a[i]) {
                    count++;
                }
            }
            if(count > n/2)
                return a[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[]={2,2,3,3,1,2,2};
        System.out.println("Majority element: "+majority(a));
    }
}
*/
/*
BETTER APPROACH: USE HASH MAPS
    -> assign the element as key and index as value
    -> update the value which thereby increases the count
    -> display the key with maximum count
    -> TC: O(nlogn) + O(n)
    -> SC: O(n) => on;y happens when all unique elements
 */
/*
import java.util.HashMap;
public class majority_element {
    public static int majority(int a[]) {
        int n=a.length;
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
            if(map.get(a[i])>n/2)
                return a[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[]={2,3,3,3,1,2,3};
        System.out.println("Majority element: "+majority(a));
    }
}
*/
/*
OPTIMAL APPROACH: MOORE'S VOTING ALGORITHM
    -> start with if count==0 then take an element, reinitialize the count to 1
    -> check if a[i]==element then count++
    -> else we subtract the count which indicates the element cancels out
    -> then again repeat when count becomes 0 after cancelling out 
    -> verify for element u got is majority or not (this step can be skipped if the qn states that there is a majority el for sure)
    -> TC: O(n)+O(n)
    -> SC: O(1)
 */
public class majority_element {
    public static int majority(int a[]) {
        int count=0, n=a.length;
        int el=0;
        for(int i=0;i<n;i++) {
            if(count==0){
                el=a[i];
                count=1;
            }
            else if(a[i]==el)
                count++;
            else 
                count--;
        }
        //run this loop if array has not stated that there is atleast one majority element
        int c=0;
        for(int i=0;i<n;i++){
            if(a[i]==el)
                c++;
        }
        if(c>n/2)
            return el;
        return -1;
    }
    public static void main(String[] args) {
    int a[]={2,3,3,3,1,2,3};
    System.out.println("Majority element: "+majority(a));
    }
}
