package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

enum Status {
    START, EXIT, CONTINUE, DONE
}

class Message {
    final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final static String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    final static String NOTHING_MESSAGE = "낫싱";
    final static String BALL_MESSAGE = "볼 ";
    final static String STRIKE_MESSAGE = "스트라이크";
}

class Condition{
    final static char MAX_STRIKES = '3';
    final static int NUM_LENGTH = 3;
    final static int RESTART_CONDITION = 1;
    final static int EXIT_CONDITION = 2;
    final static char MIN_INPUT = '1';
    final static char MAX_INPUT = '9';
}

class Game {
    private static User user = new User();
    private static Com com = new Com();

    public static void run() {
        initGame();
        while (user.checkStatus()) {
            inputRoutine();
            playRoutine();
            endRoutine();
        }
    }

    private static void initGame(){
        user.setStatus(Status.START);
    }

    /**
     * input user's new number
     */
    private static void inputRoutine() {
        user.setInput();
        user.checkInput();
    }

    private static void playRoutine() {
        playGame();
        printResult();
        checkDone();
    }

    private static void playGame() {
        int ballCnt = 0;
        int strikeCnt = 0;
        final String userNum = user.getInput();
        final String comNum = com.getAnswer();

        for (int i = 0; i < Condition.NUM_LENGTH; i++) {
            for (int j = 0; j < Condition.NUM_LENGTH; j++) {
                if (userNum.charAt(i) == comNum.charAt(j) && i == j) {
                    strikeCnt += 1;
                }

                if (userNum.charAt(i) == comNum.charAt(j) && i != j) {
                    ballCnt += 1;
                }
            }
        }

        makeResult(strikeCnt, ballCnt);
    }

    private static void makeResult(int strike_cnt, int ball_cnt) {
        String result = "";
        result += Integer.toString(Condition.NUM_LENGTH - (ball_cnt + strike_cnt));
        result += Integer.toString(ball_cnt);
        result += Integer.toString(strike_cnt);

        user.setResult(result);
    }

    private static void printResult() {
        final String result = user.getResult();
        final int nothing = result.charAt(0) - '0';
        final int ball = result.charAt(1) - '0';
        final int strike = result.charAt(2) - '0';

        if (nothing == Condition.NUM_LENGTH) {
            System.out.print(Message.NOTHING_MESSAGE);
        }
        if (ball != 0) {
            System.out.print(ball + Message.BALL_MESSAGE);
        }
        if (strike != 0) {
            System.out.print(strike + Message.STRIKE_MESSAGE);
        }

        System.out.println("");
    }

    private static void checkDone() {
        char strike = user.getResult().charAt(2);
        if (strike == Condition.MAX_STRIKES) {
            user.setStatus(Status.DONE);
        }
        if (strike != Condition.MAX_STRIKES) {
            user.setStatus(Status.CONTINUE);
        }
    }

    private static void endRoutine() {
        if (user.getStatus() == Status.DONE) {
            doneRoutine();
        }
    }

    private static void doneRoutine() {
        if (user.getStatus() == Status.DONE) {
            System.out.println(Message.WIN_MESSAGE);
            int input = Integer.parseInt(Console.readLine());
            if (input == Condition.RESTART_CONDITION) {
                user.setStatus(Status.START);
                return;
            }

            if (input == Condition.EXIT_CONDITION) {
                user.setStatus(Status.EXIT);
                return;
            }

            throw new IllegalArgumentException("Only input 1 or 2");
        }

    }
}

class User {
    private Status user_status;
    private String user_input;
    private String result;

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }


    public Status getStatus() {
        return user_status;
    }

    public void setStatus(Status status) {
        user_status = status;
    }

    public boolean checkStatus() {
        switch (user_status) {
            case CONTINUE:
                return true;
            case START:
                startRoutine();
                return true;
            case EXIT:
                return false;
        }
        return false;
    }

    private void startRoutine() {
        Com.makeAnswer();
        setStatus(Status.CONTINUE);
    }

    public String getInput() {
        return user_input;
    }

    public void setInput() {
        System.out.print(Message.INPUT_MESSAGE);
        user_input = Console.readLine();
    }

    public void checkInput() {
        HashMap<Character, Boolean> check = new HashMap<>();
        if (user_input.length() != Condition.NUM_LENGTH) {
            throw new IllegalArgumentException("length of input isn't 3");
        }
        for (int i = 0; i < Condition.NUM_LENGTH; i++) {
            char ch = user_input.charAt(i);
            if (ch >= Condition.MIN_INPUT && ch <= Condition.MAX_INPUT && check.get(ch) == null) {
                check.put(ch, true);
                continue;
            }
            throw new IllegalArgumentException("Only Unique number");
        }
    }

}

class Com {
    private static String answer;

    public static void makeAnswer() {
        answer = "";
        while (answer.length() != Condition.NUM_LENGTH) {
            String temp = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (answer.indexOf(temp.charAt(0)) == -1) {
                answer += temp;
            }
        }
    }

    public String getAnswer() {
        return answer;
    }
}

public class Application {

    public static void main(String[] args) {
        System.out.println(Message.START_MESSAGE);
        Game.run();
    }
}
