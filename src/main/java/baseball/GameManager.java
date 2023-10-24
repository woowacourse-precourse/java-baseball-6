package baseball;

import java.util.List;

public class GameManager {
    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void restartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void exitMessage() {
        System.out.println("게임 종료");
    }

    public String startGame(User user, Computer computer) {
        System.out.print("숫자를 입력해주세요 : ");
        user.consoleReadLine();
        return doGame(computer.number, user.number);

    }

    public String doGame(List<Integer> computerNumber, List<Integer> userNumber) {
        // 같은 수가 같은 자리에 있으면 스트라이크
        Integer strikeCount = getStrikeCount(computerNumber, userNumber);
        Integer ballCount = getBallCount(computerNumber, userNumber);
        if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        if (strikeCount > 0) {
            return +ballCount + "볼" + " " + strikeCount + "스트라이크";
        }

        if (ballCount > 0) {
            return ballCount + "볼";
        }

        return "낫싱";
    }

    private Integer getStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private Integer getBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        // 숫자가 같은 자리에 없고 다른 자리에 있으면 볼
        int ballCount = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) != userNumber.get(i) && computerNumber.contains(userNumber.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public boolean isCompleted(String result) {
        return result.equals("3스트라이크");
    }

    public boolean doGameAgain(Integer num, Computer computer) {
        if (num == 1) {
            computer.resetNumber();
            return true;
        }
        return false;
    }
}
