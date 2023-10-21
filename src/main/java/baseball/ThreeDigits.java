package baseball;

public class ThreeDigits {
    private char first;
    private char second;
    private char third;
    
    public ThreeDigits(final char first,final char second,final char third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public char getFirst() {
        return first;
    }
    public char getSecond() {
        return second;
    }
    public char getThird() {
        return third;
    }

    public static ThreeDigits toThreeDigits(final String input) {
        return new ThreeDigits(
            input.charAt(0), 
            input.charAt(1), 
            input.charAt(2)
        );
    }

    public static ThreeDigits generateAnswerThreeDigits(
        final int first, 
        final int second,
        final int third
    ){
        int radix = 10;
        return new ThreeDigits(
            Character.forDigit(first,radix),
            Character.forDigit(second,radix),
            Character.forDigit(third,radix)
        );
    }
}
