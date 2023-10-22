package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputView {

    private String inputNumber;
    private List<Integer> userNumberLst = new ArrayList<>();

    public List<Integer> userInput()
    {
        printStartMessage();
        userInputNumber();
        userNumberLst=userInputNumberStringToList(inputNumber);



        return userNumberLst;


    }

    public void printStartMessage()
    {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void userInputNumber()
    {
        Scanner input = new Scanner(System.in);


        inputNumber=input.next();


    }
    public List<Integer> userInputNumberStringToList(String str)
    {
        List<Integer> numLst = new ArrayList<>();


        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);

            numLst.add(ch-'0');

        }
        return numLst;

    }

}
