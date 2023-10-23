package baseball.controller;

import baseball.utils.StringUtils;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ViewController {

    private final InputView inputView;

    private final OutputView outputView;

    public ViewController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printGameStart() {
        outputView.printGameStart();
    }

    public void printInputMessage() {
        outputView.printInputMessage();
    }

    public void printResultMessage(int[] score) {
        outputView.printResultMessage(score[0], score[1]);
    }

    public void printFinishMessage() {
        outputView.printFinishMessage();
    }

    private String getUserNumber() {
        printInputMessage();
        return inputView.getUserNumber();
    }

    public int[] getUserNumberArray() {
        return StringUtils.parseStringToIntArray(getUserNumber());
    }

    public int[] getComputerNumberArray() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public boolean getResumeOption() {
        outputView.printResumeMessage();
        return inputView.getResumeOption().equals("1");
    }

}
