package repository;

import camp.nextstep.edu.missionutils.Console;
import validation.Valid;

public class BaseRepository {

    private final Valid valid = new Valid();

    public String getMyNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String myNumber = Console.readLine();

        valid.myNumberValid(myNumber);
        return myNumber;
    }

    public String getRestartSelect() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartSelect = Console.readLine();

        valid.restartValid(restartSelect);
        return restartSelect;
    }
}
