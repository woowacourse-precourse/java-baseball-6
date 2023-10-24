package baseball.service;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.service.hint.HintService;
import baseball.util.InputUtil;
import baseball.view.*;
import java.util.List;

public class GameServiceImpl implements GameService {

    public GameServiceImpl() {

    }

    @Override
    public void playOneGame(InputView inputView, HintView hintView,
                            EndView endView, RestartView restartView,
                            HintService hintService,
                            NumberBaseball computerBaseball) {
        while (true) {
            inputView.displayInputMessage();

            String inputNum = InputUtil.inputString();
            NumberBaseball inputBaseball = NumberBaseball.createBaseball(inputNum);

            Hint hint = hintService.createHint(computerBaseball, inputBaseball);
            List<String> countList = hintService.counts(hint);
            List<String> nameList = hintService.names(hint);
            hintView.displayHintMessage(countList, nameList);

            endOneGame();
        }
    }


    public void endOneGame() {
        //[게임 종료]
        //사용자가 입력한 숫자와 컴퓨터가 뽑은 숫자가 모두 같으면 "게임 종료 문구" 출력 후 게임 종료　
        /*if (strike == GameConstants.NUMBER_LENGTH) {
            endView.displayEndMessage();
            restartView.displayRestartChoiceMessage();
            String regameNum = InputUtil.inputString();

            //사용자가 잘못된 값을 입력하면 IllegalArgumentException을 발생시킨 후 애플리케이션이 종료된다.
            //검증: 만약 숫자가 아닌 것을 입력하면 잘못 입력한 것이다.
            IntegerUtil.validateInteger(regameNum);
            int parsedRegameNum = Integer.parseInt(regameNum);

            Restart restart = RestartController.validateValue(parsedRegameNum);

            if (restart == Restart.RESTART_GAME) {
                break GuessingLoop;
            }
            if (restart == Restart.EXIT_GAME) {
                return;
            }
            if (restart == Restart.OTHER_CHOICE) {
                ExceptionUtil.throwInvalidValueException();
            }
        }*/ //TODO:
    }
}
