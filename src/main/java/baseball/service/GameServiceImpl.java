package baseball.service;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.domain.hint.HintItem;
import baseball.service.hint.HintItemService;
import baseball.util.InputUtil;
import baseball.util.IntegerUtil;
import baseball.view.HintView;
import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    public void playOneGame() {
        /*while (true) { //TODO:
            //사용자는 서로 다른 숫자로 이루어진 3자리 숫자 1개를 입력　
    //★DB를 사용하는 구조라면 Repository에 의존하면 되지만 여기서는 그렇지 않으므로 Service에 의존
    private List<HintItemService> hintItemServices;

    public GameServiceImpl(HintItemService... hintItemServices) {
        this.hintItemServices = List.of(hintItemServices);
    }

            inputView.displayInputMessage();

            String inputNum = InputUtil.inputString();
            NumberBaseball inputBaseball = NumberBaseball.createBaseball(inputNum);

            //컴퓨터는 사용자가 입력한 숫자와 뽑은 숫자를 비교하여 힌트를 판단, 출력　
            Hint hint = HintController.create(computerBaseball, inputBaseball);

            Strike strike = StrikeController.countStrike(computerBaseball, inputBaseball);
            //같은 수가 전혀 없으면 낫싱　
            hint.setBall(ball);
            hint.setStrike(strike);
            hint.setNothing(nothing);
            HintView.displayHintMessage(hint);

            //[게임 종료]
            //사용자가 입력한 숫자와 컴퓨터가 뽑은 숫자가 모두 같으면 "게임 종료 문구" 출력 후 게임 종료　
            if (strike == GameConstants.NUMBER_LENGTH) {
                EndView.displayEndMessage();
                RestartView.displayRestartChoiceMessage();
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
            }
        }*/
    }
}
