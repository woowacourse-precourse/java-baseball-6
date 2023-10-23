package baseball.service;

public class Game {

    public static final int NUMBER_OF_DIGITS = 3;       //자리수
    private static final int START_RANGE = 1;        //랜덤 시작 범위
    private static final int END_RANGE = 9;          //랜덤 끝 범위

    //게임 재시작/종료 flag
    private static final String NEW_GAME_FLAG = "1";
    private static final String EXIT_GAME_FLAG = "2";

    //게임 메시지
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = NUMBER_OF_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE =
            "게임을 새로 시작하려면 " + NEW_GAME_FLAG + ", 종료하려면 " + EXIT_GAME_FLAG + "를 입력하세요.";

}
