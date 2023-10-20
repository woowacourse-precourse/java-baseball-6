package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class PlayerTerminalView {
    public void display(String massage) {
        System.out.print(massage);
    }
    public String inputQuery() {
        String queryString = Console.readLine();
        return queryString;
    }
    public String getAnswer(){
        String answer = Console.readLine();
        return answer;
    }
}
