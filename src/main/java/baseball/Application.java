package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String STRING_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;

    private static GameState gameState;

    public static void main(String[] args) {
        initialize();
        while (!gameState.isInExit()) {
            handleSceneByGameState();
        }
    }

    public static void initialize() {
        gameState = GameState.START;
    }

    public static List<Integer> getRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < GameConstants.SIZE_RANDOM_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public static void handleSceneByGameState() {
        switch (gameState) {
            case START -> handleStartScene();
            case GAME -> handleGameScene();
            case END -> handleEndScene();
            case EXIT -> handleExitScene();
            default -> throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public static void handleStartScene() {
        printStartMessage();
        gameState = GameState.GAME;
    }

    public static void printStartMessage() {
        System.out.println(STRING_START_MESSAGE);
    }

    public static void handleGameScene() {
        BaseBallNumberGroup computer = new BaseBallNumberGroup(getRandomNumberList());
    }

    public static void handleEndScene() {
    }

    private static void handleExitScene() {
        // Empty
    }
}
