package clase3;


import java.util.Scanner;

public class Practico3Ejercicio3 {

    public static void main(String args[]){

        int num1, num2, num3;

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese primer número");
        num1 = input.nextInt();
        System.out.println("Ingrese segundo número");
        num2 = input.nextInt();
        num3 = mult(num1,num2);
        System.out.println("Multiplicacion es: ");
        System.out.println(num3);
    }



    public static int mult(int n1, int n2){

        return n1*n2;
        }

}
