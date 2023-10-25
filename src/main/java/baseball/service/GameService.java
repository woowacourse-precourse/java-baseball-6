package baseball.service;

import baseball.constant.value.GameValue;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Reply;
import baseball.validation.InputNumberValidation;
import baseball.view.GameView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameService {

    private GameView gameView;
    private Computer computer;
    private Player player;

    public void init() {
        this.gameView = new GameView();
        this.computer = createComputer();
        createPlayer();
        start();
    }

    private void start() {
        while (!isStrike(player.getPlayerNumber(), computer.getComputerNumber())) {
            getReply();
            createPlayer();
        }
        gameView.printThreeStrike();
        gameView.printGameEnd();
        retry();
    }

    public Computer createComputer() {
        return new Computer();
    }

    private void createPlayer() {
        gameView.printRequestInput();

        Player player = new Player();
        String playerInput = readLine();

        InputNumberValidation.inputThreeNumberValidate(playerInput);
        player.setPlayerNumber(convertStringToList(playerInput));

        this.player = player;
    }

    public List<Integer> convertStringToList(String playerInput) {
        List<Integer> list = new ArrayList<>();
        for (char ch : playerInput.toCharArray()) {
            list.add(ch - '0');
        }
        return list;
    }

    public boolean isStrike(List<Integer> playerInput, List<Integer> computerInput) {
        return Arrays.equals(computerInput.toArray(), playerInput.toArray());
    }

    private void retry() {
        gameView.printRetry();
        String retryInput = readLine();
        InputNumberValidation.inputSelectValidation(retryInput);

        if (retryInput.equals(GameValue.RETRY)) {
            init();
        }
    }

    private void getReply() {
        Reply reply = new Reply(computer.getComputerNumber(), player.getPlayerNumber());
        reply.setBallAndStrike();

        if (reply.getBallCnt() == GameValue.ZERO && reply.getStrikeCnt() == GameValue.ZERO) {
            gameView.printNothing();
        }
        if (reply.getBallCnt() != GameValue.ZERO && reply.getStrikeCnt() != GameValue.ZERO) {
            gameView.printBallCntAndStrikeCnt(reply.getBallCnt(), reply.getStrikeCnt());
        }
        if (reply.getBallCnt() == GameValue.ZERO && reply.getStrikeCnt() != GameValue.ZERO) {
            gameView.printStrikeCount(reply.getStrikeCnt());
        }
        if (reply.getBallCnt() != GameValue.ZERO && reply.getStrikeCnt() == GameValue.ZERO) {
            gameView.printBallCount(reply.getBallCnt());
        }
    }
}
