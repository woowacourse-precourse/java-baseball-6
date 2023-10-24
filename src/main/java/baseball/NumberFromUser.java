package baseball;

import camp.nextstep.edu.missionutils.Console;

abstract class NumberFromUser<T> {

    protected OutMessage outMessage;

    protected T value;

    public T getValue() throws IllegalArgumentException {
        final String input = getInputString();
        value = convertToReturnType(input);
        if (!validate()) {
            throw new IllegalArgumentException();
        }

        return value;
    }

    protected String getInputString() {
        outMessage.printMsg();
        return Console.readLine();
    }

    protected abstract T convertToReturnType(String str);

    protected abstract boolean validate();

}