//미션 - 숫자 야구
package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static boolean isNumber(String n){
        try{
            Integer.parseInt(n);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isOverlapNumber(String n){
        List<String> nList = Arrays.asList(n.split(""));
        Set<String> numSet = new HashSet<>(nList);
        return numSet.size() != nList.size();
    }

    public static Boolean compareNumber(String user, List<Integer> computer){
        int strike = 0;
        int ball = 0;

        String comp = "";

        for (int digit : computer){
            comp += digit;
        }
        
        for (int i = 0; i < 3; i++){
            if (user.charAt(i) == comp.charAt(i)){  //스트라이크 측정
                strike+=1;
            } else if (comp.contains(String.valueOf(user.charAt(i)))) { //볼 측정
                ball+=1;
            }
        }

        //결과 출력
        if (strike==3){
            System.out.println(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다!");
            return false;
        } else if (ball>0 && strike>0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return true;
        } else if (strike>0) {
            System.out.println(strike + "스트라이크");
            return true;
        } else if (ball>0) {
            System.out.println(ball + "볼");
            return true;
        } else{
            System.out.println("낫싱");
            return true;
        }
    }

    public static void main(String[] args){
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while (true){
            while (true) { //루프
                try {
                    System.out.println("숫자를 입력해주세요 : ");
                    String num = Console.readLine(); //입력받음
                    //예외발생
                    if (num.length() != 3) {
                        throw new IllegalArgumentException();
                    } else if (!isNumber(num)) {
                        throw new IllegalArgumentException();
                    } else if (isOverlapNumber(num)) {
                        throw new IllegalArgumentException();
                    }

                    Boolean result = compareNumber(num, computer);

                    if (!result) {
                        break;
                    }

                } catch (IllegalArgumentException e) {
                    break;
                }
            }
            System.out.println("게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String ans = Console.readLine(); //입력받음
            if (ans.equals("2")){
                break; //종료
            }
            //무한루프
        }
    }
}
