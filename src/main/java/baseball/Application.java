package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        //게임 시작 문구
        System.out.println("숫자 야구 게임을 시작합니다.");

        //변수
        boolean restart = true; //처음부터 다시 시작할 것인지
        boolean go = true; //프로그램 종료할건가 (false일 때 종료)
        List<Integer> computer = new ArrayList<>();

        //게임 시작
        while (go) {
            if (restart == true) {
                //ArrayList의 각 인덱스에 랜덤 숫자 1개씩 저장
                computer.clear();
                GameMethod.uniqueRandomNumber(computer);
                restart = false;
            }

            //사용자에게 3자리 숫자 입력받기
            System.out.print("숫자를 입력해주세요 : ");
            String beforeInt = Console.readLine();
            Validation.validateNumber(beforeInt); //입력을 올바르게 했는지 검증

            //입력받은 숫자 배열에 저장
            List<Integer> player = GameMethod.stringToIntArrayList(beforeInt);

            //스트라이크, 볼 판별
            int[] strikeAndBall = GameMethod.strikeAndBall(player, computer);
            int strike = strikeAndBall[0];
            int ball = strikeAndBall[1];

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = Validation.isValidKey(Console.readLine());
                go = restart;
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 0){
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }


}
