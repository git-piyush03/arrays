//LEADERS IN AN ARRAY: leader-> everything in the right should be smaller (can be multiple)
import java.util.ArrayList;
public class leaders_array {
    public static ArrayList<Integer> leaders(int a[]){
        int n=a.length;
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(a[i]>max){
                list.add(a[i]);
            }
            max=Math.max(max,a[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        int a[]={10,22,12,3,0,6};
        System.out.println(leaders(a));
    }
}
