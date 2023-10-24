package baseball;

import static baseball.Type.*;

import java.util.ArrayList;
import java.util.Map;

//TODO: java17의 record 적용해보기
class Baseball {

  // 야구공 타입 - 스트라이크, 볼
  private Type type;

  // 야구공 숫자
  private final int number;

  // 야구공의 위치
  private final int index;

  public Baseball(int number, int index) {
    this.number = number;
    this.index = index;
  }

  public void changeType(Type type) {
    this.type = type;
  }

  public Type getType() {
    return this.type;
  }

  public int getNumber() {
    return this.number;
  }

  public int getIndex() {
    return this.index;
  }

  public void checkType(ArrayList<String> randomList) {
    String baseballNumber = getNumberToString();
    if(randomList.contains(baseballNumber)) {
      changeType((randomList.indexOf(baseballNumber) == getIndex() ? STRIKE : BALL));
    }
  }

  private String getNumberToString() {
    return String.valueOf(getNumber());
  }

  public void calculate(Map<String, Integer> scoreBoard) {
    if(getType() == null) {
      return;
    }
    String myType = type.getType();
    scoreBoard.put(myType, scoreBoard.get(myType)+1);
  }
}
