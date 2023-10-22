package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    // 게임에 사용되는 3자리 숫자 배열 정의
    private boolean isGameOver = false;

    public static void main(String[] args) {
        Application app = new Application();

        try {
            app.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 게임 실행 메서드
    public void startGame() {
        while (!isGameOver) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            int[] playerNumbers = getPlayerNumbers(); // 플레이어
            int[] randomNumbers = generateRandomNumbers(); // 컴퓨터

            String result = checkStrikesOrBall(randomNumbers, playerNumbers);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isGameOver = !askForRestart(); // 물어보고 재시작 여부를 확인
            }
        }
    }

    // 게임 재시작 여부를 물어보는 메서드
    private boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String response = Console.readLine();

        if (response.equals("1")) {
            return true;

        } else if (response.equals("2")) {
            System.out.println("게임 종료");
            return false;
        } else {
            System.out.println("올바른 입력이 아닙니다. 게임 종료");
            return false; // 게임 종료
        }
    }


    // 스트라이크 & 볼 계산 로직
    public String checkStrikesOrBall(int[] randomNumbers, int[] playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < playerNumbers.length; i++) {
            if (playerNumbers[i] == randomNumbers[i]) {
                strikes++;
            } else if (containsNumber(randomNumbers, playerNumbers[i], i)) {
                balls++;
            }
        }

        if (strikes == 3) {
            return "3스트라이크";
        } else if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            return String.format("%d볼 %d스트라이크", balls, strikes);
        }
    }

    private boolean containsNumber(int[] numbers, int target, int excludeIndex) {
        for (int i = 0; i < numbers.length; i++) {
            if (i != excludeIndex && numbers[i] == target) {
                return true;
            }
        }
        return false;
    }

    // 난수 생성 및 배열에 저장하는 메서드
    private int[] generateRandomNumbers() {
        int[] randomNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumbers[i] = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumbers; // 난수 배열을 반환
    }

    // 플레이어로 부터 숫자를 받는 메서드
    private int[] getPlayerNumbers() {
        int[] playerNumbers = new int[3];
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            System.out.println("3자리 숫자를 다시 입력하세요.");
            return generateRandomNumbers();
        }

        for (int i = 0; i < 3; i++) {
            char playerNumber = input.charAt(i);
            playerNumbers[i] = playerNumber;

        }
        return playerNumbers;
    }
}
