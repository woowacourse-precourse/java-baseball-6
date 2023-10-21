package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        String inputSystem;

        Computer computer = new Computer(); // 컴퓨터 객체 생성
        String randomNumber = computer.generate(); // 컴퓨터 번호 생성

        System.out.println(randomNumber);

        // 본격적으로 시작
        do{
            inputSystem = ""; // 재시작 후에 초기화를 하기 위함

            System.out.print("숫자를 입력해주세요 : ");

            String inputNumber = Console.readLine(); // 1~9 범위 생성, 자리마다 중복되는 값 있는지 확인, 숫자만 입력했는지

            for (int i = 0; i < inputNumber.length(); i++) { // 숫자만 입력했는지 확인
                int num = inputNumber.charAt(i) -'0';
                if(num > 10 || num < 0){
                    throw new IllegalArgumentException("contains except Number");
                }
            }
            for (int i = 0; i < inputNumber.length(); i++) { // 1~9 사이의 범위만 입력했는지 확인
                if(inputNumber.contains("0")){
                    throw new IllegalArgumentException("have to be range 1~9");
                }
            }

            if (inputNumber.length() > 3) { // 3개의 숫자 생성
                throw new IllegalArgumentException("Over the size");
            }

            // 3개의 숫자가 각기 다른 숫자인가. 중복 체크
            // 1. 이중 포문으로 1번이 2번,3번 비교, 2번이 3번 비교해서 판단
            // 2.
            for (int i = 0; i < inputNumber.length()-1; i++) {
                for (int j = i+1; j < inputNumber.length(); j++) {
                    if (inputNumber.charAt(i) == inputNumber.charAt(j)) {
                        throw new IllegalArgumentException("have be duplicated number");
                    }
                }
            }

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
                randomNumber = computer.generate();

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
