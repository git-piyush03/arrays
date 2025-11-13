//LEFT ROTATE BY ONE PLACE

//direct optimal approach
import java.util.Arrays;
public class left_rotate {
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        int n=a.length;
        int temp=a[0];
        for(int i=1;i<n;i++){
            a[i-1]=a[i];
        }
        a[n-1]=temp;
        System.out.println(Arrays.toString(a));
    }   
} 
