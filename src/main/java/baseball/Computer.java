package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int number1;
    private int number2;
    private int number3;
    private boolean isStarted;

    private void setNumber1() {
        number1 = Randoms.pickNumberInRange(1, 9);
    }

    private void setNumber2() {
        number2 = Randoms.pickNumberInRange(1, 9);
    }

    private void setNumber3() {
        number3 = Randoms.pickNumberInRange(1, 9);
    }


    //게임 시작 - 1에서 9까지 서로 다른 임의의 수 3개를 선택하는 기능
    public void startGame() {
        isStarted = true;
        setNumber1();
        setNumber2();
        setNumber3();
        System.out.println("숫자 야구 게임을 시작합니다.");
//        getAnswer();
    }

    public void getAnswer() {
        System.out.printf("정답 미리 보기 : %d%d%d%n", number1, number2, number3);
    }

    public boolean getIsStarted() {
        return isStarted;
    }


    // 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException후 애플리케이션은 종료
    public List<Integer> checkAnswer(String input) {
        checkLength(input);
        char digit1 = input.charAt(0);
        char digit2 = input.charAt(1);
        char digit3 = input.charAt(2);
        checkIsNumber(digit1, digit2, digit3);
        int num1 = Character.getNumericValue(digit1);
        int num2 = Character.getNumericValue(digit2);
        int num3 = Character.getNumericValue(digit3);
        checkValidNumber(num1);
        checkValidNumber(num2);
        checkValidNumber(num3);
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(num1);
        numbers.add(num2);
        numbers.add(num3);
        return numbers;
    }

    // 유효한 입력 길이인지 확인
    private void checkLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    // 입력값이 숫자인지 확인
    private void checkIsNumber(char digit1, char digit2, char digit3) {
        if (!Character.isDigit(digit1) | !Character.isDigit(digit2) | !Character.isDigit(digit3)) {
            throw new IllegalArgumentException();
        }
    }

    // 유효한 숫자 범위인지 확인
    private boolean checkValidNumber(int num) {
        if (num >= 1 && num <= 9) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 숫자에 대한 결과(스트라이크,볼,낫싱,정답)를 출력하는 기능
    public void getResponse(List<Integer> numbers) {
        int num1 = numbers.get(0);
        int num2 = numbers.get(1);
        int num3 = numbers.get(2);
        if (num1 == number1 && num2 == number2 && num3 == number3) {
            restartGame();
            return;
        }
        int strike = 0;
        int ball = 0;
        if (num1 == number1) {
            strike += 1;
        }
        if (num2 == number2) {
            strike += 1;
        }
        if (num3 == number3) {
            strike += 1;
        }
        if (num1 == number2 | num1 == number3) {
            ball += 1;
        }
        if (num2 == number1 | num2 == number3) {
            ball += 1;
        }
        if (num3 == number1 | num3 == number2) {
            ball += 1;
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball != 0 && strike == 0) {
            System.out.printf("%d볼%n", ball);
        } else if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크%n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
        }
    }

    // 게임 재시작
    private void restartGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            startGame();
        } else if (input.equals("2")) {
            isStarted = false;
            Console.close();
        } else {
            throw new IllegalArgumentException();
        }
    }


}
