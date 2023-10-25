package baseball.controller;

import baseball.domain.Answer;
import baseball.utils.Setting;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {

        // 게임 시작 메시지 출력
        outputView.printStartGame();

        // 정답 세팅
        Answer answer = new Answer();
        answer.setAnswerNumber();

        // 정답 여부 세팅
        Boolean correct;

        // 게임 시작 (정답일 경우 탈출)
        do {
            // 숫자 입력 메시지 출력 및 입력
            outputView.printInputNumber();
            String clientInputNumber = inputView.readClientInputNumber();

            // 입력 숫자 예외 처리 (자리수가 다른 경우)
            if (clientInputNumber.length() != Setting.NUM_LENGTH)
                outputView.printClientInputNumberException();

            // 입력 숫자 가지고 정답 여부 반환
            correct = answer.isCorrect(clientInputNumber);

        } while(!correct);

        // 재시작 여부 질의
        askRestartGame();
    }

    public void askRestartGame() {

        // 게임 재시작 메시지 출력 및 입력
        outputView.printRestartGame();
        String restartNumber = inputView.readRestartNumber();

        // 1을 입력하였을 경우 재시작
        if (restartNumber.equals("1"))
            startGame();
        // 입력 숫자 예외 처리 (1 또는 2 이외의 숫자 입력)
        else if (!restartNumber.equals("1") && !restartNumber.equals("2"))
            outputView.printRestartNumberException();
    }
}
