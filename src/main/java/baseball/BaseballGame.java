package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class BaseballGame {
    private static final int NUMBER_LENGTH = 3;

    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";

    public static void run() {
        int userEndOption;

        printGameStart();
        do {
            playGame();
            userEndOption = inputEndOption();
        } while (!isGameEnd(userEndOption));
    }

    private static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void playGame() {
        List<Integer> randomNum;
        List<Integer> userNum;
        Map<String, Integer> result;

        randomNum = initRandomNum();
        do {
            userNum = inputUserNum();
            result = countStrikeAndBall(userNum, randomNum);
            printGameResult(result);
        } while (!isAllStrike(result));
    }

    private static List<Integer> initRandomNum() {
        List<Integer> randomNumList = new ArrayList<>();
        
        while (randomNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(randomNumber)){
                randomNumList.add(randomNumber);
            }
        }

        return randomNumList;
    }
    
    private static List<Integer> inputUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputString = Console.readLine();
        checkUserNumForm(userInputString);

        Integer userInput = Integer.valueOf(userInputString);
        List<Integer> userNum = new ArrayList<>();

        while (userInput != 0) {
            userNum.add(0, userInput % 10);
            userInput /= 10;
        }

        return userNum;
    }

    private static void initStrikeAndBallNum(Map<String, Integer> resultList) {
        resultList.put("strike", 0);
        resultList.put("ball", 0);
    }

    private static Map<String, Integer> countStrikeAndBall(List<Integer> userNum, List<Integer> randomNum) {
        Map<String, Integer> resultList = new HashMap<>();
        initStrikeAndBallNum(resultList);

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userNum.get(i) == randomNum.get(i)) {
                resultList.put("strike", resultList.get("strike") + 1);
            } else if (randomNum.contains(userNum.get(i))) {
                resultList.put("ball", resultList.get("ball") + 1);
            }
        }
        return resultList;
    }

    private static void printGameResult(Map<String, Integer> resultList) {
        int strikeCount = resultList.get("strike");
        int ballCount = resultList.get("ball");
        String result = "낫싱";
        if (strikeCount != 0 && ballCount != 0) {
            result = ballCount + "볼 " + strikeCount + "스트라이크";
        } else if (ballCount != 0) {
            result = ballCount + "볼";
        } else if (strikeCount != 0) {
            result = strikeCount + "스트라이크";
        }

        System.out.println(result);
        printWinGame(resultList);
    }

    private static boolean isAllStrike(Map<String, Integer> resultList) {
        if (resultList.get("strike") == 3) {
            return true;
        }
        return false;
    }

    private static void printWinGame(Map<String, Integer> resultList) {
        if (isAllStrike(resultList)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static int inputEndOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endOption = Console.readLine();
        checkEndOptionForm(endOption);

        return Integer.valueOf(endOption);
    }

    private static boolean isGameEnd(int endOption) {
        if (endOption == 2) {
            return true;
        }
        return false;
    }

    private static void checkUserNumForm(String userInput) {
        if (!isInteger(userInput)) {
            throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
        }
        if (isNegative(userInput)) {
            throw new IllegalArgumentException("입력이 음수입니다.");
        }
        if (!isThreeDigits(userInput)) {
            throw new IllegalArgumentException("사용자 입력이 3자리수가 아닙니다.");
        }
        if (isDuplicatedNum(userInput)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        if (userInput.contains("0")) {
            throw new IllegalArgumentException("사용자 입력에 0이 포함됐습니다.");
        }
    }
  
      private static void checkEndOptionForm(String endOption) {
        if (!isInteger(endOption)) {
            throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
        }
        if (!endOption.equals(RESTART_GAME) && !endOption.equals(END_GAME)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야합니다.");
        }
    }

    private static boolean isInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean isNegative(String userInput){
        int userInputInt = Integer.parseInt(userInput);
        if (userInputInt < 0) {
            return true;
        }
        return false;
    }

    private static boolean isThreeDigits(String userInput){
        int userInputInt = Integer.parseInt(userInput);
        int userInputLength = (int) ( Math.log10(userInputInt)+1 );
        if (userInputLength == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isDuplicatedNum(String userInput) {
        Set<Character> userInputSet = new HashSet<>();

        for (char userInputChar : userInput.toCharArray()) {
            userInputSet.add(userInputChar);
        }

        if (userInputSet.size() == userInput.length()) {
            return false;
        }
        return true;
    }
}
