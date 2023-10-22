package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int[] targetGenerator() {

        int[] computer = new int[3];

        for (int i=0;i<3;i++) {
            int t = Randoms.pickNumberInRange(1, 9);
            if ( i == 0) {
                computer[0] = t;
            }
            else {
                while (t == computer[i-1]) {
                    t = Randoms.pickNumberInRange(1, 9);
                }
                computer[i] = t;
            }

        }

        return computer;
    }
    public static boolean intConvertable(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void IllegalArgumentTest(String playerNumber )  throws IllegalArgumentException{

        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            int number = Integer.parseInt(playerNumber);
            if (number < 100 || number > 999) {
                throw new IllegalArgumentException();
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    public static int[] numberFormatting(String player) {
        int number = Integer.parseInt(player);
        int n1, n2, n3;
        n1 = number/100;
        n2 = number%100/10;
        n3 = number%10;

        int[] result = {n1, n2, n3};

        return result;
    }
    public static String resultIntoString(int ball, int strike) {
        String totalResult ="";


        if (ball == 0) {
            if (strike == 0) {
                totalResult = "낫싱";
            }
            else {
                totalResult = strike + "스트라이크";
            }
        }
        else {

            if (strike == 0) {
                totalResult = ball + "볼";
            }
            else {
                totalResult = ball + "볼" + " " + strike + "스트라이크";
            }
        }


        return totalResult;
    }


    public static Object[] ruleChecker(int[] playerNumber, int[] targetNumber) {
        int ball = 0;
        int strike = 0;
        int code = 8005;
        String gameResult = "";

        for (int i=0;i<3;i++) {
            int n = playerNumber[i];
                if ( n == targetNumber[0] || n == targetNumber[1] || n == targetNumber[2]) {
                    if (n == targetNumber[i]) {
                        strike += 1;
                    }
                    else {
                        ball += 1;
                    }
                }

            }

            // gameresult
            gameResult = resultIntoString(ball, strike);

            if (strike == 3 && ball == 0) {
                code = 8000;
            }
            return new Object[] { gameResult, code};
        }

    public static int game (int[] target) {
        System.out.print("숫자를 입력해주세요 : ");
        String player = Console.readLine();
        try {
           IllegalArgumentTest(player);

        }
        catch (IllegalArgumentException e){
            System.out.println("게임 종료");
            throw new IllegalArgumentException();

        };

        // formatting


        int[] playerNumber = numberFormatting(player);


        // checking time according to base ball game rules
        Object[] playerResult = ruleChecker(playerNumber, target);

        String gameResult = (String) playerResult[0];
        int gameCode = (int) playerResult[1];

        System.out.println(gameResult);

        return gameCode;

    }

    public static void init() {

        int[] target = targetGenerator(); // first target intialization
        int initCode ;
        while (true ) {
            initCode = game(target);

            if (initCode == 8000) {
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String playerCode = Console.readLine();
                try {
                    int number = Integer.parseInt(playerCode);
                    if (number != 1 && number != 2) {
                        throw new IllegalArgumentException();
                    }

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }

                int restartCode = Integer.parseInt(playerCode);
                if (restartCode == 1) {
                    target = targetGenerator(); // second target initialization
                }
                else {
                    return;
                }
            }
        }

    }
    public static void main(String[] args){
            System.out.println("숫자 야구 게임을 시작합니다");

            init();

        }
}
