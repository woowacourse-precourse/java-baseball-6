package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현

    System.out.println("숫자 야구 게임을 시작합니다.");
    playGame();

  }

  private static void playGame() {
    List<Integer> computer = createAnswer();//서로 다른 3자리 수 생성
    int ball=0, strike=0, pos=0;
    int restart = 0;

    while (strike != 3) {
      ball = 0;
      strike = 0;
      pos = 0;

      System.out.printf("숫자를 입력해주세요 : ");
      String num = readLine();

      verifiedInput(num);

      for (int i = 0; i < 3; i++) {
        int m = Character.getNumericValue(num.charAt(i));
        int index = computer.indexOf(m);
        if (index != -1) {
          if (index == pos) {
            strike++;
          } else {
            ball++;
          }
        }
        pos++;
      }

      getHint(ball, strike);//입력한 수에 대한 결과 출력

      if (strike == 3) {//3개의 숫자를 모두 맞힐경우
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restart = Integer.parseInt(readLine());
      }

      if (restart == 1) {
        playGame();
      } else if (restart == 2) {
        System.out.println("게임 종료");
      }
    }
  }

  private static void verifiedInput(String num) {

    try{
      Integer.parseInt(num);
    }catch (NumberFormatException e){
      throw new NumberFormatException("숫자를 입력해야 합니다.");
    }

    if (num.length()!=3) {
      throw new IllegalArgumentException();
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
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }

    return computer;
  }
}
