package baseball.service;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.domain.hint.HintItem;
import baseball.service.hint.HintItemService;
import baseball.util.InputUtil;
import baseball.view.*;
import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    //★DB를 사용하는 구조라면 Repository에 의존하면 되지만 여기서는 그렇지 않으므로 Service에 의존
    private List<HintItemService> hintItemServices;

    public GameServiceImpl(HintItemService... hintItemServices) {
        this.hintItemServices = List.of(hintItemServices);
    }

    @Override
    public void playOneGame(InputView inputView, HintView hintView,
                            EndView endView, RestartView restartView,
                            NumberBaseball computerBaseball) {
        while (true) {
            inputView.displayInputMessage();

            String inputNum = InputUtil.inputString();
            NumberBaseball inputBaseball = NumberBaseball.createBaseball(inputNum);

            List<HintItem> hintItems = new ArrayList<>();
            for (HintItemService hintItemServiceImpl : hintItemServices) {
                HintItem hintItem = hintItemServiceImpl.create(computerBaseball, inputBaseball);
                if (hintItemServiceImpl.isActive(hintItem)) {
                    hintItems.add(hintItem);
                }
            }

            Hint hint = Hint.createHint(hintItems);
            hintView.displayHintMessage(hint);

            endOneGame();
        }
    }

    @Override
    public Hint createHint(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        List<HintItem> hintItems = new ArrayList<>();

        for (HintItemService hintItemServiceImpl : hintItemServices) {
            HintItem hintItem = hintItemServiceImpl.create(computerBaseball, inputBaseball);
            if (hintItemServiceImpl.isActive(hintItem)) {
                hintItems.add(hintItem);
            }
        }
        return Hint.createHint(hintItems);
    }

    public void endOneGame() {
        //[게임 종료]
        //사용자가 입력한 숫자와 컴퓨터가 뽑은 숫자가 모두 같으면 "게임 종료 문구" 출력 후 게임 종료　
        if (strike == GameConstants.NUMBER_LENGTH) {
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
        }
    }
}
