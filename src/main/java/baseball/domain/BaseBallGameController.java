package baseball.domain;


import baseball.domain.Validator.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameController {
    PlayerInputValidator playerInputValidator;
    Player player;
    Computer computer;
    RandomNumberGenerator randomNumberGenerator;
    Referee referee;

    public BaseBallGameController() {
        this.playerInputValidator = new PlayerInputValidator();
        this.player = new Player();
        this.computer = new Computer();
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.referee = new Referee();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            if (!playGame()) {
                return;
            }
        } while (readPlayerRestartInput());
    }

    public boolean playGame() {
        // 게임 초기화
        initialize();

        // 난수 생성 및 컴퓨터에 값 세팅
        computer.createComputerBall(randomNumberGenerator.generateRandomNumber());

        do {
            // 사용자 입력 받고 잘못된값은 예외처리, 올바른 값은 사용자값 세팅
            if (!readPlayerAnswerInput()) {
                return false;
            }
            // 사용자값 컴퓨터값과 비교하여 판정 및 결과 출력
        } while (referee.compareNumberByPlayerAndComputer(player.getPlayerBall(), computer.getComputerBall()));

        return true;
    }

    public void initialize() {
        player = new Player();
        computer = new Computer();
    }

    public List<Integer> changePlayerInputToList(String playerInput) {
        List<Integer> playerInputList = new ArrayList<>();

        for (char c : playerInput.toCharArray()) {
            playerInputList.add(c - '0');
        }
        return playerInputList;
    }

    public boolean readPlayerAnswerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        // 사용자 값 입력받기
        String playerInput = Console.readLine();

        playerInputValidator.validAnswerNumber(playerInput);
        // String -> List
        List<Integer> playerInputList = changePlayerInputToList(playerInput);

        // Set Player
        player.createPlayerBall(playerInputList);
        return true;
    }

    public boolean readPlayerRestartInput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        // 사용자 값 입력받기
        String playerInput = Console.readLine();

        playerInputValidator.validRestartNumber(playerInput);
        return playerInput.equals("1");
    }
}
