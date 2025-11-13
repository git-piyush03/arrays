//MAXIMUM CONSECUTIVE ONES PRESENT IN AN ARRAY

public class maximum_consec_ones {
    public static int max_ones(int a[]){
        int max=0, count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==1){
                count++;
                max=Math.max(max,count);
            }
            else {
                count=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]={1,1,0,0,0,1,1,1,1};
        System.out.println("Count of max consecutive ones: "+max_ones(a));
    }
}
