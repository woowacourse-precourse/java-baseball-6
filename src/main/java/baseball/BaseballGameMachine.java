package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameMachine {
    public String input() {
        return Console.readLine();
    }

    public void play() {
        NumberGenerator generator = new NumberGenerator();
        startMessage();
        Referee referee = new Referee(generator.generateRandomAnswerList());
        boolean success = false;
        while (!success) {

        }

    }

    public void startMessage() {
        Message message = new Message();
        System.out.println(message.start() + '\n');
    }

//    public void
}
