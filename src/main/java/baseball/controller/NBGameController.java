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
    public void start() {
        InputView in = new InputView();
        OutputView out = new OutputView();
        // 게임 시작 메세지 출력하기
        out.displayStartMessage();

        // 숫자 생성하기
        Computer computer = Computer.generateRandomNumber();
        out.displayList(computer.getComputerNumber());

        // 사용자로부터 console 입력 받기
        String user = in.inputStringNumber();

        // 숫자 검증하기
        NumberValidation numberValidation = new NumberValidation();
        numberValidation.validateNumber(user);

        // 숫자 타입 변경하기
        NumberTypeConvertor numberTypeConvertor = new NumberTypeConvertor();
        List<Integer> userIntList = numberTypeConvertor.toListInteger(user);

        // 숫자 야구 시작하기
        BaseballCount baseballCount = new BaseballCount();
        List<Integer> comIntList = computer.getComputerNumber();
        Map<String, Integer> pitched = baseballCount.pitch(userIntList, comIntList);

        // 결과 출력하기
        out.displayResult(pitched.get("strike"), pitched.get("ball"));
    }
}
