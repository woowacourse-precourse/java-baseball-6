package baseball;

import java.util.*;

import static baseball.Computer.genRandomNum;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answerNum = genRandomNum();
        boolean correct = false;
        while(!correct){
            correct = compareNum(answerNum, inputPlayerNum());
        }
    }
    public static List<Integer> inputPlayerNum()  {
        List<Integer> playerNum = new ArrayList<>();
        String[] input = readLine().split((""));

        for(String s: input){
            int temp = Integer.parseInt(s);
            playerNum.add(temp);
        }

        HashSet<Integer> temp = new HashSet<>(playerNum);
        if(temp.size()!=3) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }

        return playerNum;
    }

    public static boolean compareNum(List<Integer> answerNum, List<Integer> playerNum){
        int strike = 0;
        int ball = 0;
        for(int i  = 0; i < 3; i++){
            if(answerNum.get(i).equals(playerNum.get(i))){
                strike++;
                continue;
            }
            if(answerNum.contains(playerNum.get(i))){
                ball++;
            }
        }
        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;

        }if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }

        if(ball > 0) System.out.print(ball + "볼 ");
        if(strike > 0) System.out.print(strike + "스트라이크");
        System.out.println();
        return false;
    }

    public static boolean reset(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(readLine());

        if(input == 1) return true;
        if(input == 2) return false;

        throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");

    }

}
