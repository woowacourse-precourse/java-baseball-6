package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean redo = false;
        do{
            Bot bot = new Bot();
            bot.generateRandomNumber(bot.botNumbers);
            //System.out.println(java.util.Arrays.toString(bot.botNumbers));
            do{
                bot.getAnswer(bot.userNumbers);
            } while(bot.checkAnswer(bot.botNumbers, bot.userNumbers));
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if(Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine()) == 1){
                redo = true;
            }
            else
                redo = false;
        } while(redo);
        System.out.println("게임 종료");
    }
}
