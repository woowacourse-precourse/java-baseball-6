package baseball;

import java.util.List;

public class Messages{
    public static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    public static final String USER_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String SELECT_MODE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String SUCCESS = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String FAIL = "낫싱";
    public static final String NOT_THREE_DIGIT = "세 자리 수를 입력해주세요.";
    public static final String INVALID_NUMBER_INPUT = "입력값은 1에서 9까지 서로 다른 숫자로 이루어져야 합니다.";
    public static final String INVALID_NUMBER_FORMAT = "올바른 숫자 형식이 아닙니다.";
    public static String STRIKE_AND_BALL(List<Integer> result){
        StringBuilder sb = new StringBuilder();
        if(result.get(0) != 0 && result.get(1) != 0)
            sb.append(result.get(1)).append("볼 ").append(result.get(0)).append("스트라이크");
        else if (result.get(0) == 0)
            sb.append(result.get(1)).append("볼");
        else
            sb.append(result.get(0)).append("스트라이크");

        return sb.toString();
    }

}