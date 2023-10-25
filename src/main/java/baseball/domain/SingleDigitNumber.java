package baseball.domain;

import java.util.Objects;  // 필요한 임포트를 추가합니다.

public class SingleDigitNumber {
  private final int value;

  public SingleDigitNumber(int value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SingleDigitNumber that = (SingleDigitNumber) o;
    return value == that.value;
  }


  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
