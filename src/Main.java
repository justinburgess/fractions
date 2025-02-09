public class Main {

    public static void main(String[] args) {
        String operation = getOperation(args[1]);
        // create fractions
        Fraction fraction1 = new Fraction(args[0]);
        Fraction fraction2 = new Fraction(args[2]);

        // run arguments against the fractions
        String result = runOperation(fraction1, fraction2, operation);

        // output the result
        System.out.println(result);
    }

    private static String getOperation(String argument) {
        return switch (argument.toLowerCase()) {
            case "add", "+" -> "add";
            case "subtract", "minus", "-" -> "subtract";
            case "/", "\\", "u+00f7", "divide", "division" -> "divide";
            case "*", "x", "by", "multipliedby" -> "multiply";
            default -> throw new IllegalArgumentException("Invalid operation submitted: " + argument);
        };
    }

    private static String runOperation (Fraction fraction1, Fraction fraction2, String operator) {
        return switch (operator) {
            case "add":
                fraction1.add(fraction2);
                yield fraction1.getFraction();
            case "subtract":
                fraction1.subtract(fraction2);
                yield fraction1.getFraction();
            case "multiply":
                fraction1.multiplyBy(fraction2);
                yield fraction1.getFraction();
            case "divide":
                fraction1.divideBy(fraction2);
                yield fraction1.getFraction();
            default:
                throw new IllegalArgumentException("Invalid runtime operation: " + operator);
        };
    }
}