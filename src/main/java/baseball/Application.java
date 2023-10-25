package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 재시작 또는 종료 여부를 확인하기 위한 변수
        boolean restartGame = true;

        // 게임 재시작 또는 종료 여부에 따라 반복 실행
        while (restartGame) {
            playGame();
            restartGame = askForRestart();
        }

        System.out.println("게임 종료");
    }

    // 게임을 실행하는 메서드
    private static void playGame() {
        List<Integer> computer = generateRandomNumbers(); // 랜덤 숫자를 발생시키는 메서드를 통해 숫자 생성
        boolean gameIsOver = false; // 3스트라이크가 나올 때까지 반복을 위한 변수 (기본값: false)
        System.out.println("computer숫자 : " + computer.get(0) + computer.get(1) + computer.get(2)); // 컴퓨터가 생성한 숫자를 테스트를 위해 출력
        while (!gameIsOver) { // 3스트라이크가 나올 때까지 반복 (기본값: false)
            List<Integer> userGuess = getUserGuess(); // 사용자 입력값과 컴퓨터 랜덤값 비교를 위해 가져옴.
            String result = calculateResult(computer, userGuess); // 결과 계산
            System.out.println(result); //결과 출력
            if (result.equals("3스트라이크")) { // 3스트라이크면 게임 종료 true 로 변경
                gameIsOver = true;
            }
        }
    }

    // 랜덤 숫자를 생성하는 메서드
    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 사용자로부터 숫자 입력을 받아 리스트로 반환하는 메서드
    private static List<Integer> getUserGuess() {
        System.out.print("숫자를 입력해주세요 : "); // 사용자에게 숫자 입력을 요청
        String input = Console.readLine(); // 사용자로부터 문자열 입력을 받음
        List<Integer> userGuess = convertInputToNumberList(input); // 입력값을 숫자 리스트로 변환
        return userGuess;
    }

    // 사용자 입력 문자열을 숫자 리스트로 변환하는 메서드
    private static List<Integer> convertInputToNumberList(String input) {
        List<Integer> numbers = new ArrayList<>(); // 결과 숫자 리스트를 저장하기 위한 리스트 생성
        for (char digit : input.toCharArray()) {
            int number = Character.getNumericValue(digit); // 문자를 숫자로 변환
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다."); // 유효하지 않은 입력 예외 처리
            }
            numbers.add(number); // 유효한 숫자를 리스트에 추가
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다."); // 3자리가 아닌 경우 예외 처리
        }
        return numbers; // 변환된 숫자 리스트 반환
    }


    // 게임 결과를 계산하고 반환하는 메서드
    private static String calculateResult(List<Integer> computer, List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userGuess.get(i))) {
                strikes++;
            } else if (computer.contains(userGuess.get(i))) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        return createResultString(strikes, balls);
    }

    // 게임 결과를 문자열로 만드는 메서드
    private static String createResultString(int strikes, int balls) {
        StringBuilder result = new StringBuilder();
        if (balls > 0) {
            result.append(balls).append("볼");
        }
        if (strikes > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(strikes).append("스트라이크");
        }
        return result.length() > 0 ? result.toString() : "낫싱";
    }

    // 게임 재시작 또는 종료 여부를 확인하는 메서드
    private static boolean askForRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input = Console.readLine();
        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        } else {
            System.out.println("1 또는 2만 입력 가능합니다. 게임을 종료합니다.");
            System.exit(0);
            return false;  // 도달할 수 없는 코드 (완성을 위해 추가됨)
        }
    }
}
