package baseball.domain.ball;

public record BallNumber(
    int number
) {

  public BallNumber {
    if (number < 1 || number > 9) {
      throw new IllegalArgumentException("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
    }
  }

}
