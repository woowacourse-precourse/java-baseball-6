package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    //입력받은 값을 예외처리해주는 메서드
    private static void rightNumber(String inputNumber) {

        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력값이 세개가 아닙니다");
        }
        char num1 = inputNumber.charAt(0);
        char num2 = inputNumber.charAt(1);
        char num3 = inputNumber.charAt(2);

        if (num1 == num2 || num2 == num3 || num1 == num3) {
            throw new IllegalArgumentException("입력값이 모두 동일합니다");
        }

        if(num1 == '0' || num2 == '0' || num3 == '0') {
            throw new IllegalArgumentException("입력값에 0이 포함되어 있습니다.");
        }

        if (!Character.isDigit(num1) || !Character.isDigit(num2) || !Character.isDigit(num3)) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }

    }

    //1 ~ 9 사이의 난수 3개를 반환해주는 메서드
    private static List<Integer> getNewRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = getNewRandomNumber();
        boolean gameStart = true;
        while (gameStart) {

        //입력
        System.out.print("숫자를 입력해주세요: ");
        String inputNumber = Console.readLine();

        //입력값 유효성 검사
        rightNumber(inputNumber);

        //초기화 | inputNumber String --> List<Integer>
        List<Integer> inputNumberList = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            int b = Integer.parseInt(String.valueOf(inputNumber.charAt(i)));
            inputNumberList.add(b);
        }

        //비교
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < inputNumberList.size(); j++) {
                int randomNumber = computer.get(i);
                int guessNumber = inputNumberList.get(j);

                if (randomNumber == guessNumber) {
                    if (i == j)
                        strike++;
                    else
                        ball++;
                }
            }
        }

        /*
         * 출력
         * 올라간 strike, ball 값 출력하기
         * */

        // n볼 n스트라이크 일 때
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        // 3스트라이크 = 3개의 숫자를 맞힌경우
        // 재시작 의사를 1, 2로 입력받는다
        // 1또는 2가 입력되지 않았을 경우 오류를 발생시킨다

        else if (strike ==3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String start = Console.readLine();
            if (start.equals("1")) {
                computer = getNewRandomNumber();
            }
            else if (start.equals("2"))
                gameStart = false;
            else
                throw new IllegalArgumentException("입력값이 1또는 2가 아닙니다.");
        }
        // 같은 수가 같은 자리에 n개 있는경우
        else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        // 같은 수가 다른 자리에 n개 있는경우
        else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        // 같은 수가 전혀 없을경우
        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }
}
}

