package baseball.core;

import baseball.Enum.GameStatus;
import baseball.core.participant.Opponent;
import baseball.core.participant.Player;
import baseball.core.rule.PickedNumbers;
import baseball.core.rule.RuleV1;
import baseball.exception.IllegalTypeException;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameHost {

    private final Player player;
    private final Referee referee;
    private final List<Integer> opponentNumberList;


    protected GameHost(Player player, Opponent opponent, Referee referee) {
        this.player = player;
        this.referee = referee;
        this.opponentNumberList = opponent.pickNumber();
    }

    public static GameHost createGameHost() {
        Player player = Player.createPlayer(NumberPicker.createNumberPicker());
        Opponent opponent = Opponent.createOpponent(NumberPicker.createNumberPicker());
        Referee referee = new Referee(RuleV1.makeScoreStrategy());
        return new GameHost(player, opponent, referee);
    }

    public void gameStart() {
        GameStatus gameStatus;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            gameStatus = playRound();
        } while (gameStatus == GameStatus.IN_PROGRESS);

        if (gameStatus == GameStatus.WIN) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        askForRestart();
    }

    private GameStatus playRound() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        List<Integer> playerNumberList = player.pickNumber(playerInput);

        PickedNumbers pickedNumbers = PickedNumbers.createPickedNumbers(opponentNumberList, playerNumberList);
        referee.checkPoint(pickedNumbers);

        return referee.getGameStatus();
    }

    private void askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();

        if ("1".equals(playerInput)) {
            GameHost newGame = GameHost.createGameHost();
            newGame.gameStart();
        } else if ("2".equals(playerInput)) {
            System.out.println("게임 종료");
            Console.close();
        } else {
            System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
            throw new IllegalTypeException();
        }
    }


}
