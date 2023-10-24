package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class BaseballGame implements GameInterface {
    private static final int NUMBER_SIZE = 3;
    private List<Integer> computerNumber;

    @Override
    public void initialize() {
        computerNumber = new ArrayList<>();
        pickComputerNumber();
    }

    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    @Override
    public boolean isEndGame() {
        return decideEndGame();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private void playGame() {
        while (true) {
            List<Integer> userInput = readAndParseInput();
            HashMap<ScoreType, Integer> result = calculateScore(userInput);
            displayResult(result);
            if (isGameWon(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    private List<Integer> readAndParseInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputValidator.validateGameInput(input);
        return parseString(input);
    }

    private List<Integer> parseString(String target) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : target.toCharArray()) {
            numbers.add(ch - '0');
        }
        return numbers;
    }

    private HashMap<ScoreType, Integer> calculateScore(List<Integer> userInput) {
        int strike = 0, ball = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals(computerNumber.get(i))) {
                strike++;
            } else if (computerNumber.contains(userInput.get(i))) {
                ball++;
            }
        }
        HashMap<ScoreType, Integer> result = new HashMap<>();
        result.put(ScoreType.STRIKE, strike);
        result.put(ScoreType.BALL, ball);
        return result;
    }

    private void displayResult(HashMap<ScoreType, Integer> result) {
        int strike = result.get(ScoreType.STRIKE);
        int ball = result.get(ScoreType.BALL);

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println();
        }
    }

    private void pickComputerNumber() {
        while (computerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private boolean isGameWon(HashMap<ScoreType, Integer> result) {
        return result.get(ScoreType.STRIKE) == 3;
    }

    private boolean decideEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        InputValidator.validateRestartOrEndInput(input);
        return input.charAt(0) == '2';
    }
}