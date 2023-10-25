package view;

import validator.NumberInputValidator;

public class PlayerNumberInputView {
    NumberInputValidator numberInputValidator = new NumberInputValidator();

    private enum Message {
        INPUT_PLAYER_NUMBER("숫자를 입력해주세요 : ");

        private final String message;

        private Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void receiveNumber() {
        System.out.print(Message.INPUT_PLAYER_NUMBER.message);
        System.out.println(numberInputValidator.validNumber());
    }
}