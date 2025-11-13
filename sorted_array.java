/*  a[]={1,1,2,3,4,5} => true
    a[]={1,2,1,3,5} => false
*/

public class sorted_array {
    public boolean isSorted(int a[]){
        for(int i=1;i<a.length;i++){
            if(a[i]>=a[i-1]){}
            else
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        sorted_array ob=new sorted_array();
        int a[]={1,2,2,3,9,5};
        if(ob.isSorted(a))
            System.out.println("Array is Sorted");
        else
            System.out.println("Array is not sorted");
    }
}
