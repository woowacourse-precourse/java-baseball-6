package baseball.view;


import camp.nextstep.edu.missionutils.Console;

//TODO: 추후삭제

import java.util.Scanner;


public class InputView {
    public int inputPlayerNumber(){
        try{
            Scanner in = new Scanner(System.in); // Scanner 객체 생성

            String playerString = in.nextLine();//Console.readLine();
            int playerNumber = Integer.parseInt(playerString);
            return playerNumber;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("입력한 값이 정수가 아닙니다.");
        }


    }

    public int inputChoiceNumber(){
        try{
            Scanner in = new Scanner(System.in); // Scanner 객체 생성

            String playerString = in.nextLine();//Console.readLine();
            int playerNumber = Integer.parseInt(playerString);

            return this.validChoiceNumber(playerNumber);


        }catch(NumberFormatException e){
            throw new IllegalArgumentException("입력한 값이 정수가 아닙니다.");
        }


    }

    public int validChoiceNumber(int inputNumber){
        if(String.valueOf(inputNumber).length()!=1){
            throw new IllegalArgumentException("입력한 숫자가 1자릿수가 아닙니다.");
        }

        if(inputNumber!=1&&inputNumber!=2){
            throw new IllegalArgumentException("입력한 숫자가 1 또는 2가 아닙니다.");
        }

        return inputNumber;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPlayerNumber();
        inputView.inputChoiceNumber();


    }
}
