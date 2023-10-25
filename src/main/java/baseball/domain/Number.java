package baseball.domain;

public class Number {

  private static final int MAX_NUMBER = 9;
  private static final int MIN_NUMBER = 1;
  private static final int NUMBER_OF_DIGITS = 3;
  private static final int ALL_STRIKE = 3;

  private int[] numbers;

  public Number() {
    this.numbers = new int[NUMBER_OF_DIGITS];
  }


}
