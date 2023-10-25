package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Integer> computer;
    public List<Integer> inputNum;
    public static final int NUMBER_LENGTH = 3;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 9;
    public static final int REPLAY_O = 1;
    public static final int REPLAY_X = 2;

    //컴퓨터 랜덤값 생성
    public List<Integer> makeRandom() {
        computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //사용자 값 입력
    public List<Integer> inputUser() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        //예외처리
        //1. 입력값이 3글자가 아닐 때
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
        //2. 숫자(1~9)가 아닌 경우
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '1' || '9' < input.charAt(i)) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
        }
        //3. 중복된 수가 입력됐을 떄
        String[] arr = input.split("");
        inputNum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (inputNum.contains(Integer.parseInt(arr[i]))) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
            inputNum.add(Integer.parseInt(arr[i]));
        }
        return inputNum;
    }

    //컴퓨터값과 입력값 비교
    public void play() {
        //컴퓨터 랜덤값
        computer = makeRandom();

        while (true) {
            int strike = 0;
            int ball = 0;

            //사용자 입력값
            inputNum = inputUser();

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
            if (strike == NUMBER_LENGTH) {
                System.out.println();
                System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            System.out.println();

        } //게임 종료

        //게임 재시작 묻기(1.재시작, 2.종료)
        int yesOrNo = replay();
        //재시작
        if (yesOrNo == REPLAY_O) {
            play();
        }
        //게임 종료
        if (yesOrNo == REPLAY_X) {
        }

    }

    //게임 재시작 묻기(1.재시작, 2.종료)
    public int replay() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 " + REPLAY_O + ", 종료하려면 " + REPLAY_X + "를 입력하세요.");
        int user = Integer.parseInt(Console.readLine());

        //예외처리
        //입력값이 1또는 2가 아닐 때
        if (user != REPLAY_O && user != REPLAY_X) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        return user;
    }

}
