package baseball.domain;

import baseball.domain.Validator.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameController {

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
        System.out.println("숫자 야구 게임을 시작합니다.");
        String playerRestartInput;
        do {
            if (!playGame()) {
                return;
            } else {
                playerRestartInput = readPlayerRestartInput();
                playerInputValidator.validRestartNumber(playerRestartInput);
            }
        } while (playerRestartInput.equals("1"));
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
            playerInputList.add(c - '0');
        }
        return playerInputList;
    }

    public String readPlayerAnswerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String readPlayerRestartInput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}