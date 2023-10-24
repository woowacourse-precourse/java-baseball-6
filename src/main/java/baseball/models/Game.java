package baseball.models;

public class Game {

    private boolean status; // 게임 진행 여부

    public boolean isStatus() {
        return status;
    }

    // 게임 시작하는 메소드
    public void init() {
        this.status = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
