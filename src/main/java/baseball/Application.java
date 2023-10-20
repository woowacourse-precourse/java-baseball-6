package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String STRING_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;

    private static GameState gameState;

    private static final String STRING_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String STRING_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRING_START_INPUT = "1";
    private static final String STRING_EXIT_INPUT = "2";

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

        while (gameState.isInGame()) {
            printNumberInputMessage();
            String userInput = Console.readLine();
            validateGameSceneUserInput(userInput);

            BaseBallNumberGroup user = new BaseBallNumberGroup(getNumberListFromUserInput(userInput));
            BaseBallResult baseBallResult = new BaseBallResult(computer, user);
            baseBallResult.print();

            if (baseBallResult.isAllStrike()) {
                gameState = GameState.END;
            }
        }
    }

    public static void printNumberInputMessage() {
        System.out.print(STRING_NUMBER_INPUT_MESSAGE);
    }

    public static void validateGameSceneUserInput(String userInput) {
        if (!gameState.isInGame()) {
            throw new IllegalArgumentException("게임 모드가 아닙니다.");
        }

        if (!isUserInputLengthSizeRandomNumber(userInput)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public static boolean isUserInputLengthSizeRandomNumber(String userInput) {
        return userInput.length() == GameConstants.SIZE_RANDOM_NUMBER;
    }

    public static List<Integer> getNumberListFromUserInput(String userInput) {
        List<Integer> numberList = new ArrayList<>();
        for (char oneLetter : userInput.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(oneLetter));
            numberList.add(number);
        }
        return numberList;
    }

    public static void handleEndScene() {
        System.out.println(STRING_END_MESSAGE);

        String userInput;
        while (gameState.isInEnd()) {
            userInput = Console.readLine();
            handleEndSceneInput(userInput);
        }
    }

    public static void handleEndSceneInput(String userInput) {
        switch (userInput) {
            case STRING_START_INPUT -> gameState = GameState.GAME;
            case STRING_EXIT_INPUT -> gameState = GameState.EXIT;
        }
    }

    private static void handleExitScene() {
        // Empty
    }
}
