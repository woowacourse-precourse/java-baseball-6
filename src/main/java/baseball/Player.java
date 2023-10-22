package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {


    public int getNumber(){

        System.out.print("숫자를 입력해주세요 : ");
        int num= -1;
        try{
            num = Integer.parseInt(readLine());
        }catch(IllegalArgumentException e){
            System.exit(0);
        }
        return num;
    }
}
