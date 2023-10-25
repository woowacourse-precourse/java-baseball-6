package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        game(numbers);
    }

    public static void game(List<Integer> numbers) {

        boolean Correct = false;

        while (Correct != true) {
            System.out.print("숫자를 입력해주세요 : ");
            int input = Integer.parseInt(readLine()); //사용자가 입력한 숫자를 저장하는 변수

            int strike = 0; //스트라이크와 볼의 갯수를 세기 위한 변수
            int ball = 0;

            for (int i = 0; i < 3; i++) { //세 자리의 숫자를 비교하기 위한 for문
                if (input % 10 == numbers.get(2 - i)) { //입력한 숫자와 numbers를 비교
                    strike++; //같으면 strike를 1 증가
                } else if (numbers.contains(input % 10)) { //입력한 숫자가 numbers에 포함되어 있는지 비교
                    ball++; //포함되어 있으면 ball을 1 증가
                }
                input /= 10;
            }

            if(strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }else if(strike != 0 && ball != 0){
                System.out.println(ball + "볼 " + strike + "스트라이크 ");
            } else if(strike == 3) {
                Correct = true;
                end();
            } else if(strike != 0){
                System.out.println(strike + "스트라이크");
            } else if(ball != 0){
                System.out.println(ball + "볼");
            }
        }
    }

    public static void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int end = Integer.parseInt(readLine());
        if(end == 1) {
            main(null);
        }
    }
}

