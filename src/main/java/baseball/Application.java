package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

//    public static List<Integer> computerNumber;
//    public static List<Integer> playerNumber;
    public static int strike, ball;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");

        GameStart();
    }

    public static void GameStart() {

        String computerNumber = ComputerSelectNumber();
        System.out.println("컴퓨터 숫자 : " + computerNumber);
        while(true) {
            String playerNumber = PlayerSelectNumber();
            CompareNumber(computerNumber, playerNumber);


            if(strike==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        if(Restart().equals("1")) {
            GameStart();
        } else {
            System.out.println("게임이 종료되었습니다.");
        }
        return;
    }

    public static String Restart() {
        System.out.println("게임을 새로 시작려면 1, 종료하려면 2를 입력하세요.");

        return Console.readLine();
    }

    public static String ComputerSelectNumber() {
        //컴퓨터가 서로 다른 3개의 숫자 생성

//        computerNumber = new ArrayList<>();
        StringBuilder computerNumber = new StringBuilder();
        for(int i=0; i<3; i++) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computerNumber.append(Randoms.pickNumberInRange(1, 9));
//            computerNumber.add(randomNumber);
        }

        return computerNumber.toString();
    }

    public static String PlayerSelectNumber() {
//        playerNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");

//        String playerInputNumber = Console.readLine();
        return Console.readLine();

//        for(int i=0; i<playerInputNumber.length(); i++) {
//            playerNumber.add(playerInputNumber.charAt(i) - '0');
//        }
    }

    public static void CompareNumber(String computerNumber, String playerNumber) {
        strike = 0;
        ball = 0;

        for(int i=0; i<3; i++) {
            if (playerNumber.charAt(i) == computerNumber.charAt(i)) {
                strike++;
            } else if (computerNumber.contains(String.valueOf(playerNumber.charAt(i)))) {
                ball++;
            }
        }

        System.out.println(PrintResult());
    }

    public static String PrintResult() {
        if(ball == 0 && strike == 0) {
            return "낫싱";
        }
        if(ball == 0) {
            return strike + "스트라이크";
        }
        if(strike==0) {
            return ball + "볼";
        }
        return ball + "볼" + strike + "스트라이크";
    }
}
