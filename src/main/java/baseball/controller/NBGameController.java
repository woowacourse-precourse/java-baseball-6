package baseball.controller;

import baseball.model.Computer;
import baseball.model.BaseballCount;
import baseball.model.convertor.NumberTypeConvertor;
import baseball.model.validator.NumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Map;

public class NBGameController {

    private InputView in;
    private OutputView out;
    private NumberValidation numberValidation;
    private NumberTypeConvertor numberTypeConvertor;

    private NBGameController() {
        in = new InputView();
        out = new OutputView();
        numberValidation = new NumberValidation();
        numberTypeConvertor = new NumberTypeConvertor();
        start();
    }

    public static void run() {
        new NBGameController();
    }

    private void start() {
        // 게임 시작 메세지 출력하기
        out.displayStartMessage();

        // 숫자 생성하기
        Computer computer = Computer.generateRandomNumber();
        out.displayList(computer.getComputerNumber());

        int strike = 0;
        // 게임 반복하기
        while (is3Strike(strike)) {
            // 사용자로부터 console 입력 받기
            String user = in.inputStringNumber();

            // 숫자 검증하기
            numberValidation.validateNumber(user);

            // 숫자 타입 변경하기
            List<Integer> userIntList = numberTypeConvertor.toListInteger(user);

            // 숫자 야구 시작하기
            BaseballCount baseballCount = new BaseballCount();
            List<Integer> comIntList = computer.getComputerNumber();
            Map<String, Integer> pitched = baseballCount.pitch(userIntList, comIntList);

            // 결과 출력하기
            out.displayResult(pitched.get("strike"), pitched.get("ball"));

            // update strike
            strike = pitched.get("strike");
        }
        // 게임 종료 메세지 출력하기
        out.displayEndMessage();
    }

    private boolean is3Strike(int strike) {
        return strike != 3;
    }
}
