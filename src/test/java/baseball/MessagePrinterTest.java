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

    @Test
    @DisplayName("스트라이크와 볼 모두 존재할 경우 스트라이크와 볼 모두 출력한다.")
    void test3() {
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> computerNumbers = List.of(3, 5, 6);
        String playerNumbers = "325";

        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount += 1;
            } else if (computerNumbers.contains(playerNumber)) {
                ballCount += 1;
            }
        }

        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    @Test
    @DisplayName("스트라이크와 볼 모두 존재하지 않을 경우 낫싱 힌트를 출력한다.")
    void test4() {
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> computerNumbers = List.of(1, 2, 3);
        String playerNumbers = "456";

        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount += 1;
            } else if (computerNumbers.contains(playerNumber)) {
                ballCount += 1;
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }

    @Test
    @DisplayName("3스트라이크가 아닐 경우 플레이어에게 새로운 입력을 요구한다.")
    void test5() {
        int strikeCount = 0;
        List<Integer> computerNumbers = List.of(1, 2, 3);
        String playerNumbers = "456";

        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount += 1;
            }
        }

        if(strikeCount != 3) {
            System.out.print("숫자를 입력해주세요 : ");
        }
    }

    @Test
    @DisplayName("3스트라이크일 경우 플레이어에게 재시작 여부를 묻는다.")
    void test6() {
        int strikeCount = 0;
        List<Integer> computerNumbers = List.of(1, 2, 3);
        String playerNumbers = "123";

        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount += 1;
            }
        }

        if(strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
