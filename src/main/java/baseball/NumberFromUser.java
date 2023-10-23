package baseball;

import camp.nextstep.edu.missionutils.Console;

abstract class NumberFromUser<T> {

    protected T value;

    public T getValue(String msg) throws IllegalArgumentException {
        final String input = getInputString(msg);
        value = convertToReturnType(input);
        if (!validate()) {
            throw new IllegalArgumentException();
        }

        return value;
    }

    protected String getInputString(String msg) {
        System.out.print(msg);
        return Console.readLine();
    }

    protected abstract T convertToReturnType(String str);

    protected abstract boolean validate();

}