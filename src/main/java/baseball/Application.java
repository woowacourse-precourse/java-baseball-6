package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = randomNum();
            //System.out.println("answer : " + computer);   //정답

            while (true) {
                int[] answer = checkNum();

                int strike = 0;
                int ball = 0;

                for (int i = 0; i < 3; i++) {
                    if (answer[i] == computer.get(i)) {
                        strike++;
                    } else if (computer.contains(answer[i])) {
                        ball++;
                    }
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    String result = "";

                    if (ball > 0) {
                        result += ball + "볼 ";
                    }
                    if (strike > 0) {
                        result += strike + "스트라이크";
                    }
                    System.out.println(result);
                }
            }
            playAgain = playAgainFunc();

        }
    }

    public static List<Integer> randomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int[] checkNum() {
        int[] answer = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        String inputN = Console.readLine();
        int inputNum = Integer.parseInt(inputN);

        answer[0] = inputNum / 100;
        answer[1] = (inputNum / 10) % 10;
        answer[2] = inputNum % 10;

        if(inputNum < 100 || inputNum > 999){
            throw new IllegalArgumentException("중복된 수를 갖지 않는 3자리 수를 입력해주세요.");
        } else if(answer[0]==answer[1] || answer[1]==answer[2] || answer[2]==answer[0]){
            throw new IllegalArgumentException("중복된 수를 갖지 않는 3자리 수를 입력해주세요.");
        }

        return answer;
    }

    public static boolean playAgainFunc(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String replay = Console.readLine();
        return "1".equals(replay);
    }
}
