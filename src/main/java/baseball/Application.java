package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    //컴퓨터 랜덤값 생성 함수(매개변수x, 리턴값 ArrayList<Integer>)
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

    //사용자 입력값 받는 함수(매개변수x, 리턴값 List<Integer>)
    public static List<Integer> inputUser() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        //예외처리
        //1. 입력값이 3글자가 아닐 때
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        //2. 숫자가 아닌 경우(아스키코드로 0~9가 아닌 것)
        for (int i = 0; i < input.length(); i++) {
            if ('0' > input.charAt(i) && input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
        //3. 중복된 수가 입력됐을 떄
        String[] arr = input.split("");
        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (inputNum.contains(Integer.parseInt(arr[i]))) {
                throw new IllegalArgumentException();
            }
            inputNum.add(Integer.parseInt(arr[i]));
        }
        return inputNum;
    }

    // 입력값과 컴퓨터값 비교
    // (매개변수(ArrayList<Integer>inputNum, ArrayList<Integer>computer))
    // 리턴값 void
    public static void play() {
        //컴퓨터 랜덤값
        List<Integer> computer = makeRandom();
        System.out.println("computer = " + computer);

        while (true) {
            // 3 스트라이크가 되면 종료
            int strike = 0;
            int ball = 0;

            //사용자 입력값
            List<Integer> inputNum = inputUser();

            for (int i = 0; i < inputNum.size(); i++) {
                for (int j = 0; j < computer.size(); j++) {
                    if (inputNum.get(i) == computer.get(j) && i == j) {
                        strike++;
                    }
                    if (inputNum.get(i) == computer.get(j) && i != j) {
                        ball++;
                    }

                }
            } // 값 비교 완료

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

        } //while

        int yesOrNo = replay();
        if (yesOrNo == 1) { //재시작
            play();
        }
        if (yesOrNo == 2) {//게임종료
            //코드X
            //if를 1과 2가 아닐때 예외처리날리면 될듯
        }

    }

    //게임 재시작(1), 종료(2) 입력 받는 함수
    public static int replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int user = Integer.parseInt(Console.readLine());

        //예외처리
        //입력값이 1,2가 아니면 다 예외
        if (user != 1 && user != 2) {
            throw new IllegalArgumentException();
        }

        return user;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        //예외발생 테스트
        play();

//        try{
//            play();
//        }catch (IllegalArgumentException e){
//            System.out.println("IllegalArgumentException 예외 발생");
//        }

    }
}
