package baseball;

import java.util.List;

public class ApplicationV2 {

    public void solution() {
        // 1. 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer(); // 상대방(컴퓨터) 객체
        Player player = new Player(); // 플레이어 객체
        List<Integer> computerNumbers = computer.getNumber(); // 상대방(컴퓨터) 랜덤 값 가져오기
        String playerNumber = player.inputNumber(); // 플레이어 숫자 입력

        player.strikeCheck();
    }
}
