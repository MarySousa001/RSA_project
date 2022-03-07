import java.util.Random;

public class RSA {
    public static boolean flag = false;
    public static int n;
    public static int p;
    public static int q;
    public static int d;
    public static int phi;
    public static int e;
    public static int t;

    public static int randPQ(){
        int newNumber = 0;
        boolean a = false;
        Random random = new Random();
        int max = 999;
        int min = 99;
        while (!a) {
            int number = min + random.nextInt(max);
            if (prim(number)) {
                newNumber = number;
                a = true;
            }
        }
        return newNumber;
    }
    public static int randN(){
        int newNumber = 0;
        boolean a = false;
        Random random = new Random();
        int max = 99;
        int min = 1;
        while (!a) {
            int number = min + random.nextInt(max);
            if (prim(number)) {
                newNumber = number;
                a = true;
            }
        }
        return newNumber;
    }
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
    public static int keyGenerator(){
        p = randPQ();
        System.out.println("P - " + p);
        int pq = randPQ();
        while(p == pq){
            pq = randPQ();
        }
        q = pq;
        System.out.println(("Q -" + q));
        n = p * q;
        System.out.println("N - " + n);
        phi= (p-1) * (q-1);
        System.out.println("Phi - "+ phi);
        d = gcd(p-1, q-1);
        System.out.println("D - "+d);
        e = randN();
        System.out.println("E " + e);
        System.out.println("("+ e + "," + n + ")");
        return d;
    }

    public static boolean prim(int num){
        for(int i = 2; i<num ; i++){
            if (num % i == 0){
                return false;
            }
        }return true;
    }
    public static void encrypt(){

    }
    public static void decrypt(){

    }

}
