package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static final int validLength = 3;
    private static final boolean playingGame = true;

    public static boolean isAllDigit(String str){
        // 모두 숫자인지 확인
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isValidLength(String str){
        return str.length() == validLength;
    }
    public static boolean isValidNumber(String str) {
        // 1~9로 이루어졌는지 확인
        if(!str.matches("^[1-9]{3}$")){
            return false;
        }
        // 중복된 숫자 있는지 확인
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args){
        // Randoms.pickNumberInRange(시작, 끝) - 시작 이상, 끝 이하
        // int computeNumber = Randoms.pickNumberInRange(111, 999) -> "게임종료_후_재시작" 에러 발생
        String computeNumber = BaseBall.creatNumber();
        System.out.println(computeNumber);
        System.out.println("숫자 야구 게임을 시작합니다.");
        // Console.readLine()은 String을 입력으로 받음.
        while(playingGame) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = Console.readLine();
//            System.out.print(userNumber);

            if(!isAllDigit(userNumber) || !isValidLength(userNumber) || !isValidNumber(userNumber)){
                throw new IllegalArgumentException();
            }

            int cntBS = GameRule.countBallAndStrike(computeNumber, userNumber);
            int cntS = GameRule.countStrike(computeNumber, userNumber);
            int cntB = cntBS - cntS;

            System.out.printf("cntB %d cntS %d".formatted(cntBS, cntS));
            System.out.println();
            if (cntS == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String reGame = Console.readLine();
                System.out.println(reGame);
                if (reGame.equals("2")) {
//                    playingGame = false; -> "예외_테스트" 에러
                    break;
                }
                else {
                    computeNumber = BaseBall.creatNumber();
                    System.out.println(computeNumber);
                }
            }
            else {
                System.out.print("힌트: ");
                System.out.println(GameRule.hintProvider(cntB, cntS));
            }
        }
        System.out.println("게임이 종료되었습니다.");
    }
}
