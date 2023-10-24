package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class BallGame {
    static List<Integer> computer = new ArrayList<>();
    static boolean ansFlag = true;
    static int restart = 1;
    public void run(){
        restart = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (restart == 1) {
            restart = GameStart();
        }
    }

    public static int GameStart(){
        GenerateNum();
        ansFlag = false;

        while (!ansFlag) {
            ArrayList<Integer> playerNum = InputNum();
            if (check(playerNum.get(0), playerNum.get(1),playerNum.get(2)) == 3) {
                ansFlag = true;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return RestartInputAndCheck();
    }
    public static void GenerateNum(){
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static ArrayList<Integer> InputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumString = Console.readLine();

        return InputCheck(playerNumString);
    }

    public static ArrayList<Integer> InputCheck(String playerNumString){
        ArrayList<Integer> playerNum = new ArrayList<>();

        if (playerNumString.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(playerNumString);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<3; i++){
            int temp = Character.getNumericValue(playerNumString.charAt(i));
            if (playerNum.contains(temp)){
                throw new IllegalArgumentException();
            }
            playerNum.add(temp);
        }
        return playerNum;
    }
    public static int RestartInputAndCheck(){
        String playerChooseString = Console.readLine();
        if (playerChooseString.length() != 1) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(playerChooseString);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        int playerChoose = Character.getNumericValue(playerChooseString.charAt(0));
        if (playerChoose < 1 || playerChoose > 2) throw new IllegalArgumentException();

        return playerChoose;
    }



    public static int check(int first, int second, int third) {
        int ball = 0;
        int strike = 0;

        if (first == computer.get(0)) strike++;
        else if (first == computer.get(1) || first == computer.get(2) ) ball++;

        if (second == computer.get(1)) strike++;
        else if (second == computer.get(0) || second == computer.get(2) ) ball++;

        if (third == computer.get(2)) strike++;
        else if (third == computer.get(1) || third == computer.get(0) ) ball++;

        if (ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
        else if (strike == 0){
            System.out.println(ball+"볼");
        }
        else if (ball == 0){
            System.out.println(strike+"스트라이크");
        }
        else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        return strike;
    }
}
