package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Scanner sc = new Scanner(System.in); // 숫자를 입력받기 위한 Scanner 선언

        System.out.println("숫자 야구 게임을 시작합니다.");

        // 무한루프 반복문을 사용하고 while문 최상단에서 computer 요소를 다시 할당함으로서 재시작 했을 때 임의의 수 재생성
        List<Integer> computer = new ArrayList<>();
        while (true) {
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1,
                        9);  // computer ArrayList에 1~9까지의 수들 중 임의로 하나를 선정하여 randomNumber 변수에 저장했던 값을 add()
                if (!computer.contains(randomNumber)) { // computer ArrayList에 이미 앞에서 add() 해준 요소가 포함되어 있지 않다는 조건
                    computer.add(
                            randomNumber); // 즉 첫번째 요소는 무조건 add()가 실행되고(아무요소도 존재 x), 두번째 요소부터는 조건문의 true 조건에 맞지 않는 경우(요소 중복)가 발생할 수 있음
                }
            }

            // 사용자로 부터 입력받은 3자리 수를 자릿수별로 저장할 ArrayList를 생성하고 add()하여 요소 추가
            List<Integer> number = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            int guess = sc.nextInt(); // 사용자로부터 숫자를 입력받아 guess 변수에 저장
            number.add(guess / 100); // 백의 자리 number ArrayList에 add()
            number.add((guess % 100) / 10); // 십의 자리 number ArrayList에 add()
            number.add(guess % 10); // 일의 자리 number ArrayList에 add()

            // 3자리수 미만 or 3자리수 초과할 경우 IllegalArgumentException() 함수로 던져서 예외처리
            if (guess < 100 || guess > 999) {
                throw new IllegalArgumentException();
            }

            // 볼과 스트라이크 횟수를 저장할 strike와 ball 변수 선언 및 로직 구현
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < number.size(); i++) {
                if (number.get(i)
                        .equals(computer.get(i))) { // computer ArrayList와 number ArrayList의 i번째 요소를 비교했을 때 동일할 경우
                    strike++; // strike 변수 1 증가
                } else if (computer.contains(number.get(
                        i))) { // 그게 아니라(서로의 i번째 요소가 동일하지 않고) computer ArrayList 요소에 number의 i번째 요소가 포함되어 있을 경우
                    ball++; // ball 변수 1 증가
                }
            }

            // strike만 존재, ball만 존재, strike와 ball 둘다 존재, strike와 ball 둘다 존재 X, 3 strike 로직 구현 및 3 strike의 경우 재시작 여부를 물어보는 로직 구현
            if (strike < 3 && strike > 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            }
            if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            }
            if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");

            }
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int what = sc.nextInt(); // 재시작 여부를 저장할 변수를 선언하고 사용자로 부터 입력받음
                if (what == 2) { // 입력받은 값이 2일 경우
                    break; // break를 시켜 while문을 벗어나서 게임종료
                } else if (what == 1) { // 입력받은 값이 1일 경우
                    computer.clear(); // computer ArrayList에 저장했던 요소를 모두 비움
                }
            }
        }
    }
}