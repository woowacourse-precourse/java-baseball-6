package model;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String number;

    public void setUserNumber(){
        this.number = Console.readLine();
    }

    public String getNumber(){
        return number;
    }

}
