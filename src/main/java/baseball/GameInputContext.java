package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameInputContext {

  public static GameStartedEvent inputNumber(InputCommands inputCommands){
    UnvalidatedInputNum inputNum = unvalidatedInputNum();
    ValidatedInputNum validatedInputNum = ValidatedInputNum.of(inputNum.getInput());
    return GameStartedEvent.of(validatedInputNum, inputCommands.getRandomNums());
  }

  private static UnvalidatedInputNum unvalidatedInputNum() {
    printingInputPrompts();
    return UnvalidatedInputNum.of(Console.readLine());
  }

  private static void printingInputPrompts() {
    System.out.print("숫자를 입력해주세요 : ");
  }
}
