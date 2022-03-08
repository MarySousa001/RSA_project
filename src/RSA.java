import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public static int n;
    public static int p;
    public static int q;
    public static int dy;
    public static int d = 0;
    public static int phi;
    public static int e;
    public static BigInteger bigN;



    public static int randN(int min, int max) {
        int newNumber = 0;
        boolean a = false;
        Random random = new Random();
        while (!a) {
            int number = min + random.nextInt(max);
            if (prim(number)) {
                newNumber = number;
                a = true;
            }
        }
        return newNumber;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int keyGenerator() {
        p = randN(3, 99);
        System.out.println("P - " + p);
        int pq = randN(3, 99);
        while (p == pq) {
            pq = randN(3, 99);
        }
        q = pq;
        System.out.println(("Q -" + q));
        n = p * q;
        bigN = BigInteger.valueOf(n);
        System.out.println("N - " + n);
        phi = (p - 1) * (q - 1);
        System.out.println("Phi - " + phi);
        e = randN(3, phi/3);
        dy = gcd(phi, e);
        while (dy != 1) {
            e = randN(3, phi);
            dy = gcd(phi, e);
            if (dy == 1) {
                break;
            }
        }
        System.out.println("Dy - " + dy);
        System.out.println("E " + e);

        // create d
        int k =1;
        double al;
        int ei = e;
        while(ei != 0) {
            al = (double) (1 + phi*k) / e;
                if(!isInteger(al)){
                    k++;
                    --ei;
                }
            else{
                d = (int) al;
                break;
            }
        }

//        d = modInverse(e, phi);
//        if (d < 0) d = phi + d;
        System.out.println("D " + d);
        return d;
    }
//
//    public static int modInverse(int a, int m) {
//        for (int x = 1; x < m; x++)
//            if (((a % m) * (x % m)) % m == 1)
//                return x;
//        return 1;
//    }

    public static boolean prim(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isInteger(double N){
        int X = (int) N;
        double temp2 = N - X;
        if(temp2 > 0){
            return false;
        }
        return true;
    }

    public static void encrypt(int message) {
        BigInteger ai = BigInteger.valueOf(message);
        BigInteger complete = ai.pow(e);
//        int Exp = e;
//        long la = 1;
//        while (Exp != 0){
//            la *= message;
//            -- Exp;
//        }
//        long ca = la % n;
        BigInteger ca = complete.mod(bigN);
        System.out.println("C " + ca);

    }

    public static void decrypt(int mess) {
        BigInteger ai = BigInteger.valueOf(mess);
        BigInteger complete = ai.pow(d);
//        int Exp = d;
//        long ai = 1;
//        while (Exp !=0){
//            ai *= mess;
//            --Exp;
//        }
        BigInteger ma = complete.mod(bigN);
        System.out.println("M " + ma);
    }


}
