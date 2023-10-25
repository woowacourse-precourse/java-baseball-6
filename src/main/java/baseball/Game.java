package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private GameState gameState = GameState.PLAYING;
    private User user;
    private Computer computer;
    private Comparision comparision;
    Game(){
        user = new User();
        computer = new Computer();
        comparision = new Comparision();
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameState == GameState.PLAYING) {
            user.input();
            comparision.compare(user.getUserInput(),computer.getComputerInput());
            comparision.printResult();
            if (comparision.getResult().get(1) == 3) {
                endPoint();
                if (gameState == GameState.RESTART) {
                    init();
                }
            }
        }
    }
    public void endPoint() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String select = Console.readLine();
        switch (select) {
            case "1":
                gameState = GameState.RESTART;
                break;
            case "2":
                gameState = GameState.EXIT;
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

    public void exit() {
        gameState = GameState.EXIT;
    }

    public void init() {
        computer.renewDigit();
        comparision = new Comparision();
        gameState = GameState.PLAYING;
    }
}
