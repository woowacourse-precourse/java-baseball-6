package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            playGame();
        } while (restartGame());
    }

    private static void playGame() {
        List<Integer> computerNumbers = Computer.generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        String playerNumbers;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumbers = Console.readLine();
            validPlayerNumbers(playerNumbers);
        } while (compareNumber(computerNumbers, playerNumbers));
    }

    private static void validPlayerNumbers(String playerNumbers) {
        if (playerNumbers.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리이어야 합니다.");
        }

        char[] charNumbers = playerNumbers.toCharArray();
        Set<Character> uniqueCharNumbers = new HashSet<>();
        for (char charNumber : charNumbers) {
            if (charNumber < '1' || charNumber > '9') {
                throw new IllegalArgumentException("각 자리 숫자는 1에서 9 사이의 정수이어야 합니다.");
            }
            if (uniqueCharNumbers.contains(charNumber)) {
                throw new IllegalArgumentException("각 자리 숫자는 서로 달라야 합니다.");
            }
            uniqueCharNumbers.add(charNumber);
        }
    }

    private static boolean compareNumber(List<Integer> computerNumbers, String playerNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = computerNumbers.get(i);
            if (playerNumber == computerNumber) {
                strikeCount += 1;
            }
            if (playerNumber != computerNumber && computerNumbers.contains(playerNumber)) {
                ballCount += 1;
            }
        }

        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }

        if(strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    private static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerDecision = Console.readLine();
        if (playerDecision.equals("1")) {
            return true;
        }
        if (playerDecision.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("입력은 1 또는 2이어야 합니다.");
    }
}