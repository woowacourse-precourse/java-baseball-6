package baseball;

import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

  private final static int GAME_ING_LIMIT = 3;
  private final static int GAME_EXIT_LIMIT = 1;
  private final static String EXIT = "2";

  public static void main(String[] args) {
    InputValidator inputValidator = new InputValidator();
    List<Integer> computer = new ArrayList<>();
    List<Integer> user;

    while (true) {
      System.out.println("숫자 야구 게임을 시작합니다.");
      gameInit(computer);

      while (true) {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        inputValidator.validateInput(input, GAME_ING_LIMIT);

        user = Arrays.stream(input.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        inputValidator.validateInputDuplicate(user);

        if (checkAnswer(computer, user)) {
          break;
        }
      }

      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      String exitInput = Console.readLine();

      inputValidator.validateExitInput(exitInput, GAME_EXIT_LIMIT);

      if (exitInput.equals(EXIT)) {
        break;
      }
    }
  }

  //사용자 입력에 따라 strike 와 ball 을 계산해 출력 후 3 strike 인지를 판단해 true or false 로 return 해준다.
  private static boolean checkAnswer(List<Integer> computer, List<Integer> user) {

    Baseball baseball = new Baseball();

    validateBaseball(computer, user, baseball);

    baseball.print();

    return baseball.isOut();
  }

  //사용자 입력에 따라 strike 와 ball 을 계산하는 함수
  private static void validateBaseball(List<Integer> computer, List<Integer> user,
      Baseball baseball) {
    int length = user.size();
    for (int i = 0; i < length; i++) {
      if (computer.contains(user.get(i))) {
        if (computer.get(i) == user.get(i)) {
          baseball.updateStrike();
        } else {
          baseball.updateBall();
        }
      }
    }
  }

  //computer List 에 1~9사이의 랜덤한 값을 3개 생성하는 함수
  private static void gameInit(List<Integer> computer) {
    computer.clear();

    while (computer.size() < GAME_ING_LIMIT) {
      int randomNumber = makeRandomNumber();
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
  }

  //1~9 사이의 랜덤한 정수 반환하는 함수
  private static int makeRandomNumber() {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    return randomNumber;
  }


}
