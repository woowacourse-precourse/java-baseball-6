package baseball;

class Baseball {

  // 야구공 타입 - None, 스트라이크, 볼
  Type type;

  // 야구공 숫자
  int number;

  // 야구공의 위치
  int index;

  public Baseball(Type type, int number, int index) {
    this.type = type;
    this.number = number;
    this.index = index;
  }

  public void changeType(Type type) {
    this.type = type;
  }
}
