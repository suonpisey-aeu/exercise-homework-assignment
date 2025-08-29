import java.util.Scanner;

public class NumberChecker {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;
        
        // Keep asking for input until we get a valid integer
        while (!validInput) {
            try {
                System.out.print("Enter an integer: ");
                number = scanner.nextInt();
                validInput = true; // If we reach here, input was valid
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer (whole number only).");
                scanner.nextLine(); // Clear the invalid input from scanner buffer
            }
        }
        
        System.out.println("\nResults for " + number + ":");
        
        // Check if the number is prime
        if (isPrime(number)) {
            System.out.println("✓ " + number + " is a prime number");
        } else {
            System.out.println("✗ " + number + " is not a prime number");
        }
        
        // Check if the number is even
        if (isEven(number)) {
            System.out.println("✓ " + number + " is an even number");
        } else {
            System.out.println("✓ " + number + " is an odd number");
        }
        
        // Check if the number is divisible by 5
        if (isDivisibleBy5(number)) {
            System.out.println("✓ " + number + " is divisible by 5");
        } else {
            System.out.println("✗ " + number + " is not divisible by 5");
        }
        
        scanner.close();
    }
    
    /**
     * Checks if a number is prime
     * @param num the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int num) {
        // Handle special cases
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        
        // Check for divisors from 5 to sqrt(num)
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Checks if a number is even
     * @param num the number to check
     * @return true if the number is even, false otherwise
     */
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    /**
     * Checks if a number is divisible by 5
     * @param num the number to check
     * @return true if the number is divisible by 5, false otherwise
     */
    public static boolean isDivisibleBy5(int num) {
        return num % 5 == 0;
    }
}

/** end, now I can use github*/