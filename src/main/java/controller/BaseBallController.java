package controller;

import view.Input;
import service.BaseBallService;

import java.util.List;

public class BaseBallController {
    private Input input;
    private BaseBallService service;

    public BaseBallController(Input input, BaseBallService service) {
        this.input = input;
        this.service = service;
    }

    public void startGame() {
        service.generateNumbers();
        do {
            playGame();
        } while (input.isRestart());
    }

    public void playGame() {
        System.out.println("숫자야구 게임을 시작합니다");
        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println("숫자를 입력해주세요");
            int[] userInput = input.getUserInput();
            List<String> result = service.calResult(userInput);


            for (String res : result) {
                System.out.println(res);
            }

            if (result.contains("3스트라이크")) {
                gameFinished = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 그 외의 숫자를 입력하세요.");

            }
        }
    }
}
