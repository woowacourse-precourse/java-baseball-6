package baseball;

public class Parser {
    public int[] parseUserInput(String input, int size) {
        checkSize(input, size);
        checkDuplicate(input);
        return getParseInput(input, size);
    }

    private void checkDuplicate(String input) {
        int len = input.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if(input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void checkSize(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    public int[] getParseInput(String input, int size) {
        int[] parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = input.charAt(i) - '0';
        }
        return parseInt;
    }
}
