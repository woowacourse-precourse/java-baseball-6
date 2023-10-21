package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static int strike, ball;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");

        try {
            GameStart();
        } catch(IllegalArgumentException e) {
            return;
        }
    }

    public static void GameStart() {

        try {
            List<Integer> computerNumber = ComputerSelectNumber();
            System.out.println("컴퓨터 숫자 : " + computerNumber);
            ExceptionList.validNumbers(computerNumber);
            while(true) {

                List<Integer> playerNumber = PlayerSelectNumber();
                ExceptionList.validNumbers(playerNumber);
                CompareNumber(computerNumber, playerNumber);

                if(strike==3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            int reStartNumber = ReStart();
            ExceptionList.validReStartInputNumber(reStartNumber);
            if(reStartNumber == 1) {
                GameStart();
            } else {
                System.out.println("게임이 종료되었습니다.");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ReStart() {
        System.out.println("게임을 새로 시작려면 1, 종료하려면 2를 입력하세요.");

        int reStartNumber = Integer.parseInt(Console.readLine());
        ExceptionList.validReStartInputNumber(reStartNumber);

        if(reStartNumber == 1) {
            GameStart();
        } else {
            System.out.println("게임이 종료되었습니다.");
        }
    }

    public static List<Integer> ComputerSelectNumber() {

        List<Integer> computer = new ArrayList<>();

        while(computer.size()<3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

                if(!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }

        }
        return computer;
    }

    public static List<Integer> PlayerSelectNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");

        String player = Console.readLine().replaceAll(" ", "");

        for(int i=0; i<player.length(); i++) {
            playerNumber.add(player.charAt(i) - '0');
        }

        return playerNumber;
    }

    public static void CompareNumber(List<Integer> computerNumber, List<Integer> playerNumber) {
        strike = 0;
        ball = 0;

        for(int i=0; i<3; i++) {
            if (playerNumber.get(i) == computerNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
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
