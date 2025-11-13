//remove duplicates in-place from sorted array

//brute-force
//TC: O(nlogn)+n
//SC: O(n)
/* 

import java.util.*;
public class remove_duplicates {
    public int removeDuplicates(int a[]){
        Set<Integer> s=new LinkedHashSet<>();
        for(int element:a){ //TC: O(nlogn)
            s.add(element);
        }
        int index=0;
        for(int i:s){ //TC: O(n)
            a[index++]=i;
        }
        return index;
    }
    public static void main(String[] args) {
        int a[]={1,1,2,2,3,3,3,4,5,8,8};
        remove_duplicates ob=new remove_duplicates();
        System.out.println("Length of the array: "+ob.removeDuplicates(a));
    }
}
    */

//optimal: using two pointer 
//TC: O(n)
//SC: O(1)

public class remove_duplicates {
    public int removeDuplicates(int a[]){
        int i=0;
        for(int j=1;j<a.length;j++){
            if(a[i]!=a[j]){
                a[i+1]=a[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int a[]={1,1,2,2,3};
        remove_duplicates ob=new remove_duplicates();
        System.out.println("Length of the array: "+ob.removeDuplicates(a));
    }
}
