package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int game = 1;
        int userInput;
        int[] userInputArr;
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (game == 1){
            int ball = 0;
            int strike = 0;

            List<Integer> computer = newNumbers();

            while (strike != 3) {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = scanner.nextInt();
                userInputArr = chekcInputNum(userInput);

                // 숫자 비교
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

                // 비교 결과 출력
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
            game = scanner.nextInt();

            // 입력된 값 검증
            if (game != 1 && game != 2) {
                throw new IllegalArgumentException("1 또는 2를 입력해야 합니다..");
            }
        }
    }

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
