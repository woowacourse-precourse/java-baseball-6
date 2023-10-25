package baseball.Utils;

public class Converter {
    public int[] convertUserChooseInputToInt(String input) {
        int[] output = new int[3];
        for(int i = 0; i < 3; i++) {
            output[i] = Integer.parseInt(input.substring(i, i + 1));
        }

        return output;
    }


}
