package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
    List<Integer> computer = Computer.createAnswer();//서로 다른 3자리 수 생성
    int ball=0, strike=0;
    int restart = 0;

    while (strike != INPUT_SIZE) {
      ball = 0;
      strike = 0;

      System.out.printf("숫자를 입력해주세요 : ");
      String num = readLine();

      Input.verifiedInput(num);

      for (int pos = 0; pos < INPUT_SIZE; pos++) {
        int m = Character.getNumericValue(num.charAt(pos));
        int index = computer.indexOf(m);

        if (index == pos) {
          strike++;
        }
        if (index != pos && index != -1) {
          ball++;
        }
      }

      Output.getHint(ball, strike);//입력한 수에 대한 결과 출력
    }

    Output.endMessage();
    restart = Integer.parseInt(readLine());

    if (isRestart(restart)) {
      playGame();
    }
  }

  private static boolean isRestart(int restart){
    if (restart != 1 && restart != 2) {
      throw new IllegalArgumentException("1또는 2를 입력하세요");
    }
    if (restart == 2) {
      return false;
    }

    return true;
  }
}
