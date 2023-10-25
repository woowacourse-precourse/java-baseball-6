package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int game =1;
        int uerInput;
        int[] userInputArr;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (game == 1){
            int ball = 0;
            int strike = 0;

            //서로다른 3개의 숫자를 생성
            List<Integer> computer = newNumbers();

            //3스트라이크를 달성하기 전까지 반복
            while (strike != 3) {
                System.out.print("숫자를 입력해주세요 : ");
                uerInput = Integer.parseInt(Console.readLine());
                userInputArr = chekcInputNum(uerInput);

                // 스트라이크와 볼의 개수 구하기
                int number;

                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        number = computer.get(j);
                        if (number == userInputArr[i]) {
                            if (i == j) ++strike;
                            else ++ball;
                        }
                    }
                }

                // 스트라이크와 볼의 개수의 결과 출력
                if (ball > 0) {
                    if (strike > 0) {
                        System.out.println(ball + "볼 " + strike + "스트라이크");
                        ball = 0;
                        strike = 0;
                    } else {
                        System.out.println(ball + "볼");
                        ball = 0;
                    }
                } else if (strike > 0 && strike < 3) {
                    System.out.println(strike + "스트라이크");
                    strike = 0;
                } else if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                }
            }

            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            strike = 0;

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game = Integer.parseInt(Console.readLine());

            // 잘못된 값 예외처리
            if (game != 1 && game != 2) {
                throw new IllegalArgumentException("1 또는 2를 입력해야 합니다..");
            }
        }
    }

    //컴퓨터의 서로 다른 3자리 숫자 생성
    static List<Integer> newNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    //사용자가 입력한 숫자 검증
    static int[] chekcInputNum(int userInput){
        int[] userInputArr = new int[3];

        if (String.valueOf(userInput).length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
        }

        userInputArr[0] = userInput / 100;
        userInputArr[1] = (userInput / 10) % 10;
        userInputArr[2] = userInput % 10;

        if(userInputArr[0] == 0 || userInputArr[1] == 0 || userInputArr[2] == 0){
            throw new IllegalArgumentException("1부터 9까지 서로 다른 수로 이루어진 세 자리의 수를 입력하세요.");
        }

        if (userInputArr[0] == userInputArr[1] || userInputArr[1] == userInputArr[2] || userInputArr[0] == userInputArr[2]) {
            throw new IllegalArgumentException("세 자리 숫자는 서로 다른 숫자여야 합니다.");
        }
        return userInputArr;
    }



}