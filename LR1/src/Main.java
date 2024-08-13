import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        int m, n;
        double x, y;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input n >>> ");
        n = getInt(scanner);
        System.out.print("Input m >>> ");
        m = getInt(scanner);
        System.out.print("Input x coordinate of the point >>> ");
        x = getDouble(scanner);
        System.out.print("Input y coordinate of the point >>> ");
        y = getDouble(scanner);
        scanner.close();
        showResults(m, n, x, y);
    }

    private static int getInt(Scanner scanner){
        boolean isCorrect = false;
        int getNumber = 0;
        do {
            try {
                getNumber = scanner.nextInt();
                isCorrect = true;
            } catch (InputMismatchException e) {
                System.out.printf("An error in input number. It should be an integer number in [%d; %d] >>> ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        } while (!isCorrect);
        return getNumber;
    }

    private static double getDouble(Scanner scanner){
        boolean isCorrect = false;
        double getNumber = 0.;
        do {
            try {
                getNumber = scanner.nextDouble();
                isCorrect = true;
            } catch (InputMismatchException e){
                System.out.printf("An error in input number. It should be an integer number in [%e; %e] >>> ", Double.MIN_VALUE, Double.MAX_VALUE);
            }
        } while (!isCorrect);
        return getNumber;
    }

    private static void showResults(int m, int n, double x, double y){
        System.out.println("\nPart 1 answers:");
        try {
            System.out.printf("Expression 1: m / --n = %d\n", m / --n);
            System.out.printf("Expression 2: m/n < n-- = %s\n", m/n < n--);
        }
        catch (ArithmeticException e){
            n--;
            System.out.print("Expression 1 cannot be done because n is zero!\n");
            System.out.print("Expression 2 cannot be done because n is zero!\n");
        }
        System.out.printf("Expression 3: m + n++ > n + m = %s\n", m + n++ > n + m);
        System.out.printf("Variables after this part: n = %d, m = %d\n", n, m);
        System.out.printf("Expression 4: Result = %.5f\n", fourExpression(x));

        System.out.println("\nPart 2 answer:");
        System.out.printf("The point (%f, %f) belonging to area is %s\n", x, y, pointBelongs(x, y));

        System.out.println("\nPart 3 answers:");
        System.out.printf("In double type: %f\n", doubleExpression());
        System.out.printf("In float type: %f", floatExpression());
    }

    private static double fourExpression(double x){
        return Math.pow(x, 5) * Math.sqrt(Math.abs(x - 1.)) + Math.abs(25. - Math.pow(x, 5));
    }

    private static boolean pointBelongs(double x, double y){
        return x <= 0 && y <= 0 && y >= -1./7. * x - 1.;
    }

    private static double doubleExpression(){
        final int a = 1000;
        final double b = 0.0001;

        return (Math.pow(a + b, 3) - (Math.pow(a, 3) + 3 * Math.pow(a, 2) * b))
                / (3 * a * Math.pow(b, 2) + Math.pow(b, 3));
    }

    private static double floatExpression(){
        final int a = 1000;
        final float b = 0.0001f;

        return ((float)Math.pow(a + b, 3) - ((float)Math.pow(a, 3) + 3 * (float)Math.pow(a, 2) * b))
                / (3 * a * (float)Math.pow(b, 2) + (float)Math.pow(b, 3));
    }
}