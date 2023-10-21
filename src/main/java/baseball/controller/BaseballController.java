package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {

    private static List<Integer> computer = new ArrayList<>();
    private View view = new View();
    private BaseballService baseballService = new BaseballService();

    //게임 컨트롤
    public void startGame() {
        view.startGameMessage();
        do {
            createComputerNumber();
            playGame();
            deleteComputerNumber();
        } while (view.inputRestartNumber());
    }

    //게임 실행
    public void playGame() {
        int cntStrike, cntBall;
        String number;
        while(true) {
            number = view.inputNumber();
            cntStrike = baseballService.checkStrike(number, computer);
            cntBall = baseballService.checkBall(number, computer);
            view.printResult(cntStrike, cntBall);
            if (cntStrike == 3) {
                view.printCorrect();
                break;
            }
        }
    }

    //computer 번호 생성
    public void createComputerNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    //computer 번호 삭제
    public void deleteComputerNumber() {
        computer.clear();
    }

}