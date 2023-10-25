package baseball.View;

public class OutputView {
    public void displayResult(int strikes, int balls) {
        String resultMessage = getResultMessage(strikes, balls);
        System.out.println(resultMessage);
    }

    private String getResultMessage(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();

        if (balls > 0) {
            result.append(balls).append("볼");
            if (strikes > 0) {
                result.append(" ");
            }
        }

        if (strikes > 0) {
            result.append(strikes).append("스트라이크");
        }

        return result.toString();
    }
    public void displayGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void displayGameWon() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
//    public void displayError(String message) {
//        System.out.println("오류: " + message);
//    }
}

