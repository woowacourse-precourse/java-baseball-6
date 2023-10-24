package baseball;

import static baseball.Type.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameMaster {

  private boolean shouldContinueRound;
  private boolean isCorrectAnswerFound;

  public GameMaster() {
    this.shouldContinueRound = true;
  }

  public void init() {
    this.isCorrectAnswerFound = false;
  }

  public boolean isGameInProgress() {
    return shouldContinueRound;
  }

  public boolean findCorrectAnswer() {
    return isCorrectAnswerFound;
  }

  public void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public String progress() {
    System.out.print("숫자를 입력해주세요 : ");
    return Console.readLine();
  }

  public String checkResult(String result) {
    System.out.println(result);
    if(result.equals("3스트라이크")) {
      return progressOrNot();
    }
    return null;
  }

  public String progressOrNot() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    return Console.readLine();
  }

  public String printResult(Map<String, Integer> scoreBoard) {
    String result = read(scoreBoard);
    if(result.isEmpty()) {
      return "낫싱";
    }
    return result;
  }

  private String read(Map<String, Integer> scoreBoard) {
    List<String> typeOrders = getAllKinds();
    return scoreBoard.entrySet().stream()
        .filter(type -> type.getValue() != 0)
        .sorted(Comparator.comparingInt(type -> typeOrders.indexOf(type.getKey())))
        .map(type -> type.getValue() + type.getKey())
        .collect(Collectors.joining(" "));
  }

  public void conclude(String decideAnswer) {
    isCorrectAnswerFound = true;
    shouldContinueRound = decideAnswer.equals("1");
  }
}
