package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    static List<Integer> setRandomValue(){
        List<Integer> computer = new ArrayList<>();


        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    static void startGame(){
        boolean exit=true;
        boolean restart=true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(exit){
            if(restart) {
                computer = setRandomValue();
                restart=false;
            }
            System.out.println(computer);
            String input=getUserInput();
            validateInput(input);
            setUser(input);
            boolean answer=printHint();
            if(answer){
                restart=restartGame(answer);
                if(!restart) exit=false;
            }

            user.clear();
        }
    }
    static List<Integer> computer;
    static List<Integer> user=new ArrayList<>();

    static String getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    static void validateInput(String input){
        if(input == null){
            throw new IllegalArgumentException();
        }

        if(input.length()!=3){
            throw new IllegalArgumentException();
        }

        Set<Character> set=new HashSet<>();
        for(int i=0; i<input.length(); i++){
            set.add(input.charAt(i));
        }
        if(set.size()!=input.length()){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException();
        }
    }

    static void setUser(String input){
        for(int i=0; i<input.length(); i++){
            int value=(int)input.charAt(i)-'0';
            user.add(value);
        }
    }
    static boolean printHint(){
        int strike=0, ball=0;

        for(int idx=0; idx<user.size(); idx++){
            int value=user.get(idx);
            if(computer.contains(value)){
                if(computer.indexOf(value)==idx) strike++;
                else ball++;
            }
        }

        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        else{
            if(strike==3){
                System.out.println(strike+"스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            else{
                if(ball>0 && strike>0) System.out.println(ball+"볼 "+strike+"스트라이크");
                else if(ball>0) System.out.println(ball+"볼");
                else if(strike>0) System.out.println(strike+"스트라이크");
            }
        }
        return false;
    }

    static boolean restartGame(boolean answer){
        if(!answer) return true;
        else{
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String command = Console.readLine();
            int restart=(int)command.charAt(0)-'0';
            if(restart==1) return true;
            else return false;
        }
    }


    public static void main(String[] args){
        // TODO: 프로그램
        startGame();
    }


}
