package baseball;
import camp.nextstep.edu.missionutils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BufferedReader buf  = new BufferedReader(new InputStreamReader(System.in));
        int keepGoing = 1, strike = 0;
        int tempBall = 0, tempStrike = 0, resultSize;
        List<Integer> strikeIndexes = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(keepGoing == 1){
            // Get Computer Data
            List<Integer> computer = getCompGameData();
//            System.out.println("숫자 야구 게임을 시작합니다. 컴퓨터의 값은 : " + computer);

            while(strike < 3){
                // Get user Data
                List<Integer> user = getUserGameData();
                result = compareData(computer, user);
                resultSize = result.size();
                System.out.println("비교 결과 리스트는 : " + result);
                if(resultSize == 1){
                    tempBall = result.get(resultSize - 1);
                    if(tempBall == 0){
                        System.out.println("낫싱");
                    } else{
                        System.out.println(tempBall + "볼 ");
                    }
                } else if(resultSize > 2){
                    tempBall = result.get(resultSize - 1);
                    tempStrike = result.get(resultSize - 2);
                    for(int i = resultSize - 3; i >= 0; i--){
                        if(!strikeIndexes.contains(result.get(i))){
                            strikeIndexes.add(result.get(i));
                            strike++;
                        }
                    }
                    if(tempBall > 0){
                        System.out.println(tempBall + "볼 " + tempStrike + "스트라이크");
                    } else{
                        System.out.println(tempStrike + "스트라이크");
                    }
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            try {
                keepGoing = Integer.parseInt(buf.readLine());
            } catch (IOException e) {
                System.out.println("입력에 오류가 발생했습니다. 프로그램을 종료합니다.");
                throw new RuntimeException(e);
            }

            if(keepGoing == 1){
                strike = 0;
            } else if(keepGoing == 2){
                return;
            } else{
                System.out.println("값이 유효하지 않습니다. 프로그램을 종료합니다.");
            }
        }
    }

    public static List<Integer> getUserGameData(){
        BufferedReader buf  = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        char[] userStr = "".toCharArray();
        List<Integer> user = new ArrayList<Integer>();
        boolean diffrentNum = false;

        // Check If Input Data has 3 Numbers, and Only Includes Integer
        while (str.length() != 3) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                str = buf.readLine();

                try
                {
                    Integer.parseInt(str);
                }
                catch (NumberFormatException e)
                {
                    str = "-";
                }

                userStr = str.toCharArray();

                // Check If There's Any Same Number
                for(int i = 0; i < str.length() - 1; i++){
                    for(int j = i + 1; j < str.length(); j++){
                        if(userStr[i] == userStr[j]){
                            str = "-";
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("입력에 오류가 발생했습니다. 프로그램을 종료합니다.");
                throw new RuntimeException(e);
            }
        }

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

    /* Return Value
     * [strike location, ... , number of Strikes, number of Balls]
     */
    public static List<Integer> compareData(List<Integer> computer, List<Integer> user){
        List<Integer> ballStrike = new ArrayList<>();
        int ball = 0, strike = 0;

        for(int i = 0; i < user.size(); i++){
            for(int j = 0; j < computer.size(); j++){
                if(user.get(i) == computer.get(j)){
                    if(i == j){
                        strike++;
                        ballStrike.add(i);
                    }else{
                        ball++;
                    }
                }
            }
        }

        if(strike > 0){
            ballStrike.add(strike);
        }
        ballStrike.add(ball);

        return ballStrike;
    }
}