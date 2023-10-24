package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private boolean isGameOver = false;

    public static void main(String[] args) {
        Application app = new Application();
        app.startGame();
    }

    // 게임 실행 메서드
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int[] randomNumbers = generateRandomNumbers(); // 게임 시작 시 한 번만 생성

        while (!isGameOver) {
            int[] playerNumbers = getPlayerNumbers();

            String result = checkStrikesOrBall(randomNumbers, playerNumbers);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isGameOver = !askForRestart();

                if (!isGameOver) {
                    randomNumbers = generateRandomNumbers(); // 게임이 재시작되면 새로운 randomNumbers 생성
                }
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

        for (int i = 0; i < 3; i++) {
            if (randomNumbers[i] == playerNumbers[i]) {
                strikes++;
            } else if (containsNumber(playerNumbers, randomNumbers[i])) {
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

    // 난수 생성 및 배열에 저장하는 메서드
    private int[] generateRandomNumbers() {
        int[] randomNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumbers[i] = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumbers;
    }

    // 플레이어로 부터 숫자를 받는 메서드
    private int[] getPlayerNumbers() {
        int[] playerNumbers = new int[3];
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요. 게임 종료");
        }

        for (int i = 0; i < 3; i++) {
            char playerNumber = input.charAt(i);
            if (playerNumber < '1' || playerNumber > '9') {
                throw new IllegalArgumentException("범위밖의 숫자를 입력하였습니다. 게임 종료");
            }

            int numericValue = Character.getNumericValue(playerNumber);

            if (numericValue <= 0) {
                throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다. 게임 종료");
            }
            if (containsNumber(playerNumbers, numericValue)) {
                throw new IllegalArgumentException("중복된 숫자를 입력하였습니다. 게임 종료");
            }

            playerNumbers[i] = Character.getNumericValue(playerNumber);
        }
        return playerNumbers;
    }

    // 플레이어의 중복입력 방지와 ball 계산을 처리
    private boolean containsNumber(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }
}