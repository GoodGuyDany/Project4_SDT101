// #1 implementation
public class Main {
    // Example for loop from #1.1
    public static int sum1toN(int n) { // You may assume n ≥ 1
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += i;
        }
        return sum;
    }
    // Recursive version of sum1toN, #1.1
    public static int sum1toNRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum1toNRecursive(n - 1);
        }
    }
    // Recursive power method, #1.2
    public static double power(double x, int n) {
        if (n == 0) { // Base case 
            return 1;
        } else if (n % 2 == 0) {
            double y = power(x, n/2); // Optimizing the method, significantly improving performance (ex. 4^4 = 4^2 * 4^2)
            return y * y; // Returning the output value from the method if the n is even
        } else {
            return x * power(x, n-1); // Returning the value from the method if the n is odd
        }
    }
    // Main method
    public static void main(String[] args) {
        int sumRes = sum1toNRecursive(5); // Trying out the recursive #1.1 method
        System.out.println("The value of sumRes is: " + sumRes); // Printing out the result of sum1toNRecursive
        double powerRes = power(6.0,5); // Trying out the recursive #1.2 method
        System.out.println("The value of powerRes is: " + powerRes); // Printing out the result of power
    }
}