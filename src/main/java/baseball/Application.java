package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {

  public static void main(String[] args) {
    // 게임 시작을 사용자에게 알린다.
    System.out.println("숫자 야구 게임을 시작합니다.");

    while (true) {
      // 컴퓨터 숫자 랜덤 생성
      Computer computer = new Computer(new ArrayList<>());
      computer.makeRandomNumber();

      while (true) {
        // 사용자 숫자 입력
        User user = new User(new ArrayList<>());
        int[] result = new int[2];

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        user.inputValidation(input);

        // 컴퓨터의 수와 사용자의 수 비교
        compare(computer, user, result);

          if (viewResult(result)) {
              break;
          }

      }

      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      int choice = Integer.parseInt(Console.readLine());
        if (choice == 2) {
            break;
        } else if (choice == 1) {
            continue;
        } else {
            throw new IllegalArgumentException("1 또는 2만 입력하세요");
        }
    }


  }


    public static void compare(Computer computer, User user, int[] result) {
        for (int i = 0; i < 3; i++) {
            int num = user.getUser().get(i);
            if (computer.getComputer().contains(num)) {
                if (computer.getComputer().get(i) == num) {
                    result[0]++;
                } else {
                    result[1]++;
                }
            }
        }
    }

  public static boolean viewResult(int[] result) {
      if (result[0] == 0 && result[1] == 0) {
          System.out.println("낫싱");
      } else if (result[0] == 3) {
          System.out.println("3스트라이크");
          System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
          return true;
      } else if (result[1] == 0) {
          System.out.println(result[0] + "스트라이크");
      } else if (result[0] == 0) {
          System.out.println(result[1] + "볼");
      } else {
          System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
      }

    return false;
  }



}
