package exception;

public class MyException {

    public void varlidateInputNumbers(String input) {
        varlidateRange(input);
        varlidataNumber(input);
    }

    public void varlidateInputOrder(String input) {
        if(input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("the order is only 1 and 2");
    }

    private void varlidateRange(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException("the input range is 3");
        }
    }

    private void varlidataNumber(String input) {
        char[] inputArr = input.toCharArray();
        boolean[] numberFlag = new boolean[10];
        for(char val : inputArr) {
            int number = val - '0';
            if(number < 1 || number > 9) {
                throw new IllegalArgumentException("only numbers between 1 and 9 can be input");
            }
            if(numberFlag[number]) {
                throw new IllegalArgumentException("Numbers cannot be duplicated");
            }
            numberFlag[number] = true;
        }
    }

}
