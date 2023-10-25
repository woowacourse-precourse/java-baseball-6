package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    /**
     * 랜덤한 3자리 숫자를 생성하는 함수
     */
    List<Integer> comRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    /**
     * 사용자 입력 검증 함수
     */
    void validateInput(String inputNum) {
        //중복된 숫자 검사
        for (int i = 0; i < inputNum.length(); i++) {
            char num1 = inputNum.charAt(i);
            for (int j = i + 1; j < inputNum.length(); j++) {
                if (num1 == inputNum.charAt(j)) {
                    throw new IllegalArgumentException("중복된 수가 존재합니다.");
                }
            }
        }
        // 3자리 수 검사
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }

        // 숫자를 입력했는지 검사
        try {
            int number = Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

    }

    /**
     * 숫자 비교 함수
     */
    int compareNumbers(String inputNum, List<Integer> randomNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < inputNum.length(); i++) {
            int userNum = Integer.parseInt(String.valueOf(inputNum.charAt(i)));
            if (randomNumber.get(i).equals(userNum)) {
                strike++;
            } else if (randomNumber.contains(userNum)) {
                ball++;
            }
        }

        // 힌트 출력
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return strike;
        } else {
            System.out.println((ball > 0 ? ball + "볼 " : "") + (strike > 0 ? strike + "스트라이크" : ""));
        }
        return 0;
    }


    public static void main(String[] args) {
        Application game = new Application();
        String restartOrEnd = "1";
        //System.out.println(randomNumber);
        while (restartOrEnd.equals("1")) {  // 1이면 재시작 2이면 종료
            List<Integer> randomNumber = game.comRandomNumber(); //랜덤 숫자 생성
            int result = 0;
            while (!(result == 3)) { // 스트라이크가 3개 아닐때
                System.out.print("숫자를 입력해주세요 : ");
                String inputNum = Console.readLine();
                //System.out.println(inputNum);
                game.validateInput(inputNum); // 입력 값 검증
                result = game.compareNumbers(inputNum, randomNumber); // 숫자 비교 및 결과
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            restartOrEnd = Console.readLine();
            if (!restartOrEnd.equals("1") && !restartOrEnd.equals("2")) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }
        }

    }
}