package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private boolean running;
    private final Computer computer;
    private final Human human;

    public BaseballGame(){
        running = true;
        computer = new Computer();
        human = new Human();
    }

    // 게임 시작
    public void start(){

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.chooseRandomValues();
        while(running){
            run();
        }

        // 게임 종료 or 재시작 선택
        isRestart();
    }

    // 게임 실행 중
    public void run(){
        human.chooseValues();
        int strike = computer.compare(human.getHuman());
        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            running = false;
        }
    }

    // 게임 재시작
    public void isRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        running = human.isRestart();
        if(running){
            start();
        }
    }
}
