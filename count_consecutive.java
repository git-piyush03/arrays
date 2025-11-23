//aaabbbbccdddde -> a3b4c2d4e

public class count_consecutive {
    public static String count(String s){
        String ans= "" +s.charAt(0);
        int count=1;
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
            char prev=s.charAt(i-1);
            if(curr==prev){
                count++;
            }
            else{
                if(count >1)
                    ans+=count;
                ans+=curr;
                count=1;
            }
        }
        if(count > 1)
            ans+=count;
        return ans;
    }
    public static void main(String[] args) {
        String str="aaabbcccaaddde";
        System.out.println(count(str));
    }
}
