//UNION OF TWO SORTED ARRAYS

import java.util.*;
/*
 BRUTE FORCE APPROACH:
    -> create an ordered set and add both the array elements into it
    -> create an array and add elements from the set
    -> TC: O(n1logn) + O(n2logn) + O(n1+n2)(worst case if all are unique)
    -> SC: O(n1+n2) for solving the problem + O(n1+n2) to return the answer
 */
/* 
public class union {
    public static void union_array(int a[],int b[]){
        Set<Integer> s=new LinkedHashSet<>();
        
        for(int i=0;i<a.length;i++)
            s.add(a[i]);

        for(int i=0;i<b.length;i++)
            s.add(b[i]);

        int u[]=new int[s.size()];

        int index=0;
        for(int i:s){
            u[index]=i;
            index++;
        }
        System.out.println(Arrays.toString(u));
    }
    public static void main(String[] args) {
        int a[]={1,1,2,3,4,5};
        int b[]={2,3,5,5,6,6,7};
        union_array(a, b);
    }
}

/*
 OPTIMAL APPROACH: 
    -> use an array list to return the union array
    -> two pointer approch, the elements that is smaller and not included will be taken into the list
    -> i=0,j=0 => if a[i] <= b[j] => and then if list does not have that element then insert
    -> TC: O(n1+n2) in worst case if all elements are unique
    -> SC: for "returning answer" it is O(n1+n2), for solving O(1)
 */
public class union{
    public static void union_sorted(int a[], int b[]){
        ArrayList<Integer> u=new ArrayList<>();
        int i=0,j=0;
        int n1=a.length;
        int n2=b.length;
        while(i<n1 && j<n2){
            if(a[i] <= b[j]){
                if(u.isEmpty() || !u.contains(a[i]))
                    u.add(a[i]);
                i++;
            }
            else {
                if(u.isEmpty() || !u.contains(b[j]))
                    u.add(b[j]);
                j++;
            }
        }
        while(j<n2){
            if(u.isEmpty() || !u.contains(b[j]))
                u.add(b[j]);
            j++;
        }
        while(i<n1){
            if(u.isEmpty() || !u.contains(a[i]))
                u.add(a[i]);
            i++;
        }
        System.out.println(u);
    }
    public static void main(String[] args) {
        int a[]={1,1,2,3,4,5};
        int b[]={2,3,5,5,6,6,7};
        union_sorted(a, b);
    }
}