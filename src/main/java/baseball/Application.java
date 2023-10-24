package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum ScoreType {
    STRIKE, BALL
}

interface GameInterface {
    void initialize();

    void start();

    boolean defer();
}

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            pickComputerNumber(computerNumber);
            System.out.println(computerNumber);
            playGame(computerNumber);
            computerNumber.clear();
            if (isEndGame()) {
                return;
            }
        }
    }

    private static void pickComputerNumber(List<Integer> computerNumber) {
        int randomNumber;
        while (computerNumber.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private static void playGame(List<Integer> computerNumber) throws IllegalArgumentException {
        List<Integer> parsedInput = new ArrayList<>();
        HashMap<ScoreType, Integer> result = new HashMap<>();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
            parseString(parsedInput, input);
            calculateScore(parsedInput, computerNumber, result);
            printResult(result.get(ScoreType.strike), result.get(ScoreType.ball));
            if (result.get(ScoreType.strike) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
            parsedInput.clear();
            result.clear();
        }
    }

    private static void calculateScore(List<Integer> input, List<Integer> computerNumber, HashMap result) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == computerNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(input.get(i))) {
                ball++;
            }
        }
        result.put(ScoreType.strike, strike);
        result.put(ScoreType.ball, ball);
    }

    private static void printResult(int strike, int ball) {
        String resultString = "";
        if (strike == 0 && ball == 0) {
            resultString = "낫싱";
        }
        if (ball != 0) {
            resultString += ball + "볼 ";
        }
        if (strike != 0) {
            resultString += strike + "스트라이크";
        }
        System.out.println(resultString);
    }

    private static void parseString(List<Integer> result, String target) throws IllegalArgumentException {
        try {
            for (int i = 0; i < target.length(); i++) {
                result.add(target.charAt(i) - '0');
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEndGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        if (input.length() == 1 && input.charAt(0) == '1') {
            return false;
        }
        if (input.length() == 1 && input.charAt(0) == '2') {
            return true;


public class Application {
    public static void main(String[] args) {
        GameInterface game = new BaseballGame();

        while (true) {
            game.initialize();
            game.start();
            if (game.defer()) {
                return;
            }
        }
    }
}
