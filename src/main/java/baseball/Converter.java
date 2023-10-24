package baseball;

public class Converter {

    public static int[] convertednumber(String input) {
        checklength(input);
        return convert(input);
    }


    private static void checklength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static int[] convert(String input) {
        int[] rawinputnumber = new int[3];

        for (int i = 0; i < 3; i++) {
            if (!checknumber(input, i)){
                throw new IllegalArgumentException();
            }
            rawinputnumber[i] = input.charAt(i) - '0';
        }
        checksamenumber(rawinputnumber);
        return rawinputnumber;
    }

    /// 수정 할 것
    private static void checksamenumber(int[] rawinputnumber) {
        if (rawinputnumber[0]==rawinputnumber[1]) {
            throw new IllegalArgumentException();
        }

        if (rawinputnumber[0]==rawinputnumber[2]) {
            throw new IllegalArgumentException();
        }

        if (rawinputnumber[1]==rawinputnumber[2]) {
            throw new IllegalArgumentException();
        }
    }

    private  static boolean checknumber(String input, int i) {
        return ('0' < input.charAt(i) && input.charAt(i) <= '9');
    }

    public static int convertretrynumber(String retryinput) {
        int retrynumber = Integer.parseInt(retryinput);
        checkretry(retrynumber);
        return retrynumber;
    }
    private static void checkretry(int retrynumber) {
        if (retrynumber != 1 && retrynumber != 2) {
            throw new IllegalArgumentException();
        }
    }
}
