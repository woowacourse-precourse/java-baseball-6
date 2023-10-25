package player;

import camp.nextstep.edu.missionutils.Console;

public class User implements Player {
    private char[] numbers;

    public User() {
        numbers = new char[SIZE];
    }

    @Override
    public void setNumbers() {
        char[] userNumbers = Console.readLine().toCharArray();

        numbersValidation(userNumbers);
        numbersUniqueValidation(userNumbers);
        numbers = userNumbers;
    }

    public boolean chooseGameEnd() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        String userChoiceInput = Console.readLine();
        endInputStringValidation(userChoiceInput);

        int choice = Integer.parseInt(userChoiceInput);
        endInputNumberValidation(choice);

        if (choice == 1) {
            return false;
        }

        return true;
    }

    public char getNumber(final int index) {
        getNumberValidation(index);

        return numbers[index];
    }

    private void endInputStringValidation(final String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException("user input is too many");
        }
    }

    private void endInputNumberValidation(final int choice) {
        if (choice < 1 || choice > 2) {
            throw new IllegalArgumentException("user input is not appropriate");
        }
    }

    private void numbersValidation(char[] numbersInput) {
        if (numbersInput.length < SIZE) {
            throw new IllegalArgumentException("user input numbers size is smaller");
        }

        if (numbersInput.length > SIZE) {
            throw new IllegalArgumentException("user input numbers size is bigger");
        }

        for (char number : numbersInput) {
            if (number <= '0' || number > '9') {
                throw new IllegalArgumentException("user input is not appropriate");
            }
        }
    }

    private void numbersUniqueValidation(char[] numbersInput) {
        boolean[] alreadyExist = new boolean[10];

        for (char number : numbersInput) {
            number -= '0';

            if (alreadyExist[number]) {
                throw new IllegalArgumentException("input number is not unique");
            }

            alreadyExist[number] = true;
        }
    }

    private void getNumberValidation(final int index) {
        if (index < 0 || index >= SIZE)
            throw new NullPointerException("input does not correspond to random number size");
    }
}
