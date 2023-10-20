package controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputReOrEnd {
    public int inputCoin(){
        String tmp = Console.readLine();
        int coin = Integer.parseInt(tmp);

        return coin;
    }
}
