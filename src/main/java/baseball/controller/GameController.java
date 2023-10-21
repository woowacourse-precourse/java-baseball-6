package baseball.controller;

import baseball.application.NumberService;
import baseball.domain.Hint;
import baseball.domain.Player;
import baseball.util.NumberUtil;
import baseball.view.ViewService;
import java.util.Objects;

public class GameController {

    private final NumberService numberService;
    private final ViewService viewService;

    public GameController(NumberService numberService, ViewService viewService) {
        this.numberService = numberService;
        this.viewService = viewService;
    }

    public void startGame() {
        do {
            Player computer = prepareComputer();

            play(computer);

        } while (!Objects.equals(viewService.readNumber(), "2")); // 종료(2)를 누르지 않으면 게임을 다시 시작한다.
    }

    private void play(Player computer) {
        while (true) {
            Player player = preparePlayer();

            Hint hint = numberService.getHint(computer, player); // 컴퓨터와 플레이어의 숫자를 비교하여 힌트를 얻는다.
            viewService.printHintMessage(hint); // 힌트를 출력, 만약 숫자가 맞는다면 게임 종료 메시지도 출력한다.
            if (hint.isThreeStrike()) { // 숫자를 맞췄다면 끝낸다.
                break;
            }
        }
    }

    private Player prepareComputer() {
        Player computer = new Player();
        computer.setPlayer(numberService.getRandomNumber());
        return computer;
    }

    private Player preparePlayer() {
        Player player = new Player();

        viewService.printReadMessage();
        String number = viewService.readNumber();
        NumberUtil.validate(number);
        player.setPlayer(NumberUtil.converStringToList(number));

        return player;
    }
}
