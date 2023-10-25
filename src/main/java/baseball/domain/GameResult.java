package baseball.domain;


public class GameResult {
    private String result;

    public GameResult() {
        result = "";
    }

    public void addCorrectMessage() {
        result += "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public void displayResult() {
        System.out.println(result);
    }

    public void addBallCount(Integer balls) {
        result += balls + "볼 ";
    }

    public void addStrikeCount(Integer strikes) {
        result += strikes + "스트라이크";
    }

    public boolean isResultBlank() {
        return (result.equals(""));
    }

    public void addNothingMessage() {
        result += "낫싱";
    }
}
