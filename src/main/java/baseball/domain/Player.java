package baseball.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {
    private String playerNumber;
    private int retryNumber;
    private PlayerStatus playerStatus;

    public Player() {
        this.playerStatus = PlayerStatus.CREATE;
    }

    public Player(String playerNumber) {
        isStringLengthCorrect(playerNumber);
        isDigitPlayerNumber(playerNumber);
        isDifferentPlayerNumber(playerNumber);
        this.playerNumber = playerNumber;
        this.playerStatus = PlayerStatus.PROCEEDING;
    }

    public Player(int retryNumber) {
        this.retryNumber = retryNumber;
    }

    public void setRetryNumber(int retryNumber) {
        this.retryNumber = retryNumber;
    }

    public int getRetryNumber() {
        return retryNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public static void isStringLengthCorrect(String word) {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }

    public static void isDigitPlayerNumber(String word) {
        IntStream.range(0, word.length())
                .forEach(place -> isDigitCharInString(word, place));
    }

    public static void isDigitCharInString(String word, int index) {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(자연수가 아닌 수가 존재합니다.)");
        }
    }

    public static void isDifferentPlayerNumber(String word) {
        Set<Character> set = IntStream.range(0, word.length())
                .mapToObj(word::charAt)
                .collect(Collectors.toSet());

        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자가 존재합니다.)");
        }
    }
}
