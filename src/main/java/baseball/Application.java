package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final String PREDICTION_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        print(START_MESSAGE);

        Game game = new Game();
        User user = new User();

        play(game, user);
    }

    public static void play(Game game, User user) {
        while (user.isContinued()) {
            game.init();
            resolve(game, user);
            askReGame(user);
        }
    }

    private static void askReGame(User user) {
        print(REGAME_MESSAGE);
        String newReGame = Console.readLine();
        user.setContinued(validateReGame(newReGame));
    }

    private static boolean validateReGame(String newReGame) throws IllegalArgumentException {
        if (newReGame.equals("1")) {
            return true;
        }

        if (newReGame.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static void resolve(Game game, User user) {
        Result result = new Result();
        while (result.isCorrect()) {
            game.reset();
            user.setPrediction(getPrediction());
            game.countStrikeOrBall(user.getPrediction());
            result.setResult(game);
            print(result.getMessage());
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static List<Integer> getPrediction() throws IllegalArgumentException {
        print(PREDICTION_MESSAGE);
        String userInput = Console.readLine();
        return validateUserInput(userInput);
    }

    public static List<Integer> validateUserInput(String response) throws IllegalArgumentException {
        List<Integer> prediction = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            int nextNumber = response.charAt(i) - '0';
            if (!prediction.contains(nextNumber) && 1 <= nextNumber && nextNumber <= 9) {
                prediction.add(response.charAt(i) - '0');
            }
        }

        if (prediction.size() != 3 || response.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        return prediction;
    }

}
