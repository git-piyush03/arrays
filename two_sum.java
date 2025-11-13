// 2 SUM PROBLEM IN AN ARRAY: CHECK IF A+B == TARGET, ALSO PRINT THE INDEXES 

//BRUTE FORCE APPROACH: O(n^2)
/*
import java.util.Arrays;
public class two_sum {
    public static int[] twoSum(int a[],int target) {
        int n=a.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++){
              //  if(i==j)
              //      continue; // remove this if line if using j=i+1 
                if(a[i]+a[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int a[]={2,6,5,8,11};
        System.out.println(Arrays.toString(twoSum(a,14)));
    }
}
*/

/*
BETTER APPROACH: USING HASH MAP(key: element, index)
    -> take an element and look for target-a[i] in the hash map
    -> if the target - a[i] exists in the map return the index of both the elements
    -> TC: O(n), worst case O(n^2) due to the use of unordered map
    -> TC can be reduced to O(nlogn) by using ordered map
    -> SC: O(n)
 */
/*
import java.util.HashMap;
import java.util.Arrays;
public class two_sum {
    public static int[] twoSum(int a[], int target) {
        int n=a.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            int more=target-a[i];
            if(map.containsKey(more)){
                return new int[] {map.get(more),i};
            }
            map.put(a[i],i);
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int a[]={2,6,5,8,11};
        System.out.println(Arrays.toString(twoSum(a,14)));
    }
}

*/
/*
OPTIMAL APPROACH: TWO POINTER
    -> sort the array elements
    -> take left and right values, if sum<target then left should be increased
    -> if sum>target, right-- it is decreased
    -> TC: O(n)+O(nlogn)
    -> SC: O(1)
 */
import java.util.Arrays;
public class two_sum {
    public static String twoSum(int a[], int target) {
        int n=a.length;
        Arrays.sort(a);
        int left=0,right=n-1;
        while(left < right) {
            int sum=a[left]+a[right];
            if(sum==target)
                return "YES";
            else if(sum<target)
                left++;
            else
                right--;
        }
        return "NO";
    }
    public static void main(String[] args) {
        int a[]={2,6,5,8,11};
        System.out.println(twoSum(a,14));
    }
}