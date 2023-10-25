package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

  public static void main(String[] args) {

    System.out.println("숫자 야구 게임을 시작합니다.");

    while (true) {
      makeNumber();
      if (Integer.parseInt(readLine()) != 1) {
        break;
      }
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

  }

  static void makeNumber() {

    // 랜덤 값 생성
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }

    //사용자 입력
    while (true) {

      int strike = 0, ball = 0;

      List<Integer> inputNumbers = new ArrayList<>();

      System.out.print("숫자를 입력해주세요 : ");

      String[] input = readLine().split("");
      for (String s : input) {
        inputNumbers.add(Integer.parseInt(s));
      }

      if (inputNumbers.size() != 3) {
        throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
      }

      for (int i = 0; i < 3; i++) {
        if (computer.get(i).equals(inputNumbers.get(i))) {
          strike++;
        } else if (computer.contains(inputNumbers.get(i))) {
          ball++;
        }
      }

      if (strike == 3) {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return;
      }

      if (ball == 0 && strike == 0) {
        System.out.println("낫싱");
      } else {
        if (ball > 0) {
          System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
          System.out.print(strike + "스트라이크");
        }
        System.out.println();
      }
    }


  }
}
