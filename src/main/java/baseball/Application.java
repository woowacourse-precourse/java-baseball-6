//미션 - 숫자 야구
package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart(); //숫자야구게임 실행
    }

    public static void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            roop(); //숫자 맞추기 메인

            if (question()){ //게임종료 후 질문
                break;
            }
            //무한루프
        }
    }

    public static void roop(){
        List<Integer> computer = randNum(); //컴퓨터의 랜덤숫자 받기
        while (true) { //루프
            System.out.print("숫자를 입력해주세요 : ");
            String num = new String();

            num = Console.readLine(); //입력받음
            //예외발생 : 경우의 수 3가지
            //try catch를 쓰지않는 이유: test case에서 throwException을 기다리고 있는데, try/catch를 해버리면 알아서 처리가 되어 test가 작동되지 않음.
            if (num.length() != 3) {
                throw new IllegalArgumentException(); //에러를 던져주기만 함 여기서는
            } else if (!isNumber(num)) {
                throw new IllegalArgumentException();
            } else if (isOverlapNumber(num)) {
                throw new IllegalArgumentException();
            }

            Boolean result = compareNumber(num, computer); //숫자 비교 및 검증

            if (!result) {
                break; //정답을 맞추면 루프 종료
            }
        }
    }

    public static boolean question(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String ans = new String();
        try{
            ans = Console.readLine(); //입력받음
            if (ans.equals("2")){
                return true; //종료
            } else if (!ans.equals("1")) {
                throw new IllegalArgumentException();
            } else {
                return false;
            }
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(); //다시 Illeagal~ 예외처리를 보내줘서 testcase에서 동작되게함.
        }
    }

    public static List<Integer> randNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

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
                strike++;
            } else if (comp.contains(String.valueOf(user.charAt(i)))) { //볼 측정
                ball++;
            }
        }

        //결과 출력
        if (strike==3){
            System.out.println(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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

}
