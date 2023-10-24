package baseball.play.start.input;

import baseball.play.start.create.InputCommands;
import camp.nextstep.edu.missionutils.Console;

public class GameInputContext {

  public static GameStartedEvent startedEvent(InputCommands inputCommands){
    UnvalidatedInputNum unvalidatedInputNum = unvalidatedInputNum();
    ValidatedInputNum validatedInputNum = ValidatedInputNum.of(unvalidatedInputNum.getInput());
    return GameStartedEvent.of(validatedInputNum, inputCommands.getRandomNums());
  }

  private static UnvalidatedInputNum unvalidatedInputNum() {
    return UnvalidatedInputNum.of(Console.readLine());
  }
}
