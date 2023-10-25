package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Game {

  private List<Integer> computerNumbers;

  public Game() {
    computerNumbers = generateRandomNumbers(3, 1, 9);
  }

  public void playGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    while (true) {
      System.out.print("숫자를 입력해주세요 : ");
      String guessInput = Console.readLine();
      List<Integer> guessNumbers = parseGuessNumber(guessInput);

      if (guessNumbers.size() != 3) {
        throw new IllegalArgumentException("잘못된 입력입니다.");
      }

      int strikeCount = countStrikes(guessNumbers);
    }
  }

  private List<Integer> generateRandomNumbers(int count, int min, int max) {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < count) {
      int randomNumber = Randoms.pickNumberInRange(min, max);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
    return computer;
  }

  private List<Integer> parseGuessNumber(String guessNumber) {
    List<Integer> guessNumberList = new ArrayList<>();
    for (int i = 0; i < guessNumber.length(); i++) {
      char digitChar = guessNumber.charAt(i);
      if (Character.isDigit(digitChar)){
        int digit = Character.getNumericValue(digitChar);
        guessNumberList.add(digit);
      } else {
        throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
      }
    }
    return guessNumberList;
  }

  private int countStrikes(List<Integer> guessNumbers) {
    int strikeCount = 0;
    for (int i = 0; i < guessNumbers.size(); i++) {
      if (computerNumbers.get(i).equals(guessNumbers.get(i))) {
        strikeCount++;
      }
    }
    return strikeCount;
  }
}