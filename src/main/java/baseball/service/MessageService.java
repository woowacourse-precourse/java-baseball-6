package baseball.service;

import baseball.constant.MessageConstant;

public class MessageService {
    public void printStartMessage() {
        System.out.println(MessageConstant.GAME_START_MESSAGE);
    }

    public void printUserInputNumberMessage() {
        System.out.println(MessageConstant.INPUT_MESSAGE);
    }
}
