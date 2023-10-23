package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class BaseballGame {
    private final ComputerNumber computerNumber;
    private final UserNumber userNumber;
    private final Count strike;
    private final Count ball;

    public BaseballGame() {
        this.computerNumber = new ComputerNumber();
        this.userNumber = new UserNumber();
        this.strike = new Count();
        this.ball = new Count();
    }

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
        computerNumber.createComputerNumber();
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
     * 사용자 입력 받는 기능 입력 값으로 받는 수에 대한 예외 포함.
     */
    private void userInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        sizeValidate(inputNumber);
        duplicateValidate(inputNumber);
        userNumber.inputUserNumber(inputNumber);
    }

    private void duplicateValidate(String inputNumber) {
        if (inputNumber.chars().distinct().count() != inputNumber.length()) {
            throw new IllegalArgumentException("중복된 값이 포함되었습니다.");
        }
    }

    private void sizeValidate(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이는 3이어야 합니다.");
        }
    }

    /**
     * 컴퓨터 랜덤 값과 사용자 입력에 따른 두 숫자값 비교
     *
     * @return printResult() 결과 값 반환
     */
    private boolean compareValues() {
        for (int i = 0; i < 3; i++) {
            // Strike case
            if (userNumber.getValue().containsValue(computerNumber.getValue().get(i + 1)) && Objects.equals(
                    userNumber.getValue().get(i + 1),
                    computerNumber.getValue().get(i + 1))) {
                strike.addValue();
            }
            // ball case
            if (userNumber.getValue().containsValue(computerNumber.getValue().get(i + 1)) && !Objects.equals(
                    userNumber.getValue().get(i + 1),
                    computerNumber.getValue().get(i + 1))) {
                ball.addValue();
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
        // 볼, 스트라이크 혼합 경우
        if (ball.getValue() != 0 && strike.getValue() != 0) {
            System.out.println(ball.getValue() + "볼 " + strike.getValue() + "스트라이크");
        }
        // 스트라이크만 있을 경우
        if (ball.getValue() == 0 && strike.getValue() != 0) {
            System.out.println(strike.getValue() + "스트라이크");
            // 모두 맞췄을 때
            if (strike.getValue() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                clearBallData();
                clearNumberData();
                return false;
            }
        }
        // 볼만 있을 경우
        if (ball.getValue() != 0 && strike.getValue() == 0) {
            System.out.println(ball.getValue() + "볼 ");
        }
        // 낫씽일 경우
        if (ball.getValue() == 0 && strike.getValue() == 0) {
            System.out.println("낫싱");
        }
        clearBallData();
        return true;
    }

    /**
     * 랜덤 수 및 사용자 입력 값 clear
     */
    private void clearNumberData() {
        computerNumber.getValue().clear();
        userNumber.getValue().clear();
    }

    /**
     * 컴퓨터 랜덤 수와 사용자 입력값 비교 결과 후 ball, strike 초기화
     */
    private void clearBallData() {
        ball.setValue(0);
        strike.setValue(0);
    }

}