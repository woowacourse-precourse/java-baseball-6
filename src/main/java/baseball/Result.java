package baseball;

public class Result {

    protected static boolean calculateResult(String randomNumber, String userNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {

            char temp = userNumber.charAt(i);

            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    strike += checkSameValue(randomNumber.charAt(j), temp);
                } else {
                    ball += checkSameValue(randomNumber.charAt(j), temp);
                }
            }
        }

        return printResult(ball, strike);
    }

    private static int checkSameValue(char a, char b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    private static boolean printResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
            if (strike == 3) {
                System.out.println();
                return true;
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
        return false;
    }
}
