/*
    The brute force method of solving this is:
        -> search for the largest in first pass
        -> in the second pass, return the element which is !=largest and a[i]>slargest
        -> TC : O(2N)

    The optimal approach is done below: O(N)
 */
public class second_largest
{
    public int secondLargest(int a[]) {
        int largest=a[0];
        int slargest=-1; //given array has atleast 2 no.s and non-negative integers
        for(int i=0;i<a.length;i++) //single pass: O(N)
        {
            if(a[i]>largest){
                slargest=largest;
                largest=a[i];
            }
            else if(a[i]<largest && a[i]>slargest)
                slargest=a[i];
        }
        return slargest;
    }
    public int secondSmallest(int a[]) {
         int smallest=a[0];
         int ssmallest=Integer.MAX_VALUE;
         for (int i=0;i<a.length;i++) {
            if(a[i]<smallest){
                ssmallest=smallest;
                smallest=a[i];
            }
            else if(a[i]!=smallest && a[i]<ssmallest)
                ssmallest=a[i];
        }
        return ssmallest;
    }
    public static void main(String[] args) {
        second_largest ob=new second_largest();
        int a[]={2,3,1,0,5};
        System.out.println("Second Largest: "+ob.secondLargest(a));
        System.out.println("Second Smallest: "+ob.secondSmallest(a));
    }
}