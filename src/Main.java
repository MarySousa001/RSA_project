import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean cont = true;
        while (cont){
            int num;
            int numa;
            Scanner aca = new Scanner(System.in);
            RSA.keyGenerator();
            System.out.println("Insert the message");
            num = aca.nextInt();
            RSA.encrypt(num);
            System.out.println("Insert the d");
            numa = aca.nextInt();
            RSA.decrypt(numa);
            cont = false;
        }


    }
}
