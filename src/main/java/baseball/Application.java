package baseball;

import service.Service;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        Service.gameStart();
        List<Integer> comNum = Service.setNumber();

        boolean continueOrExit_bool = true;

        while(continueOrExit_bool) {
            String userInput = Service.inputNumber();
            List<Integer> userNum = Service.strToInt(userInput);

            int[] answer_list = Service.checkNum(userNum, comNum);
            System.out.println(Service.output(answer_list));

            if(answer_list[1] == 3){
                continueOrExit_bool = Service.continueOrExit();
                comNum = Service.setNumber();

            }
        }
    }
}
