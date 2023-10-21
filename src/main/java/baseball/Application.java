package baseball;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String targetGenerator() {
        String target = "";
        for (int i=0;i<3;i++){
            int t = Randoms.pickNumberInRange(1,9);
            String.valueOf(t);
            target = target + t;
        }
        return target;
    }

    public static void game (String target) {
        Scanner sc = new Scanner(System.in);

        try {
            String player = Console.readLine();
            IllegalArgumentTest(player);
        }
        catch (IllegalArgumentException e){
            System.out.println("비정상적인 숫자가 입력되었으므로 종료 ~~~");

        }
        sc.close();
    }
    public static void IllegalArgumentTest(String playerNumber ) throws IllegalArgumentException{

        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException();
    }
    public static void init() {
        System.out.println("숫자 야구 게임을 시작합니다");
        String target = targetGenerator();
        game(target);
        // baseballgame



    }
    public static void main(String[] args) {
        init();
    }
}
