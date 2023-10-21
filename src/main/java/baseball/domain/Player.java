package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String number;

    public Player(){
        this.number = "";
    }
    public void inputNumber(){
        try {
            number = Console.readLine();
            int num = Integer.parseInt(number);
            if(number.length()!=3 || num<123 || num>987){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException = new IllegalArgumentException("잘못입력 게임 종료");
            return;
        }
    }

    public String getNumber(){
        return number;
    }
}
