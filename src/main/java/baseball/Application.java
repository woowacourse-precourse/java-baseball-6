package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true){
            // 난수 발생
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // 사용자 입력 받기
            int result = afterRestart(computer);

            if (result == 2) {
                break;
            }
        }
    }

    public static int afterRestart(List<Integer> com) {
        try {
            while (true){
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                if (userInput.length() != 3) {
                    throw new IllegalArgumentException("입력이 유효하지 않습니다.");
                }

                // 사용자 입력을 정수 리스트로 변환, 볼과 스트라이크 개수 카운트
                int strike = 0;
                int ball = 0;

                List<Integer> userNumbers = new ArrayList<>();
                for (char digitchar : userInput.toCharArray()) {
                    int digit = Character.getNumericValue(digitchar);
                    userNumbers.add(digit);
                    if (com.contains(digit) && com.indexOf(digit) == userNumbers.indexOf(digit)){
                        strike += 1;
                    }
                    else if (com.contains(digit)){
                        ball += 1;
                    }
                }
                // 결과값 출력
                if (strike == com.size()){
                    System.out.println(strike+"스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    return Integer.parseInt(Console.readLine());
                } else if (strike > 0 && ball > 0){
                    System.out.println(ball+"볼 "+strike+"스트라이크");
                } else if (strike > 0){
                    System.out.println(strike+"스트라이크");
                } else if (ball > 0){
                    System.out.println(ball+"볼");
                }
                else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }
            }

        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
