package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static final String STRIKE = "스트라이크";
    static final String BALL = "볼";
    static final String NOTHING = "낫싱";

    public static void main(String[] args) {

        Application app = new Application();
        app.runGame();
    }

    private void runGame() {
        final int NUM_DIGITS = 3;
        while(true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String random = getComputerNumber(NUM_DIGITS);

            System.out.println("숫자를 입력해주세요 : ");
            String input = guessNumber();

            while(!isAnswer(random, input)) {
                input = Console.readLine();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int option = Integer.parseInt(Console.readLine());
            if(option == 2) break;
        }
    }

    private String getComputerNumber(int NUM_LEN) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < NUM_LEN; i++) {
            sb.append(Randoms.pickNumberInRange(1, 9));
        }
        String random = sb.toString();
        return random;
    }

    private String guessNumber() {
        String input = Console.readLine();

        if (input.length() != 3 || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("값을 잘못 입력하셨습니다.");
        }

        return input;
    }

    private boolean isAnswer(String target, String input) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (target.charAt(i) == input.charAt(i)) {
                strike++;
            } else if (target.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }

        printResult(ball, strike);

        return strike == 3;
    }

    private void printResult(int ball, int strike) {
        if(ball == 0 && strike == 0) System.out.println(NOTHING);
        else if(ball == 3) System.out.println("3" + BALL);
        else if(strike == 3) System.out.println("3" + STRIKE);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(ball)
                    .append(BALL)
                    .append(" ")
                    .append(strike)
                    .append(STRIKE);
            System.out.println(sb);
        }
    }
}