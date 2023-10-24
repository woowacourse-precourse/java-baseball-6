package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    //컴퓨터 랜덤값 생성
    public static List<Integer> makeRandom() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //사용자 값 입력
    public static List<Integer> inputUser() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        //예외처리
        //1. 입력값이 3글자가 아닐 때
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
        //2. 숫자가 아닌 경우
        for (int i = 0; i < input.length(); i++) {
            if ('0' > input.charAt(i) && input.charAt(i) > '9') {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
        }
        //3. 중복된 수가 입력됐을 떄
        String[] arr = input.split("");
        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (inputNum.contains(Integer.parseInt(arr[i]))) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
            inputNum.add(Integer.parseInt(arr[i]));
        }
        return inputNum;
    }

    // 컴퓨터값과 입력값 비교
    public static void play() {
        //컴퓨터 랜덤값
        List<Integer> computer = makeRandom();
//        System.out.println("computer = " + computer);

        while (true) {
            int strike = 0;
            int ball = 0;

            //사용자 입력값
            List<Integer> inputNum = inputUser();

            // 값 비교
            for (int i = 0; i < inputNum.size(); i++) {
                for (int j = 0; j < computer.size(); j++) {
                    if (inputNum.get(i) == computer.get(j) && i == j) {
                        strike++;
                    }
                    if (inputNum.get(i) == computer.get(j) && i != j) {
                        ball++;
                    }

                }
            }

            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0) {
                System.out.print("낫싱");
            }
            if (strike == 3) {
                System.out.println();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            System.out.println();

        } //게임 종료

        // 게임 재시작 묻기
        int yesOrNo = replay();
        // 재시작
        if (yesOrNo == 1) { play();}
        // 게임 종료
        if (yesOrNo == 2) {}

    }

    //게임 재시작(1), 종료(2) 입력
    public static int replay() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int user = Integer.parseInt(Console.readLine());

        //예외처리
        //입력값이 1또는 2가 아닐 때
        if (user != 1 && user != 2) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        return user;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        play();

    }
}
