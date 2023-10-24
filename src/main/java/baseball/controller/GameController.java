package baseball.controller;

import static baseball.util.NumberUtil.convertStringToList;

import baseball.application.NumberService;
import baseball.domain.Hint;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Objects;

public class GameController {

    private final NumberService numberService = NumberService.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        do {
            Player computer = prepareComputer();

            play(computer);

        } while (!Objects.equals(inputView.readNumber(), "2")); // 종료(2)를 누르지 않으면 게임을 다시 시작한다.
    }

    private void play(Player computer) {
        while (true) {
            Player player = preparePlayer();

            Hint hint = numberService.generateHint(computer, player); // 컴퓨터와 플레이어의 숫자를 비교하여 힌트를 얻는다.
            outputView.printHintMessage(hint); // 힌트를 출력, 만약 숫자가 맞는다면 게임 종료 메시지도 출력한다.
            if (hint.isThreeStrike()) { // 숫자를 맞췄다면 끝낸다.
                break;
            }
        }
    }

    private Player prepareComputer() {
        return new Player(numberService.getRandomNumber());
    }

    private Player preparePlayer() {
        outputView.printReadMessage();
        return new Player(convertStringToList(inputView.readNumber()));
    }
}
