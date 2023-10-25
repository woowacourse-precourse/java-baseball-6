package baseball;

import baseball.utils.RandomUtil;
import baseball.utils.UserInputUtil;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {
    Score score = new Score();

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            startRound();
            if(checkProgress()) {
                break;
            }
        }
    }

    private static boolean checkProgress() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartOrQuit = readLine();
        UserInputUtil.isStringOneOrTwo(restartOrQuit);

        return UserInputUtil.isSelectQuit(restartOrQuit);
    }

    private void startRound() {
        List<Integer> computerNumber = RandomUtil.generateRandomNumber(3);

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            UserInputUtil.validateThreeDifferentNatureNumber(userInput);

            List<Integer> userNumber = UserInputUtil.convertStringToIntegerList(userInput);
            updateScore(computerNumber, userNumber);
            printHint();
        } while (score.getStrike() != 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void updateScore(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            var result = compareNumber(computerNumber, userNumber.get(i), i);
            if ("스트라이크".equals(result)) {
                strike++;
            } else if ("볼".equals(result)) {
                ball++;
            }
        }

        score.setScore(ball, strike);
    }

    public String compareNumber(List<Integer> computerNumber, int userInputValue, int userInputIndex) {
        for(int i = 0; i < 3; i++) {
            if(computerNumber.get(i).equals(userInputValue) && i == userInputIndex) {
                return "스트라이크";
            } else if(computerNumber.get(i).equals(userInputValue) && i != userInputIndex) {
                return "볼";
            }
        }
        return "낫싱";
    }

    private void printHint() {
        int strike = score.getStrike();
        int ball = score.getBall();

        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }

        if(ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if(strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println();
    }
}