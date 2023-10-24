package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntUnaryOperator;

public class Application {

    // 컴퓨터의 숫자를 담을 List
    static List<Integer> computer;

    public static void main(String[] args)  {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int ball = 0;
        int strike = 0;
        boolean flag = true;

        // 컴퓨터 랜덤 숫자 발생하는 메소드
        makeComputerNumber();

        // 숫자 야구 게임 시작
        while(flag) {

            // 숫자 입력
            System.out.println("숫자를 입력해주세요 : ");
            input = scanner.nextLine();
            
            // 3글자인지 중복된 것은 없는지 체크 
            if(input.length() != 3 && check()) {
                throw new IllegalArgumentException();
            }

            // ball과 strike 개수 카운트
            ball = 0;
            strike = 0;
            for(int i = 0; i < input.length(); i++) {
                int number = Character.getNumericValue(input.charAt(i));
                if (computer.get(i) == number) {
                    strike += 1;
                }
                else if (computer.contains(number)) {
                    ball += 1;
                }
            }

            // 메세지 출력
            String message = "";
            if(ball > 0) {
                message = message + ball + "볼 ";
            }
            if(strike > 0) {
                message = message + strike + "스트라이크";
            }
            if(message.equals("")) {
                message = "낫싱";
            }
            System.out.println(message);

            // 정답을 맞췄을 경우 이어 할지 끝낼지 확인
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int continueFlag = Integer.parseInt(scanner.nextLine());

                if(continueFlag == 1 || continueFlag == 2) {
                    // 1 : 이어 할 경우 새로운 랜덤 숫자 생성
                    if(continueFlag == 1) {
                        makeComputerNumber();
                    }
                    // 2 : 종료할 경우 게임 종료 메세지 출력 후 종료
                    if(continueFlag == 2) {
                        flag = false;
                        System.out.println("게임 종료");
                    }
                }
                // 1과 2가 아닐 때 예외 처리
                else {
                    throw new IllegalArgumentException();
                }
            }
        }


    }

    // 1~9 숫자 중 중복 여부 검사 메소드
    public static boolean check() {
        Set<Integer> set = new HashSet<>();
        for(int data : computer) {
            set.add(data);
        }
        if(set.size() == 3) {
            return true;
        }
        else {
            return false;
        }
    }

    // 컴퓨터 랜덤 숫자 생성 메소드
    public static void makeComputerNumber() {
        computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
