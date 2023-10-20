package baseball;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private static final int BALL_LENGTH = 3;
    private static final String FOUL_BALL = "0";
    private static final String RESTART_FLAG = "1";
    private static final String EXIT_FLAG = "2";

    public String inputBall(String input){
        String balls = getPlayerInput(input);
        isInputNull(balls);
        checkBallValidation(balls);
        return balls;
    }

    public boolean conformGameRestart(String input){
        String flag = getPlayerInput(input);
        isInputNull(flag);
        checkFlagValidation(flag);
        return isRestartFlag(flag);
    }

    // TODO player의 입력을 받는 메소드로 변경 필요
    private String getPlayerInput(String playerInput){
        return playerInput;
    }

    private void isInputNull(String input){
        if (input == null){
            throw new IllegalArgumentException();
        }
    }

    private void checkBallValidation(String balls){
        if (balls.length() != BALL_LENGTH || balls.contains(FOUL_BALL) || hasDuplicateBalls(balls)){
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateBalls(String balls) {
        Set<Character> ballSet = new HashSet<>();
        for (char ball : balls.toCharArray()) {
            ballSet.add(ball);
        }
        return balls.length() != ballSet.size();
    }

    private void checkFlagValidation(String flag){
        if (!flag.equals(RESTART_FLAG) && !flag.equals(EXIT_FLAG)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isRestartFlag(String flag){
        if (flag.equals(RESTART_FLAG)){
            return true;
        }
        return false;
    }
}
