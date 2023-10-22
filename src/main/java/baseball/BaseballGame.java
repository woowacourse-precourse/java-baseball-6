package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballGame {
    private final Map<Integer, Integer> computerNumber = new HashMap<>();
    private Map<Integer, Integer> userNumber = new HashMap<>();
    // 원시 타입 -> 클래스로 묶기
    private int ball = 0;
    private int strike = 0;

    /**
     * 게임 시작
     */
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        run();
    }

    /**
     * 게임 실행 함수 : 컴퓨터 랜덤수 생성 -> 반복 (사용자 입력 -> 값 비교 -> 결과 출력) -> 재시작 여부
     */
    private void run() {
        createComputerNumber();
        do {
            userInput();
        } while (compareValues());
        restart();
    }

    /**
     * 게임 재시작 여부 입력 받는 기능 1또는 2 이외에 값을 입력 시 예외
     */
    private void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reGame = Console.readLine();
        if (reGame.equals("1")) {
            run();
            return;
        }
        if (reGame.equals("2")) {
            return;
        }
        throw new IllegalArgumentException(" 1 또는 2 를 입력해야합니다.");
    }

    /**
     * 컴퓨터 랜덤 수 생성 기능
     */
    private void createComputerNumber() {
        int i = 1;
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.containsValue(randomNumber)) {
                computerNumber.put(i, randomNumber);
                i++;
            }
        }
    }

    /**
     * 사용자 입력 받는 기능 입력 값으로 받는 수에 대한 예외 포함.
     */
    private void userInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이는 3이어야 합니다.");
        }
        if (inputNumber.chars().distinct().count() != inputNumber.length()) {
            throw new IllegalArgumentException("중복된 값이 포함되었습니다.");
        }
        userNumber = IntStream.rangeClosed(1, 3)
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        i -> {
                            char digit = inputNumber.charAt(i - 1);
                            if (digit <= 48 || digit >= 58) {
                                throw new IllegalArgumentException("0 또는 숫자가 아닌 값이 포함되었습니다.");
                            }
                            return Character.getNumericValue(digit);
                        }
                ));
    }

    /**
     * 컴퓨터 랜덤 값과 사용자 입력에 따른 두 숫자값 비교
     *
     * @return printResult() 결과 값 반환
     */
    private boolean compareValues() {
        for (int i = 0; i < 3; i++) {
            // Strike case
            if (userNumber.containsValue(computerNumber.get(i + 1)) && Objects.equals(userNumber.get(i + 1),
                    computerNumber.get(i + 1))) {
                strike++;
            }
            if (userNumber.containsValue(computerNumber.get(i + 1)) && !Objects.equals(userNumber.get(i + 1),
                    computerNumber.get(i + 1))) {
                ball++;
            }
        }
        return printResult();
    }

    /**
     * 사용자 입력 값과 컴퓨터 랜덤 수 간의 비교 결과 출력 함수
     *
     * @return true : 숫자를 맞추기 위해 입력 반복 ,false: 정답인 경우
     */
    private boolean printResult() {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            clearBallData();
            computerNumber.clear();
            userNumber.clear();
            return false;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            clearBallData();
            return true;
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
            clearBallData();
            return true;
        }
        if (ball != 0) {
            System.out.println(ball + "볼 ");
            clearBallData();
            return true;
        }
        System.out.println("낫싱");
        clearBallData();
        return true;
    }

    /**
     * 컴퓨터 랜덤 수와 사용자 입력값 비교 결과 후 ball, strike 초기화
     */
    private void clearBallData() {
        ball = 0;
        strike = 0;
    }


}