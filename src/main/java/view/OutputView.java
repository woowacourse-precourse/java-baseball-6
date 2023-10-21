package view;

/**
 * packageName    : view
 * fileName       : OutputView
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class OutputView {

    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameEnd(){
        System.out.println(GAME_END_MESSAGE);
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
