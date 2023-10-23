package baseball;

public class User {

    private int[] inputNum = null;

    public int[] setInputNum(String input) {
        inputNum = new int[input.length()];

        for(int i = 0; i < input.length(); i++) {
            inputNum[i] = input.charAt(i) - '0';
        }

        return getInputNum();
    }

    public int[] getInputNum() {
        int[] response = new int[inputNum.length];
        System.arraycopy(inputNum, 0, response, 0, inputNum.length);

        return response;
    }


}
