package player;

import camp.nextstep.edu.missionutils.Console;

public class User implements Player {
    private char[] numbers;

    //todo: number 초기화 고려
    public User() {
        numbers = new char[3];
    }

    public boolean chooseGameEnd() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        String userChoiceInput=Console.readLine();
        endInputStringValidation(userChoiceInput);

        int choice = Integer.parseInt(userChoiceInput);
        endInputNumberValidation(choice);

        if (choice == 1)
            return false;

        return true;
    }

    private void endInputStringValidation(String userInput){
        if(userInput.length()!=1)
            throw new IllegalArgumentException("user input is too many");
    }

    private void endInputNumberValidation(int choice){
        if(choice<1 || choice>2)
            throw new IllegalArgumentException("user input is not appropriate");
    }


    @Override
    public void setNumber() {
        char[] userNumbers=Console.readLine().toCharArray();

        numberValidation(userNumbers);
        numbers=userNumbers;
    }

    private void numberValidation(char[] numbersInput){
        if(numbersInput.length!=3)
            throw new IllegalArgumentException("user input number size is not appropriate");

        for(char number:numbersInput){
            if(number<='0' || number>'9')
                throw new IllegalArgumentException("user input is not appropriate");
        }
    }

    //todo: private으로 접근할 순 없을까?
    public char getNumber(int index) {
        return numbers[index];
    }
}
