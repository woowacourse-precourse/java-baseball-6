package baseball;

public class StopInputConverter extends InputConverter<Integer> {

    public StopInputConverter() {
        outMessage = OutMessage.STOP;
    }

    @Override
    protected Integer convert(String input) {
        return Integer.parseInt(input);
    }

    @Override
    protected boolean validate() {
        return value == 1 || value == 2;
    }

}