package baseball.dto;

/**
 * 사용자의 게임 정보를 저장할 클래스
 */
public class Player {
    /**
     * 사용자가 입력한 세자리 수
     */
    private String input = "";
    /**
     * 각 자리의 숫자와 위치를 저장 하기 위한 배열. 배열의 index 1~9는 뽑힐 숫자의 목록. 배열의 값은 뽑힌 숫자의 자리. 0:사용 되지 않음 1:백의 자리 2:십의 자리 3:일의 자리
     */
    private int[] playerNumberBall;
    /**
     * 게임이 끝난 후, 재시작 여부
     */
    private String condition = "";

    public Player() {
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int[] getPlayerNumberBall() {
        return playerNumberBall;
    }

    public void setPlayerNumberBall(int[] playerNumberBall) {
        this.playerNumberBall = playerNumberBall;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
