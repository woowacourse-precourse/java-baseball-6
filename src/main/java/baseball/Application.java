package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean playAgain = true;
        List<Integer> answerNumber = new ArrayList<>();
        Map<String, Integer> gameStatus = new HashMap<String, Integer>() {{
            put("BALL_COUNT", 0);
            put("STRIKE_COUNT", 0);
        }};
        String againInput = "";
        String userInput = "";
        while (playAgain) {
            game(answerNumber, gameStatus, userInput);
            Message.nextGameMessage();
            againInput = readLine();
            playAgain = isPlayAgain(againInput);
        }
    }

    private static void game(List<Integer> answerNumber, Map<String, Integer> gameStatus, String userInput) {
        clearStatus(gameStatus);
        getRandomsNumber(answerNumber);
        System.out.println(Constant.START_MESSAGE);

        while (gameStatus.get("STRIKE_COUNT") != Constant.NUMBER_COUNT) {
            System.out.print(Constant.INPUT_MESSAGE);
            userInput = readLine();
            Validate.validateInput(userInput);
            clearStatus(gameStatus);
            getGameStatus(answerNumber, gameStatus, userInput);
            Message.generateMessage(gameStatus);
        }
    }



    private static void clearStatus(Map<String, Integer> gameStatus) {
        gameStatus.clear();
        gameStatus.put("BALL_COUNT", 0);
        gameStatus.put("STRIKE_COUNT", 0);
    }

    private static boolean isPlayAgain(String userInput) {
        boolean playAgain;
        if (Constant.GAME_RESTART.equals(userInput)) {
            playAgain = true;
        } else if (Constant.GAME_END.equals(userInput)) {
            playAgain = false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
        return playAgain;
    }


    private static void getGameStatus(List<Integer> answerNumber, Map<String, Integer> setStatus,
        String userInput) {
        for (int i = 0; i < Constant.NUMBER_COUNT; i++) {
            int checkNumber = answerNumber.get(i);
            char userChar = userInput.charAt(i);

            if (checkNumber == Character.getNumericValue(userChar)) {
                setStatus.put("STRIKE_COUNT", setStatus.get("STRIKE_COUNT") + 1);
            } else if (userInput.contains(String.valueOf(checkNumber))) {
                setStatus.put("BALL_COUNT", setStatus.get("BALL_COUNT") + 1);
            }
        }
    }



    private static void getRandomsNumber(List<Integer> computer) {
        computer.clear();
        while (computer.size() < Constant.NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Constant.START_NUM, Constant.END_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    static class Validate {
        public static void validateInput(String userInput) {
            if (!userInput.matches("\\d+")) {
                throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
            }

            if (userInput.length() != Constant.NUMBER_COUNT) {
                throw new IllegalArgumentException("입력이 숫자 3개가 아닙니다.");
            }

            if (hasDuplicateDigits(userInput)) {
                throw new IllegalArgumentException("입력에 중복된 숫자가 있습니다.");
            }
        }

        public static boolean hasDuplicateDigits(String input) {
            HashSet<Character> uniqueNumber = new HashSet<>();
            for (char c : input.toCharArray()) {
                if (uniqueNumber.contains(c)) {
                    return true;
                }
                uniqueNumber.add(c);
            }
            return false;
        }

    }

    static class Message {
        private static void nextGameMessage() {
            System.out.println(Constant.SUCCESS_MESSAGE);
            System.out.println(Constant.END_MESSAGE);
        }
        private static void generateMessage(Map<String, Integer> gameStatus) {
            int ballCount = gameStatus.get("BALL_COUNT");
            int strikeCount = gameStatus.get("STRIKE_COUNT");

            if (ballCount > 0 && strikeCount > 0) {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            } else if (ballCount > 0) {
                System.out.println(ballCount + "볼");
            } else if (strikeCount > 0) {
                System.out.println(strikeCount + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }

    }

    static class Constant {
        public static final int START_NUM = 1;
        public static final int END_NUM = 9;
        public static final String GAME_RESTART = "1";
        public static final String GAME_END = "2";
        public static final int NUMBER_COUNT = 3;
        public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
        public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
        public static final String SUCCESS_MESSAGE = Constant.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String END_MESSAGE = "게임을 새로 시작하려면 " + Constant.GAME_RESTART + ", 종료하려면 " + Constant.GAME_END + "를 입력하세요.";
    }
}
