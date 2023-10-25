package baseball.domain;

import baseball.domain.Validator.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameController {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String PLAYER_INPUT_PROCEED_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String PLAYER_INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_RESTART_CODE = "1";
    private static final char CHARACTER_ZERO = '0';

    Player player;
    Computer computer;
    Referee referee;
    PlayerInputValidator playerInputValidator;
    RandomNumberGenerator randomNumberGenerator;

    public BaseBallGameController() {
        this.player = new Player();
        this.computer = new Computer();
        this.referee = new Referee();
        this.playerInputValidator = new PlayerInputValidator();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);
        String playerRestartInput;
        do {
            if (!playGame()) {
                return;
            } else {
                playerRestartInput = readPlayerRestartInput();
                playerInputValidator.validRestartNumber(playerRestartInput);
            }
        } while (playerRestartInput.equals(GAME_RESTART_CODE));
    }

    public boolean playGame() {
        initialize();
        while (proceedGame()) {
        }
        return true;
    }

    public void initialize() {
        player = new Player();
        computer = new Computer();
        computer.createComputerBall(randomNumberGenerator.generateRandomNumber());
    }

    private boolean proceedGame() {
        String playerAnswer = readPlayerAnswerInput();
        playerInputValidator.validAnswerNumber(playerAnswer);
        player.createPlayerBall(convertPlayerInputToList(playerAnswer));

        return referee.compareNumberByPlayerAndComputer(player.getPlayerBall(), computer.getComputerBall());
    }

    public List<Integer> convertPlayerInputToList(String playerInput) {
        List<Integer> playerInputList = new ArrayList<>();

        for (char c : playerInput.toCharArray()) {
            playerInputList.add(c - CHARACTER_ZERO);
        }
        return playerInputList;
    }

    public String readPlayerAnswerInput() {
        System.out.print(PLAYER_INPUT_PROCEED_MESSAGE);
        return Console.readLine();
    }

    public String readPlayerRestartInput() {
        System.out.println(GAME_WIN_MESSAGE);
        System.out.println(PLAYER_INPUT_RESTART_MESSAGE);
        return Console.readLine();
    }
}