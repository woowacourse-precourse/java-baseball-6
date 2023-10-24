package baseball.users;

import camp.nextstep.edu.missionutils.Console;

public class Person extends User {
    private int start, end, count;

    public Person() {
        this(1, 9, 3);
    }

    public Person(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    @Override
    public void setInningNumbers() {
        String input = Console.readLine().strip();
        checkValidation(input);
        for (int i = 0; i < count; i++) {
            addInningNumbers(input.charAt(i) - '0');
        }
    }

    private void checkValidation(String input) {
        if (input.length() != count) {
            throw new IllegalArgumentException("Not Valid Baseball Input.");
        }
        for (int i = 0; i < count; i++) {
            int number = input.charAt(i) - '0';
            if (number < start || number > end
                    || input.indexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException("Not Valid Baseball Input.");
            }
        }
    }
}
