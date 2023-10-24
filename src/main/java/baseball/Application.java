package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        //게임 시작 문구
        System.out.println("숫자 야구 게임을 시작합니다.");

        //변수
        boolean go = true; //프로그램 종료여부 (false: 종료)
        boolean restart = true; //게임 재시작 (true: 재시작, false: 3스트라이크 달성X -> 다시 예측)
        List<Integer> computer = new ArrayList<>(); //랜덤수 저장할 배열

        //게임 시작
        while (go) {
            // restart == true일 때 난수가 생성된다.
            if (restart) {
                computer.clear(); //배열 초기화
                GameMethod.uniqueRandomNumber(computer); //세자리 난수 생성 후 배열에 저장
                restart = false;
            }

            //사용자에게 3자리 숫자 입력받기
            System.out.print("숫자를 입력해주세요 : ");
            String strInput = Console.readLine();
            Validation.validateNumber(strInput); //입력을 올바르게 했는지 검증

            //입력받은 숫자 배열에 저장
            List<Integer> player = GameMethod.stringToIntArrayList(strInput);

            //스트라이크, 볼 판별
            int[] strikeAndBall = GameMethod.strikeAndBall(player, computer); //[strike수, ball수] 반환
            int strike = strikeAndBall[0];
            int ball = strikeAndBall[1];

            //결과 출력, 3스트라이크인 경우 게임 다시 할건지 입력 받아 처리
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = Validation.isValidKey(Console.readLine()); //1 입력시 restart == true, 2 입력시 restart == false
                go = restart; //2 입력시 go == false가 되어 게임 종료

            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");

            } else if (strike == 0) {
                System.out.println(ball + "볼");

            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");

            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
            //3스트라이크가 아닌 경우 결과만 출력.
            //이 때 restart == false, go == true 이므로 새로 난수를 생성하지 않고 게임 재시작.
        }
    }


}
