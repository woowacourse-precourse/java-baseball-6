package baseball;

public class Output {

  public static void getHint(int ball, int strike) {
    StringBuilder sb = new StringBuilder();

    if (ball == 0 && strike == 0) {
      sb.append("낫싱");
    }
    if (ball != 0) {
      sb.append(ball + "볼 ");
    }
    if (strike != 0) {
      sb.append(strike + "스트라이크");
    }

    System.out.println(sb);
  }

  public static void endMessage(){
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }

}
