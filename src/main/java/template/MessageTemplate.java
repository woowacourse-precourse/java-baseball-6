package template;

import camp.nextstep.edu.missionutils.Console;

public class MessageTemplate {

    public String execute(String message, Callback callback){

        System.out.print(message); // 메세지 출력

        String result = Console.readLine(); // 값을 받아옴

        callback.valid(result); // result 값 검증

        return result;

    }
}
