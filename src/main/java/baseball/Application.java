package baseball;
import camp.nextstep.edu.missionutils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Make Computer Data and Get user Data
        List<Integer> computer = getCompGameData();
        List<Integer> user = getUserGameData();

        //
    }

    public static List<Integer> getUserGameData(){
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        List<Integer> user = new ArrayList<Integer>();

        // Check If Input Data has 3 Numbers, and Only Includes Integer
        while (str.length() != 3) {
            try {
                str = buf.readLine();
                try
                {
                    Integer.parseInt(str);
                }
                catch (NumberFormatException e)
                {
                    str = "-";
                    System.out.println(str);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        char[] userStr = str.toCharArray();

        for(int i = 0; i < 3; i++) {
            user.add(userStr[i] - '0');
        }

        return user;
    }

    public static List<Integer> getCompGameData(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void compareData(){}
}