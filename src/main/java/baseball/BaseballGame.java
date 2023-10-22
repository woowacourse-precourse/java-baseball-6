package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.Message.*;

public class BaseballGame {
    private final List<Integer> solution = new ArrayList<>();

    //객체 1회 생성 = 게임 1회 시작을 의미
    BaseballGame() {
        makeNumber();
        System.out.println(START);

        //System.out.println(solution.get(0) + " " + solution.get(1) + solution.get(2));
    }

    //num이 몇 볼 몇 스트라이크인지를 알려주는 메서드
    public void trial() {
        try {
            //num의 각 숫자가 1부터 9까지 여야하고, 세자리여야한다. 이를 지키지 않으면 IllegalArgumentException이 발생해야한다
            System.out.println(INPUT);
            while (true) {
                String origin = Console.readLine();
                validateInput(origin);
                Integer num = Integer.parseInt(origin);
                Integer ball = checkBall(num);
                Integer strike = checkStrike(num);


                //다 0이면
                if (ball > 0 && strike == 0) System.out.println(ball + BALL);
                else if (strike == 3) {
                    System.out.println(strike + STRIKE);
                    System.out.println(END);
                    String choice = Console.readLine();
                    if (choice.equals("1")) {
                        makeNumber();
                        //System.out.println("신규숫자: " + solution.get(0) + " " + solution.get(1) + solution.get(2));
                        continue;
                    } else if (choice.equals("2")) {
                        return;
                    } else throw new IllegalArgumentException();
                } else if (ball == 0 && strike > 0) System.out.println(strike + STRIKE);
                else if (ball > 0 && strike > 0) System.out.println(ball + BALL + " " + strike + STRIKE);
                else System.out.println(NOTHING);

                System.out.println(INPUT);
            }
        } catch (Exception e) {//try-catch문이 있어야 예외가 잡히고 정상종료됨
            //throw new IllegalArgumentException(); 새롭게 만들어서 던지지 말자
            throw new IllegalArgumentException(e);
            // 원래의 예외를 그대로 던지거나 원인으로 설정하면, 이 정보를 잃지 않고 유지할 수 있습니다.
        }


    }

    private Integer checkBall(Integer num) {
        int userFirstDigit = num / 100;
        int userSecondDigit = (num % 100) / 10;
        int userThirdDigit = num % 10;

        int solutionFirstDigit = solution.get(0);
        int solutionSecondDigit = solution.get(1);
        int solutionThirdDigit = solution.get(2);

        Integer ballCount = 0;

        // 첫 번째 숫자 검사
        if (userFirstDigit == solutionSecondDigit || userFirstDigit == solutionThirdDigit) {
            ballCount++;
        }

        // 두 번째 숫자 검사
        if (userSecondDigit == solutionFirstDigit || userSecondDigit == solutionThirdDigit) {
            ballCount++;
        }

        // 세 번째 숫자 검사
        if (userThirdDigit == solutionFirstDigit || userThirdDigit == solutionSecondDigit) {
            ballCount++;
        }

        return ballCount;

    }

    private Integer checkStrike(Integer num) {
        int userFirstDigit = num / 100;
        int userSecondDigit = (num % 100) / 10;
        int userThirdDigit = num % 10;

        int solutionFirstDigit = solution.get(0);
        int solutionSecondDigit = solution.get(1);
        int solutionThirdDigit = solution.get(2);

        Integer strikeCount = 0;

        if (userFirstDigit == solutionFirstDigit) strikeCount++;
        if (userSecondDigit == solutionSecondDigit) strikeCount++;
        if (userThirdDigit == solutionThirdDigit) strikeCount++;

        return strikeCount;
    }

    private void validateInput(String origin) {
        //System.out.println("입력: "+ origin);
        if (origin.isBlank() || !origin.matches("[0-9]+")) throw new IllegalArgumentException("숫자를 입력 해 주세요.");
        if (origin.length() != 3) throw new IllegalArgumentException("세 자리 숫자를 입력 해 주세요.");
        Integer num = Integer.parseInt(origin);
        if (num == null) {
            throw new IllegalArgumentException("입력은 null 이면 안 됩니다.");
        }

        int firstDigit = num / 100;
        int secondDigit = (num % 100) / 10;
        int thirdDigit = num % 10;

        if (firstDigit < 1 || firstDigit > 9 ||
                secondDigit < 1 || secondDigit > 9 ||
                thirdDigit < 1 || thirdDigit > 9) {
            throw new IllegalArgumentException("각 숫자는 1~9 사이 여야 합니다.");
        }

        if (firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit) {
            throw new IllegalArgumentException("세 숫자는 서로 달라야 합니다.");
        }
    }

    private void makeNumber() {
        solution.clear();
        while (solution.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!solution.contains(randomNumber)) {
                solution.add(randomNumber);
            }
        }
    }

}
