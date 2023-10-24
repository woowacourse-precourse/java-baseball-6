package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final int LENGTH = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
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

    // 스트라이크 & 볼 계산 로직
    public String checkStrikesOrBall(int[] randomNumbers, int[] playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < LENGTH; i++) {
            if (randomNumbers[i] == playerNumbers[i]) {
                strikes++;
            } else if (checkBall(playerNumbers, randomNumbers[i])) {
                balls++;
            }
        }
        return getResultMessage(strikes, balls);
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

    // ball 계산 메서드 분리
    private boolean checkBall(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    // checkStrikesOrBall 메서드를 기반으로 결과를 출력하는 메서드
    private String getResultMessage(int strikes, int balls) {
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
        for (int i = 0; i < LENGTH; i++) {
            randomNumbers[i] = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        }
        return randomNumbers;
    }

    // 플레이어로 부터 숫자를 압력 받는 메서드
    private int[] getPlayerNumbers() {
        String playerInput = readPlayerInput();
        valInputLength(playerInput);
        int[] playerNumbers = parseInputToNumbers(playerInput);
        valPlayerNumbers(playerNumbers);
        return playerNumbers;
    }

    // 플레이어로부터 값을 입력 받는 메서드
    private String readPlayerInput() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 입력 자릿수 검증 메서드
    private void valInputLength(String playerInput) {
        if (playerInput.length() != LENGTH) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요. 게임 종료");
        }
    }

    // 입력 값 정수형 변환 메서드
    private int[] parseInputToNumbers(String playerInput) {
        int[] playerNumbers = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            char playerNumber = playerInput.charAt(i);
            playerNumbers[i] = Character.getNumericValue(playerNumber);
        }
        return playerNumbers;
    }

    // 범위 외 값 검증 메서드
    private void valPlayerNumbers(int[] playerNumbers) {
        for (int number : playerNumbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("범위밖의 숫자를 입력하였습니다. 게임 종료");
            }
            if (containsDuplicate(playerNumbers)) {
                throw new IllegalArgumentException("중복된 숫자를 입력하였습니다. 게임 종료");
            }
        }
    }

    // 중복 입력 검증 메서드
    private boolean containsDuplicate(int[] playerNumbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : playerNumbers) {
            if (numberSet.contains(number)) {
                return true;
            }
            numberSet.add(number);
        }
        return false;
    }
}