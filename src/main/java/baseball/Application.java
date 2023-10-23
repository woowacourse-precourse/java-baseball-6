package baseball;

import baseball.menu.PlayMenu;
import baseball.menu.StartMenu;

public class Application {
    public static void main(String[] args) {
        Application ap = new Application();
        ap.start();
    }
    // 프로젝트 시작
    public void start() {
        PlayMenu playMenu = new PlayMenu();
        StartMenu startMenu = new StartMenu(playMenu);
        startMenu.start();
    }
}
