public class Main {

    public static void main(String[] args) {
                System.out.println( add(2, 3));
                System.out.println( add(-5, 5));
                System.out.println(isEvenLength("Dog"));
                System.out.println(isEvenLength("rock"));
                System.out.println( findMinimum(1, 0, 9));
                System.out.println( log5(25.0));
                System.out.println( log5(10.0));
    }

    public static int add(int a, int b){
        return a+b;
    }
    public static int findMinimum(int a, int b, int c){
        int result = 0;
        return result;
    }
    public static boolean isEvenLength(String s){
        return (s.length() % 2 == 0);
    }
    public static double log5(double x){
        double result = 0;
        result = Math.log(x) / Math.log(5.0);
        return result;
    }
}
