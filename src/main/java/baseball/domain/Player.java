package baseball.domain;

public class Player {
    private String playerNumber;

    public Player(String playerNumber) {
        isStringLengthCorrect(playerNumber);
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public static void isStringLengthCorrect(String word){
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }
}
