package baseball;

public class StartNumberFromUser extends NumberFromUser<Integer> {

    @Override
    protected Integer convertToReturnType(String input) {
        return Integer.parseInt(input);
    }

    @Override
    protected boolean validate() {
        return value == 1 || value == 2;
    }

}