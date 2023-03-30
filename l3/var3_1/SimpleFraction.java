package l3.var3_1;

public class SimpleFraction {
    private int numerator;
    private int denominator;

    public SimpleFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void ConsoleOutput() {
        System.out.println(this);
    }

    public SimpleFraction Sum(SimpleFraction other) {
        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new SimpleFraction(newNumerator, newDenominator);
    }

    public SimpleFraction Substract(SimpleFraction other) {
        int newNumerator = numerator * other.denominator - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new SimpleFraction(newNumerator, newDenominator);
    }

    public SimpleFraction Multiply(SimpleFraction other) {
        int newNumerator = numerator * other.numerator;
        int newDenominator = denominator * other.denominator;
        return new SimpleFraction(newNumerator, newDenominator);
    }

    public SimpleFraction Divide(SimpleFraction other) {
        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;
        return new SimpleFraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numerator;
        result = prime * result + denominator;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpleFraction other = (SimpleFraction) obj;
        if (numerator != other.numerator)
            return false;
        if (denominator != other.denominator)
            return false;
        return true;
    }
}