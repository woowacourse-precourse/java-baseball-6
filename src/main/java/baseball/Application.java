package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Collectors;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

import baseball.constants.constants;
import baseball.numberGenerator.*;



public class Application {
    public static void main(String[] args) {
        baseballGame baseballgame = new baseballGame();
        baseballgame.playGame();
    }
}
class baseballGame{

    private static boolean checkEndGame(int strikes){ // strikes 가 3 일 경우에 게임을 종료시키는 메서드
        if (strikes == constants.STRIKE_FOR_ENDGAME) {
            return true;
        }
        return false;
    }

    private static int checkStrike(List<Integer> playerInput,List<Integer> cpuInput){ // 스트라이크를 체크
        int strikes = 0;
        for (int i = 0; i < constants.INPUT_LENGTH; i++) {
            if(playerInput.get(i) == cpuInput.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int checkBall(List<Integer> playerInput,List<Integer> cpuInput){ // 볼을 체크
        int balls = 0;
        for (int i = 0; i < constants.INPUT_LENGTH; i++) {
            if (playerInput.get(i) != cpuInput.get(i) && cpuInput.contains(playerInput.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    private static String checkNothing(List<Integer> playerInput,List<Integer> cpuInput){ // 낫싱인지 체크
        int nothingCount = 0;
        String nothing = "낫싱";
        for (int i = 0; i < constants.INPUT_LENGTH; i++) {
            if (cpuInput.contains(playerInput.get(i)) == false) {
                nothingCount++;
            }
        }
        if (nothingCount == 3){
            return nothing;
        }
        return "낫싱 아님";
    }

    private static boolean playGameAgain() {
        boolean check = true;

        while (true) {
            String gameContinue = camp.nextstep.edu.missionutils.Console.readLine();
            if (gameContinue.equals("1")) {
                check = true;
                break;
            } else if (gameContinue.equals("2")) {
                check = false;
                break;
            } else {
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
        return check;
    }


    public static void playGame(){
        int balls;
        int strikes;
        String nothing;
        boolean gameAgainCheck = true;

        System.out.println(constants.START_MESSAGE);
        List<Integer> cpuGameNumber = numberGenerator.getCpuRandomNumber();

        while(gameAgainCheck){ // gameAgainCheck 가 false가 되년 경우엔 게임 종료
            List<Integer> playerGameNumber= numberGenerator.getPlayerNumber();
            strikes = checkStrike(playerGameNumber,cpuGameNumber);
            balls = checkBall(playerGameNumber,cpuGameNumber);
            nothing = checkNothing(playerGameNumber,cpuGameNumber);

            if (nothing.equals("낫싱")){ // 하나도 맞는 경우가 없는 경우
                System.out.println("낫싱");
            }
            if (strikes != 0 && balls == 0){ // 스트라이크만 있는 경우
                System.out.println(strikes + "스트라이크");
            }
            if (strikes == 0 && balls != 0){ // 볼만 있는 경우
                System.out.println(balls + "볼");
            }
            if (strikes != 0 && balls != 0){ // 볼과 스트라이크 모두 있는 경우
                System.out.println(balls + "볼 " + strikes + "스트라이크");
            }
            if (checkEndGame(strikes)){ // 게임이 끝났는지 안끝났는지 확인함. strikes = 3 이면 진입
                System.out.println(constants.END_MESSAGE);
                System.out.println(constants.ASK_CONTINUE);
                gameAgainCheck = playGameAgain(); // 게임을 다시 시작할지 말지 물어봄 1이면 true, 2면 false
                if (gameAgainCheck == false){
                    break;
                }
                cpuGameNumber = numberGenerator.getCpuRandomNumber();
            }
        }
        System.out.println(constants.DECLARE_GAME_END);
    }
}