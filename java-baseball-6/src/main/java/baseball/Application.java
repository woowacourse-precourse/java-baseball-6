package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
class gameSetting{

    List<Integer> comNumList;
    List<Integer> userNum;
    Integer strike;
    Integer ball;

    gameSetting(){
        comMadeNumber();
    }
    void comMadeNumber(){
        comNumList = new ArrayList<>();
        for (int i = 0; i < 3;){
            int num = Randoms.pickNumberInRange(1,9);
            if (!comNumList.contains(num)){
                comNumList.add(num);
                i++;
            }
        }
    }

    void gamePlay(){
        System.out.print("숫자를 입력해주세요 : ");
        String userTyping = Console.readLine();
        this.userNum = makeList(userTyping);
        InException();
        compareNum();
        System.out.println(compareResult());

    }

    List<Integer> makeList(String userIn){
        String[] arrayInput = userIn.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userIn.length(); i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }

    void  InException() {
        if (userNum.size() != 3) {
            throw new IllegalArgumentException("올바른 수가 아닙니다.");
        }
        if (userNum.contains(0)) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
        for (int i = 0; i < userNum.size(); i++) {
            if (Collections.frequency(userNum, userNum.get(i)) != 1) {
                throw new IllegalArgumentException("중복수");
            }
        }
    }


    void compareNum(){
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (comNumList.indexOf(userNum.get(i)) == i){
                strike++;
                continue;
            }   if (comNumList.contains(userNum.get(i))){
                ball++;
            }
        }
    }

    String compareResult(){
        if (ball !=0 && strike !=0){
            return (ball + "볼" + " " + strike + "스트라이크");
        }   if (ball == 0 && strike !=0){
            return (strike + "스트라이크");
        }   if (ball !=0 && strike ==0){
            return (ball + "볼");
        }   return ("낫싱");
    }

    boolean endCheck(){
        if (strike != null && strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
            String respone = Console.readLine();
            if (respone.equals("1")){
                comMadeNumber();
                return true;
            }   if (respone.equals("2")){
                return false;
            }
        }   return true;

    }


}
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        gameSetting test = new gameSetting();
        while (test.endCheck()){
            test.gamePlay();
        }
    }
}




