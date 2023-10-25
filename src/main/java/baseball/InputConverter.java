package baseball;

import camp.nextstep.edu.missionutils.Console;

abstract class InputConverter<T> {

    protected OutMessage outMessage;

    protected T value;

    public T getValue() throws IllegalArgumentException {
        value = convert(getInput());
        if (!validate()) {
            throw new IllegalArgumentException();
        }

        return value;
    }

    protected String getInput() {
        outMessage.printMsg();
        return Console.readLine();
    }

    protected abstract T convert(String str);

    protected abstract boolean validate();

}