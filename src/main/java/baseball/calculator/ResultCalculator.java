package baseball.calculator;

public class ResultCalculator {

    public String calculateResult(String userInput, String computerNumber) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userInput.length(); i++) {
            char userChar = userInput.charAt(i);
            if (userChar == computerNumber.charAt(i)) {
                strikes++;
            } else if (computerNumber.contains(String.valueOf(userChar))) {
                balls++;
            }
        }

        return formatResult(strikes, balls);
    }

    private String formatResult(int strikes, int balls) {
        if (strikes == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            return balls + "볼 " + strikes + "스트라이크";
        }
    }
}
