package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        String inputSystem;

        Computer computer = new Computer(); // 컴퓨터 객체 생성
        String randomNumber = computer.generateRandom(); // 컴퓨터 번호 생성

        User user = new User(); // 사용자 객체 생성

        System.out.println(randomNumber);

        // 본격적으로 시작
        do{
            user.reset(); // 사용자 입력값 초기화
            inputSystem = ""; // 재시작 후에 초기화를 하기 위함

            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = user.generateInput();

            /**
             * 스트라이크 판정 로직 -> 사용자 번호를 기준으로 컴퓨터 번호와 비교하여 스트라이크 판정
             * 첫번째 번호로 처음, 두번째 세번째 비교. 
             */
            int strike = 0; // 스트라이크 저장 변수
            int ball = 0; // 볼 저장 변수
            String judge = "";

            for (int i = 0; i < inputNumber.length(); i++) {
                for (int j = 0; j < randomNumber.length(); j++) {
                    if(inputNumber.charAt(i) == randomNumber.charAt(j) && i == j) { // 스트라이크 증가
                        strike++;
                    } else if (inputNumber.charAt(i) == randomNumber.charAt(j)) { // 볼 증가
                        ball++;
                    }
                }
            }

            if (strike != 0 && ball != 0) { // N 스트라이크, N 볼
                judge = ball + "볼 " + strike + "스트라이크";
            }
            if (strike != 0 && ball == 0) { // N 스트라이크, 노 볼
                judge = strike + "스트라이크";
            }
            if (strike == 0 && ball != 0) { // 노 스트라이크, N 볼
                judge = ball + "볼";
            }
            if (strike == 0 && ball == 0) { // 노 스트라이크, 노 볼
                judge = "낫싱";
            }
            System.out.println(judge);

            /**
             * 3스트라이크 체크
             */

            if (strike == 3) { // 3스트라이크 인 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); // 게임 종료 알림
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                randomNumber ="";
                inputSystem = Console.readLine();
            }

            /**
             * 게임을 종료할 것인지, 재시작 할 것인지 입력
             */

            if (inputSystem.equals("1")) { // 재시작
                computer.reset(); // 리셋
                randomNumber = computer.generateRandom();

            }

        }while(!inputSystem.equals("2"));
    }
}
/**
 * 1. 컴퓨터 난수 생성 객체
 * 2. 사용자 난수 생성 객체
 * --> 1,2번에서 겹치는 부분이 있음. 검증부분에서 결이 같음.
 * 3. 알림문 출력 객체
 * 4. 스트라이크 객체
 */
