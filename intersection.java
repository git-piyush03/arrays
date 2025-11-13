//INTERSECTION OF TWO SORTED ARRAYS

//Remember: repitition is allowed, i.e, look for corresponding elements in both the arrays
/*
 BRUTE FORCE APPROACH:
    -> create a visited array to check for taken elements
    -> run through any one of the arrays, if a[i]==b[j] and it is not visited, then add it to the list
    -> also check if b[j]>a[i] this means greater element found so a[i] does not exist since it is a sorted array
    -> TC: O(n1*n2)
    -> SC: O(n2)
 */
import java.util.*;
/*
public class intersection {
    public static void intersect(int a[],int b[]) {
        int n1=a.length;
        int n2=b.length;
        int visited[]=new int[n2];
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(a[i]==b[j] && visited[j]==0){
                    arr.add(a[i]);
                    visited[j]=1;
                    break;
                }
                if(b[j]>a[i])
                    break;
            }
        }
        System.out.println(arr);
    }
    public static void main(String[] args) {
        int a[]={1,2,2,3,3,4,5,6};
        int b[]={2,3,3,6,6};
        intersect(a,b);
    }
}

/*
 OPTIMAL APPROACH:
    -> use two pointer appraoch
    -> if a[i]<b[j] then i++, it means if either of the elements are greater, it's corresponding does not exist
    -> similarly, b[j]<a[i] then j++
    -> if equal..add into the array list
    -> TC: O(n1+n2)
    -> SC: O(1)
 */
public class intersection{
    public static void intersect(int a[],int b[]){
        int n1=a.length;
        int n2=b.length;
        int i=0,j=0;
        ArrayList<Integer> arr=new ArrayList<>();
        while(i<n1 && j<n2){
            if(a[i]==b[j]){
                arr.add(a[i]);
                i++;
                j++;
            }
            else if (a[i]<b[j])
                i++;
            else
                j++;
        }
        System.out.println(arr);
    }
    public static void main(String[] args) {
        int a[]={1,2,2,3,3,4,5,6};
        int b[]={2,3,3,6,6};
        intersect(a,b);
    }
}