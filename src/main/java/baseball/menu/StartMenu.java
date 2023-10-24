package baseball.menu;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.PlayGame.PLAY_END_MESSAGE;
import static baseball.Constant.StartGame.*;
import static baseball.Constant.StartGame.END_MENU;

public class StartMenu {
    private final PlayMenu playMenu;
    public StartMenu(PlayMenu playMenu) {
        this.playMenu = playMenu;
    }

    public void start() {
        String input = null;
        do {
            // 게임 시작
            System.out.println(GAME_START_MESSAGE);
            // 게임 함수로 이동
            playMenu.play();
            // 게임 끝 메시지
            System.out.println(PLAY_END_MESSAGE);
            // 재시작 or 종료
            System.out.println(RESTART_OR_QUIT_MESSAGE);
            input = Console.readLine();
            if(!input.equals(START_MENU) && !input.equals(END_MENU)) throw new IllegalArgumentException(); // 에러 확인
        }while(!input.equals(END_MENU));
    }
}
