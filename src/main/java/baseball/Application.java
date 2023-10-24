package baseball;

import static Constants.Constants.MAX_STRIKE;
import static Constants.Constants.NUM_LENGTH;
import static Constants.Constants.NEW_LINE;
import static Constants.Constants.RESTART;
import static Constants.Constants.EXIT;

import Entity.GameNumber;
import Entity.GameScore;
import Enum.Status;
import Manager.InputManager;
import Manager.PrintManager;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 메인 애플리케이션
 * 1주차 미션 - 숫자 야구
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
 */
public class Application {

    private static GameNumber gameNumber;   // 컴퓨터 숫자, 유저 숫자
    private static GameScore gameScore;     // 볼, 스트라이크

    public static void main(String[] args) {
        initialize();   // 클래스 변수 초기화

        try {
            startBaseballGame();
        } catch (IllegalArgumentException e) {
            // 잘못된 값을 입력할 경우, error를 발생시킨 뒤 종료
            throw e;
        }
    }

    public static void startBaseballGame() {
        PrintManager.showStatus(Status.GAME_START, NEW_LINE);   // 게임 시작 문구 출력

        do {
            playGame();
        }
        while (isRestart()); // 1: 재시작, 2: 종료
    }

    public static void playGame() {
        createComputerNumber(); // 컴퓨터의 랜덤 값 생성
        while (gameScore.getStrike() != MAX_STRIKE) {   // 3 Strike면 탈출
            inputUserNumber();  // 사용자 수 입력
            calculateScore();   // Ball과 Strike를 계산
        }
    }

    public static void initialize() {
        gameNumber = new GameNumber();
        gameScore = new GameScore();
    }

    public static void createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {   // 서로 다른 수 3개를 선택
                computerNumber.add(randomNumber);
            }
        }

        gameNumber.setComputer(computerNumber);
    }

    public static void inputUserNumber() {
        PrintManager.showStatus(Status.INPUT_NUMBER, !NEW_LINE);

        String inputNumber = InputManager.getString();
        List<Integer> userNumber = InputManager.parseInput(inputNumber);
        gameNumber.setUser(userNumber);

        boolean isValidate = gameNumber.validateUserNumber();   // 세 자리 숫자를 입력했는지 확인
        if (!isValidate) {
            // 유효하지 않은 입력이면 에러 throw
            throw new IllegalArgumentException();
        }
    }

    public static void calculateScore() {
        gameScore.reset();
        // 같은 수가 다른 자리에 있으면 볼
        // 같은 수가 같은 자리에 있으면 스트라이크
        gameScore.calculateScore(gameNumber);

        // N볼 M스트라이크"의 결과를 보여줌
        PrintManager.showGameResult(gameScore.getBall(), gameScore.getStrike());
    }

    public static boolean isRestart() {
        PrintManager.showStatus(Status.RESTART_OR_EXIT, NEW_LINE);
        int inputNumber = InputManager.getInt();

        // RESTART = 1, EXIT = 2
        if (inputNumber == RESTART) {
            gameScore.reset();
            return true;
        } else if (inputNumber == EXIT) {
            return false;
        }

        // 1과 2가 아닌 값을 입력하면 에러 throw
        throw new IllegalArgumentException();
    }
}

