package baseball.domain;

import java.util.List;

public class Opponent {

    private final NumberBaseBall numberBaseBall;
    private final RandomNumberPicker randomNumberPicker;
    private final InputOutputHandler inputOutputHandler;
    private final Me me;

    public Opponent(
            NumberBaseBall numberBaseBall,
            RandomNumberPicker randomNumberPicker,
            InputOutputHandler inputOutputHandler,
            Me me) {
        this.numberBaseBall = numberBaseBall;
        this.randomNumberPicker = randomNumberPicker;
        this.inputOutputHandler = inputOutputHandler;
        this.me = me;
    }

    public void startGame(int numberLength) {
        // 랜덤한 서로다른 숫자 생성
        List<Integer> answer = randomNumberPicker.generateDistinctNumbers(numberLength);

        boolean isContinuing = true;

        while (isContinuing) {
            // 정답 맞추기 시작
            inputOutputHandler.printText("숫자를 입력해주세요 : ");
            List<Integer> guessAnswer = me.guessAnswer(numberLength);

            //추측한 정답에 대한 결과
            String guessResult = numberBaseBall.verifyGuess(answer, guessAnswer);

            inputOutputHandler.printlnText(guessResult);

            //결과가 정답인지 확인
            if(numberBaseBall.isAnswer(guessResult)) isContinuing = false;
        }

        inputOutputHandler.printlnText("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputNumber = inputOutputHandler.inputOneNumber();

        if(inputNumber == 1) startGame(numberLength);

        return;
    }
}
