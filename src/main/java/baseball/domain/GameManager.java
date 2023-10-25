package baseball.domain;

public class GameManager {

    private static final int LENGTH = 3;
    private int strikeCount;
    private int ballCount;

    // Computer 가 선택한 임의의 3자리 숫자와 Player 가 입력한 3자리 숫자를 비교하는 메서드.
    public void check(Computer computer, Player player) {
        strikeCount = strikeCheck(computer, player);
        ballCount = ballCheck(computer, player);
    }

    // Computer 가 선택한 임의의 3자리 숫자와 Player 가 입력한 3자리 숫자에서 스트라이크 카운터를 리턴하는 메서드.
    private int strikeCheck(Computer computer, Player player) {
        strikeCount = 0;

        for (int i = 0; i < LENGTH; i++) {
            if (computer.getRandomNumber().charAt(i) == player.getInputNumber().charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    // Computer 가 선택한 임의의 3자리 숫자와 Player 가 입력한 3자리 숫자에서 볼 카운터를 리턴하는 메서드.
    private int ballCheck(Computer computer, Player player) {
        ballCount = 0;

        for (int i = 0; i < LENGTH; i++) {
            if (computer.getRandomNumber().charAt(i) != player.getInputNumber().charAt(i)
                    && computer.getRandomNumber().contains(Character.toString(player.getInputNumber().charAt(i)))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
