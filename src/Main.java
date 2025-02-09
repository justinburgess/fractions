
public class Main {
    public static void main(String[] args) {
        EgyptianFraction fraction1 = new EgyptianFraction(args[0]);
        EgyptianFraction fraction2 = new EgyptianFraction(args[1]);
        System.out.println("Fraction 1 decomposition is: " + fraction1.getDecomposition());
        System.out.println("Fraction 1 decomposition is valid: " + fraction1.isValidDecomposition());
        System.out.println("Fraction 2 decomposition is: " + fraction2.getDecomposition());
        System.out.println("Fraction 2 decomposition is valid: " + fraction2.isValidDecomposition());
    }
}