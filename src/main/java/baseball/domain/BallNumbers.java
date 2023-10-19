package baseball.domain;

import java.util.List;
import java.util.Objects;

public final class BallNumbers {

  private final List<Integer> numbers;

  private BallNumbers(final List<Integer> numbers) {
    this.numbers = numbers;
  }

  public static BallNumbers of(final List<Integer> numbers) {
    validateNumbers(numbers);
    return new BallNumbers(numbers);
  }

  private static void validateNumbers(final List<Integer> numbers) {
    for (final Integer number : numbers) {
      if (number < 1 || number > 9) {
        throw new IllegalArgumentException("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
      }
    }
  }

  public boolean comparesAt(
      final int index,
      final BallNumbers other
  ) {
    return Objects.equals(numbers.get(index), other.numbers.get(index));
  }

  public boolean containsAt(
      final int index,
      final BallNumbers other
  ) {
    return numbers
        .stream()
        .anyMatch(other.numbers::contains);
  }
}
