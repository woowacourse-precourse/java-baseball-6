package baseball;

import java.util.List;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNumber computer = new ComputerNumber();
        Startgame first = new Startgame();
        Compare compare = new Compare();
        Regame regame = new Regame();

        boolean again = true ;

        while(again) {
            List<Integer> conum = computer.ComputerNumber();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.Classification(conum, first.playernum());
                System.out.println(result);
            }
            again = regame.regame();
        }
    }
}
