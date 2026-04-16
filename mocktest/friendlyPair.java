

public class friendlyPair {

    static int sum(int n){
        int s=0;
        for(int i=1;i<=n;i++) if(n%i==0) s+=i;
        return s;
    }

    public static void main(String[] args) {
        int a=6,b=28;

        if((double)sum(a)/a == (double)sum(b)/b)
            System.out.println("Friendly Pair");
        else
            System.out.println("Not Friendly Pair");
    }
}