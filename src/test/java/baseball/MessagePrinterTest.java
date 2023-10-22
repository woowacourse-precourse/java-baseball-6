package baseball;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessagePrinterTest {
    @Test
    @DisplayName("스트라이크만 존재할 경우 스트라이크만 출력한다.")
    void test1() {
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> computerNumbers = List.of(3, 5, 6);
        String playerNumbers = "324";

        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount += 1;
            } else if (computerNumbers.contains(playerNumber)) {
                ballCount += 1;
            }
        }

        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }

    @Test
    @DisplayName("볼만 존재할 경우 볼만 출력한다.")
    void test2() {
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> computerNumbers = List.of(3, 5, 6);
        String playerNumbers = "134";

        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount += 1;
            } else if (computerNumbers.contains(playerNumber)) {
                ballCount += 1;
            }
        }

        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
    }
}
