import java.util.ArrayList;
import java.util.List;

public class EgyptianFraction extends Fraction{
    private final List<String> decomposition;

    public EgyptianFraction(String fraction) {
        super(fraction);
        decomposition = this.decompose();
    }

    public EgyptianFraction(long numerator, long denominator) {
        super(numerator, denominator);
        decomposition = this.decompose();
    }

    public List<String> getDecomposition() {
        return decomposition;
    }

    public List<String> decompose() {
    /*
        The formula to finding each fraction uses the iterative formula:
        remainingFraction >= 1 / next denominator

        The formula is solved using standard algebra. Example:
            1/2 >= 1/x --> x >= 2

        This example would choose 2 as the next denominator
        because whole numbers will only be derived
        if the remaining fraction itself has 1 in the numerator,
        making it the final egyptian fraction.

        Otherwise, the next value higher (floorQuotient + 1) is selected
        because the next denominator cannot be less than the solve for x.
      */

        List<String> egyptianFractions = new ArrayList<>();

        // Get whole number and add to egyptianFractions
        long leadingNumber = this.getNumerator() / this.getDenominator();
        if (leadingNumber >= 1) egyptianFractions.add(String.valueOf(leadingNumber));

        long currentNumerator = this.getNumerator() % this.getDenominator();
        long currentDenominator = this.getDenominator();
        Fraction currentFraction = new Fraction(currentNumerator, currentDenominator);

        while (currentFraction.getNumerator() != 0) {
            long floorQuotient = Math.floorDiv(currentFraction.getDenominator(), currentFraction.getNumerator());
            if (currentFraction.getDenominator() % currentFraction.getNumerator() == 0) {
                egyptianFractions.add("1/" + floorQuotient);
                currentFraction.setNumerator(0);
            } else {
                egyptianFractions.add("1/" + (floorQuotient + 1));
                Fraction lastEgyptianFraction = new Fraction(egyptianFractions.get(egyptianFractions.size() - 1));
                currentFraction.subtract(lastEgyptianFraction);
                currentFraction.simplifyFraction();
            }
        }
        return egyptianFractions;
    }

    public boolean isValidDecomposition() {
        Fraction primaryFraction = new Fraction( this.getFraction() );

        Fraction sumOfFractions = new Fraction("0/1");
        for ( int i = 0; i < this.decomposition.size(); i++ ) {
            Fraction nextFraction = new Fraction( this.getDecomposition().get(i) );
            sumOfFractions.add( nextFraction );
        }

        sumOfFractions.simplifyFraction();
        primaryFraction.simplifyFraction();
        System.out.println("The sum of fractions is: " + sumOfFractions.getFraction());
        System.out.println("The primary fraction is: " + primaryFraction.getFraction());
        return primaryFraction.getFraction().equals(sumOfFractions.getFraction());
    }

    public boolean isValidDecomposition( EgyptianFraction decomposedFraction ) {
        List<String> fractionList = decomposedFraction.getDecomposition();
        Fraction sumOfFractions = new Fraction( "0/1" );
        for ( int i = 0; i < fractionList.size(); i++ ) {
            Fraction fraction = new Fraction(fractionList.get(i));
            sumOfFractions.add(fraction);
        }
        sumOfFractions.simplifyFraction();
        decomposedFraction.simplifyFraction();
        return decomposedFraction.getFraction().equals( sumOfFractions.getFraction() );
    }
}
