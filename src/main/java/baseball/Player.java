package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    public int getNumber(int computerDigit){

        System.out.print("숫자를 입력해주세요 : ");
        int num= -1;

        num = Integer.parseInt(readLine());
        //3자가 아닐경우 에러 발생
        if(getDigit(num)!=computerDigit)
            throw new IllegalArgumentException();

        return num;
    }

    public int getDigit(int playerNum){
        int digit=0;
        while(playerNum>0){
            if (playerNum/10 >= 0)
                digit++;
            playerNum /= 10;
        }
        //System.out.println("* "+digit);
        return digit;
    }
}
