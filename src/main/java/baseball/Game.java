package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static baseball.Question.question;


public class Game {
    Gamedata gamedata = new Gamedata();
    List<Integer> questionnumber;
    int[] inputnumber;

    // 다른위치로 빼야한다고 생각함, 숫자 입력 메소드
    public void numberinput() {
        String input = Console.readLine();
        inputnumber = Converter.convertednumber(input);
    }
    public void startgame() {
        int strike = 0;
        int ball = 0;
        questionnumber = question();

        while (strike != 3) {
            Message.numberrequest();
            numberinput();
            play();
            Message.scoremessage(gamedata.returnstrike(), gamedata.returnball());
            strike = gamedata.returnstrike();
        }

    }

    private void play() {
        gamedata.refreshcount();
        for (int i = 0; i < 3; i++) {
            compare(questionnumber, inputnumber, i);
        }
    }

    private void compare(List<Integer> question, int[] inputnumber, int index) {
        int value = -1;
        for (int i =0; i < 3; i++) {
            if (question.get(index) == inputnumber[i]) {
                value = i;
                break;
            }
        }
        checkposion(value, index);
    }

    private void checkposion(int value, int index) {
        if (value==index) {
            gamedata.countstrike();
        }

        if (value!= -1 && value != index) {
            gamedata.countball();
        }


    }

}
