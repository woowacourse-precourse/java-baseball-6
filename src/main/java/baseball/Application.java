package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    // input user number
    public static List<Integer> userInput(){
        // read user input
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user = new ArrayList<>();
        String userString = Console.readLine();
        int userNumber;

        // 입력값의 길이가 3이 아닌 경우
        if (userString.length() != 3)
            throw new IllegalArgumentException();

        // userInput을 정수로 변환
        try{
            userNumber = Integer.parseInt(userString);
            System.out.printf("userNumber: %d \n", userNumber);
        }
        catch (NumberFormatException ex){
            throw new IllegalArgumentException();
        }

        // user 배열에 저장
        for (int i = 0; i<3;i++){
            int num = userString.charAt(i) - '0';
            if (num != 0 && !user.contains(num)){
                user.add(num);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        return user;
    }


    // check computer and user number
    public static int baseball(List<Integer> computer, List<Integer> user){
        int flag = 1, ball = 0, strike = 0;
        for (int i = 0;i <3; i++){
            if (computer.contains(user.get(i))){
                if (Objects.equals(computer.get(i), user.get(i))){
                    strike++;
                }
                else {
                    ball++;
                }
            }
        }

        // 결과 출력
        if (ball != 0){
            System.out.printf("%d볼 ", ball);
        }
        if (strike != 0){
            System.out.printf("%d스트라이크" ,strike);
        }
        if (ball == 0 && strike == 0){
            System.out.print("낫싱");
        }
        System.out.println();

        if (strike != 3){
            flag = 0;
        }
        return flag;
    }


    public static int main(String[] args) {
        String flag;
        do {
            // random number setting
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
//            System.out.print("computer: ");
//            System.out.println(computer);



            int result = 0;
            while (result != 1){
                List<Integer> user = userInput();
//                System.out.print("user input: ");
//                System.out.println(user);

                result = baseball(computer, user);
//                System.out.printf("result: %d\n", result);
            }

            // baseball game done
            System.out.println("3개의 숫자를 모드 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            flag = Console.readLine();

        } while(flag.equals("1"));

        return 0;
    }
}