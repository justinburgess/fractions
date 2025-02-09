public class Fraction {
    private long numerator;
    private long denominator;

    public Fraction(String fraction) {
        String regexPattern = "/";
        long numerator = Integer.parseInt(fraction.split(regexPattern)[0]);
        long denominator = Integer.parseInt(fraction.split(regexPattern)[1]);
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public long getNumerator() {
        return this.numerator;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
    }

    public long getDenominator() {
        return this.denominator;
    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    public String getFraction() {
        return getFraction(this.numerator, this.denominator);
    }

    public String getFraction(long numerator, long denominator) {
        String strNumerator = String.valueOf(numerator);
        String strDenominator = String.valueOf(denominator);
        return strNumerator.concat("/").concat(strDenominator);
    }

    public void setFraction(String fraction) {
        Fraction newFraction = new Fraction(fraction);
        this.setNumerator(newFraction.getNumerator());
        this.setDenominator(newFraction.getDenominator());
    }

    public void setFraction(Fraction fraction) {
        this.setFraction(fraction.getFraction());
    }

    public long getGreatestCommonFactor() {
        return getGreatestCommonFactor(this.getNumerator(), this.getDenominator());
    }

    private long getGreatestCommonFactor(long currentFactor1, long currentFactor2) {
        while (currentFactor2 != 0) {
            long previousFactor1 = currentFactor1;
            currentFactor1 = currentFactor2;
            currentFactor2 = previousFactor1 % currentFactor2;
        }
        return currentFactor1;
    }

    public long getGreatestCommonFactor(Fraction fraction) {
        long thisFractionGcf = this.getGreatestCommonFactor();
        long otherFractionGcf = fraction.getGreatestCommonFactor();
        return getGreatestCommonFactor(thisFractionGcf, otherFractionGcf);
    }

    public long getCommonDenominator(Fraction fraction) {
        long max = Math.max(this.getDenominator(), fraction.getDenominator());
        long min = Math.min(this.getDenominator(), fraction.getDenominator());
        if ( max % min == 0 ) return max;
        return this.getDenominator() * fraction.getDenominator();
    }

    public void simplifyFraction() {
        long greatestCommonFactor = this.getGreatestCommonFactor();
        simplifyFraction(greatestCommonFactor);
    }

    public void simplifyFraction(long greatestCommonFactor ) {
//        if ( greatestCommonFactor == 0 ) throw new IllegalArgumentException( "Cannot divide by zero." );
//        if ( this.getNumerator() == 0 ) return new Fraction( this.getFraction() );
        this.setNumerator(this.getNumerator()/greatestCommonFactor);
        this.setDenominator(this.getDenominator()/greatestCommonFactor);
    }

    private void simplifyFraction(Fraction fraction) {
        long greatestCommonFactor = this.getGreatestCommonFactor(fraction);
        this.simplifyFraction(greatestCommonFactor);
        fraction.simplifyFraction(greatestCommonFactor);
    }

    public void setLeastCommonDenominator(long commonDenominator) {
        long commonDenominatorMultiplier = commonDenominator / this.getDenominator();
        this.setNumerator( this.getNumerator() * commonDenominatorMultiplier );
        this.setDenominator( commonDenominator );
    }

    public void setLeastCommonDenominator(Fraction fraction) {
        long commonDenominator = this.getCommonDenominator( fraction );
        this.setLeastCommonDenominator( commonDenominator );
        fraction.setLeastCommonDenominator( commonDenominator );
        this.simplifyFraction(fraction);
    }

    public void add(Fraction fraction) {
        this.setLeastCommonDenominator(fraction);
        long sumOfNumerators = this.getNumerator() + fraction.getNumerator();
        this.setNumerator(sumOfNumerators);
    }

    public void subtract(Fraction fraction) {
        this.setLeastCommonDenominator(fraction);
        long differenceNumerator = this.getNumerator() - fraction.getNumerator();
        this.setNumerator(differenceNumerator);
    }

    public void multiplyBy(Fraction fraction) {
        this.setNumerator(this.getNumerator() * fraction.getNumerator());
        this.setDenominator(this.getDenominator() * fraction.getDenominator());
    }

    public void divideBy(Fraction fraction) {
        if ( fraction.numerator == 0 ) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        long previousNumerator = fraction.getNumerator();
        fraction.setNumerator(fraction.getDenominator());
        fraction.setDenominator(previousNumerator);
        this.multiplyBy(fraction);
    }
}
