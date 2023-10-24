package baseball;

public class Comparison {
    private int[] compare(int[] answer, int[] input) {
        int[] result = {0, 0};

        for (int i = 0; i < 3; i++) {
            if (answer[i] == input[i]) {
                result[1]++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (input[i] == answer[j]) {
                        result[0]++;
                    }
                }
            }
        }

        return result;
    }

    public int[] comparison(int[] answer, int[] input) {
        return compare(answer, input);
    }
}
