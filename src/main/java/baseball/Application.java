package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
  private static final int INPUT_SIZE = 3;
  public static void main(String[] args) {
    // TODO: 프로그램 구현

    System.out.println("숫자 야구 게임을 시작합니다.");
    playGame();
    System.out.println("게임 종료");
  }

  private static void playGame() {
    List<Integer> computer = createAnswer();//서로 다른 3자리 수 생성
    int strike = 0, ball, pos;
    int restart;

    while (strike != INPUT_SIZE) {
      ball = 0;
      strike = 0;
      pos = 0;

      System.out.printf("숫자를 입력해주세요 : ");
      String num = readLine();

      verifiedInput(num);

      for (int i = 0; i < INPUT_SIZE; i++) {
        int m = Character.getNumericValue(num.charAt(i));
        int index = computer.indexOf(m);

        if (index != pos && index != -1) {
          ball++;
        }
        if (index == pos) {
          strike++;
        }
        pos++;
      }

      getHint(ball, strike);//입력한 수에 대한 결과 출력
    }

    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    restart = Integer.parseInt(readLine());

    doRestart(restart);
  }

  private static void doRestart(int restart) {
    if (restart != 1 && restart != 2) {
      throw new IllegalArgumentException("1아니면 2를 입력 해야 합니다.");
    }
    if (restart == 1) {
      playGame();
    }
  }

  private static void verifiedInput(String num) {

    if (!num.chars().allMatch(Character::isDigit)) {//숫자인지 확인
      throw new IllegalArgumentException("숫자를 입력 해야 합니다.");
    }
    if (num.length() != INPUT_SIZE) {//3자리 수인지 확인
      throw new IllegalArgumentException("세자리 수를 입력 해야 합니다.");
    }
    for (int i = 0; i < INPUT_SIZE-1; i++) {//중복된 숫자로 이루어져 있는지 확인
      String s1 = num.substring(i, i + 1);
      String s2 = num.substring(i + 1);
      if (s2.contains(s1)) {
        throw new IllegalArgumentException("서로 다른 수로 이루어 져야 한다.");
      }
    }
  }

  private static void getHint(int ball, int strike) {
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

  private static List<Integer> createAnswer() {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < INPUT_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }

    return computer;
  }
}
