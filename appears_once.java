//FIND THE NUMBER THAT APPEARS ONCE, AND THE OTHERS TWICE

public class appears_once {
    public static int once(int a[]) {
        int xor=0;
        for(int i=0;i<a.length;i++) {
            xor=xor^a[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int a[]={1,1,2,2,3,3,4,4,5};
        System.out.println("Number that appears once: "+once(a));
    }
}
