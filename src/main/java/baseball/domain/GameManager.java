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

    // 스트라이크,볼,낫싱의 결과값을 리턴하는 메서드.
    public String result() {
        StringBuilder builder = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            builder.append("낫싱");
            return builder.toString();
        }

        if (ballCount > 0) {
            builder.append(ballCount).append("볼 ");
        }

        if (strikeCount > 0) {
            builder.append(strikeCount).append("스트라이크");
        }

        return builder.toString();
    }
}
