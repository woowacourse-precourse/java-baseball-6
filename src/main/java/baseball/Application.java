package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> randomNumber = new ArrayList<>();
    private static boolean match;
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            match = false;
            createRandomNumber();
            while(!match){
                System.out.print("숫자를 입력해주세요 : ");
                try{
                    int userInp = Integer.parseInt(Console.readLine());

                    if((userInp < 111 || userInp > 999) || checkDuplicate(userInp)){
                        throw new IllegalArgumentException();
                    }

                    compareNumber(userInp);
                }catch (Exception e){
                    throw new IllegalArgumentException();
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            try{
                int userSelect = Integer.parseInt(Console.readLine());

                if(userSelect == 1){
                    continue;
                }else if(userSelect == 2){
                    System.out.println("게임 종료");
                    break;
                }else{
                    throw new IllegalStateException();
                }
            }catch (IllegalStateException e) {
                break;
            }
        }
    }
    static void compareNumber(int userInp){
        int strike = 0, ball = 0;
        for(int i = 2; i >= 0; i--){
            int num = userInp%10;
            userInp /= 10;
            if (randomNumber.get(i).compareTo(num) == 0) {
                strike++;
            }else{
                if(randomNumber.contains(num)){
                    ball++;
                }
            }
        }

        String result = "";
        if(ball > 0){
            result += ball + "볼";
        }

        if(strike > 0){
            if(result.length() > 0){
                result += " ";
            }
            result += strike + "스트라이크";
        }

        if(result == ""){
            result += "낫싱";
        }

        System.out.println(result);

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            match = true;
        }
    }

    private static void createRandomNumber(){
        randomNumber.clear();
        while(randomNumber.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(randomNum)){
                randomNumber.add(randomNum);
            }
        }
    }

    static boolean checkDuplicate(int userInp){
        boolean numCheck[] = new boolean[10];
        int copyInp = userInp;
        for(int i = 0; i < 3; i++){
            int num = copyInp%10;
            copyInp /= 10;

            if(numCheck[num]){
                return true;
            }

            numCheck[num] = true;
        }
        return false;
    }


}
