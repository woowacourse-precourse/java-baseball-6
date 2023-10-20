package baseball.controller;

import baseball.domain.Baseball;
import baseball.utils.Utils;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    Baseball baseball = new Baseball();

    public void run() {
        List<Integer> generateRandomNumber = baseball.generateRandomNumber();
        OutputView.printStartGame();
        OutputView.printInputNumber();
        String input = InputView.userInput();
        List<Integer> userInput = parsedArrayUserNumber(input);
        baseball.findStrike(generateRandomNumber,userInput);
    }

    private List<Integer> parsedArrayUserNumber(String input) {
        List<Integer> paredArrayNumbers = new ArrayList<>();
        Utils.convertArray(input,paredArrayNumbers);
        return paredArrayNumbers;
    }









}
