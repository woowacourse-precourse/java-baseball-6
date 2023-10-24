package baseball;

public class Validation {

    public void exception(String[] number) {

        if (number.length != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < number.length; i++) {
            if (number[i] == "0") throw new IllegalArgumentException();
            for (int j = i + 1; j < number.length; j++) {
                if (number[i].equals(number[j])) throw new IllegalArgumentException();
            }
        }

    }

}
