package baseball;

import baseball.domain.Judgement;
import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {

    startGame();

    NumberGenerator generator = new NumberGenerator();
    List<Integer> computer = generator.createRandomNumbers();


    Referee referee = new Referee();

    String result = "";
    while (!result.equals("0 볼 3 스트라이크")){
      result = referee.compare(computer, askNumbers());
      System.out.println(result);
    }
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  private static void startGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }


  public static List<Integer> askNumbers(){
    System.out.println("숫자를 입력해주세요 : ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();

    List<Integer> numbers = new ArrayList<>();
    for(String number : input.split("")){
      numbers.add(Integer.valueOf(number));
    }
    return numbers;
  }
}
