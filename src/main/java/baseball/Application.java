package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Application {
    public static void main(String[] args) {

        List<Integer> userArray = new ArrayList<>();    // 유저가 입력한 숫자 상태 배열
        List<Integer> computerArray;                    // 컴퓨터의 숫자 상태 배열

        // 컴퓨터가 랜덤한 숫자를 선택
        computerArray =
                Randoms.pickUniqueNumbersInRange(1, 9, 3);

        boolean isCorrect = true;       // 유저와 컴퓨터의 숫자 배열 일치 상태 변수
        int strike = 0;
        int ball = 0;

        System.out.println(computerArray);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            // 입력 받은 그대로 리스트 생성
            String[] inputList = input.split(" ");

            // 입력된 값이 3개인지 확인
            if (inputList.length != 3) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }

            // 입력된 값이 int 형식인지 판단
            for (String value : inputList) {
                Integer.parseInt(value);
            }

            // 배열 내부에 중복된 값이 있는지 확인
            Set<String> set = new HashSet<>();
            for (String item : inputList) {
                if (!set.add(item)) {
                    throw new IllegalArgumentException("잘못된 입력 형식입니다.");
                }
            }

            // 입력된 값이 유효한 범위의 값인지 확인
            for (String value : inputList) {
                if (Integer.parseInt(value) > 9 || Integer.parseInt(value) < 0) {
                    throw new IllegalArgumentException("잘못된 입력 형식입니다.");
                }
            }

            // 유저의 숫자 상태 int 배열 생성
            for (String value : inputList) {
                userArray.add(Integer.parseInt(value));
            }

            // 볼 스트라이크 갯수 파악
            for (int i = 0; i < 3; i++) {
                if (computerArray.get(i).equals(userArray.get(i))) {
                    strike++;
                } else if (computerArray.contains(userArray.get(i))) {
                    ball++;
                }
            }

            // 조건에 따라 게임 진행
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                // 종료 단계 입력받기
                String restartValue = Console.readLine();

                // 입력 값에 따라 수행
                if (restartValue.equals("1"))
                    ;
                else if (restartValue.equals("2")) {
                    break;
                } else {
                    throw new IllegalArgumentException("잘못된 입력 형식입니다.");
                }
            } else {
                System.out.printf("%d볼 %d스트라이크", ball, strike);
            }

            userArray.clear();
            strike = 0;
            ball = 0;
        }
    }
}
