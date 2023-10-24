package baseball.Game;

// 구체적으로 숫자야구 게임을 진행하기 위한 class

import baseball.Computer.Computer;
import baseball.Player.Player;

public class Game {

    private final Computer computer;
    private final Player player;

    // computer instance와 player instance 생성
    public Game() {

        this.computer = new Computer();
        this.player = new Player();
    }

    // 숫자야구 게임 결과 계산을 실행하는 method
    public void showResult() {

        player.playing(this.computer);
    }

    // 숫자야구 게임의 정답을 맞췄을 시 restart를 물어보는 method
    public Boolean askRestart() {

        return player.checkRestart();
    }
}
