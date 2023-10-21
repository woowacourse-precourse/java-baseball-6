package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    // 게임에 사용되는 3자리 숫자 배열 정의
    private boolean isGameOver = false;

    public static void main(String[] args) {
        Application app = new Application();
        app.startGame();
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
        String response;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            response = Console.readLine();
        } while (!response.equals("1") && !response.equals("2"));

        return response.equals("1");
    }


    // 스트라이크 & 볼 계산 로직
    public String checkStrikesOrBall(int[] randomNumbers, int[] playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < playerNumbers.length; i++) {
            if (playerNumbers[i] == randomNumbers[i]) {
                strikes++;
            } else if (containsNumber(randomNumbers, playerNumbers[i])) {
                balls++;
            }
        }

        if (strikes == 3) {
            return "3스트라이크";
        } else if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            return String.format("%d스트라이크 %d볼", strikes, balls);
        }
    }

    private boolean containsNumber(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
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
    private void getPlayerNumbers() {
        for (int i = 0; i < 3; i++) {
            System.out.println("숫자를 입력해주세요 : ");
            int playerNumber = Integer.parseInt(Console.readLine());

            if (playerNumber <= 1 || playerNumber > 9) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
            }
            playerNumbers[i] = playerNumber;
        }
    }
}
