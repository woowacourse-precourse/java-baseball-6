package controller;
import model.Computer;
import model.Result;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckResult {
    private Computer computer;
    private User user;
    private Result result = new Result();

    private char[] selectComputers;
    private char[] selectUsers;

    private Map<String, Integer> playResult = new HashMap<String, Integer>();

    public CheckResult(Computer computer, User user) {
        this.computer = computer;
        this.user = user;

        selectComputers = computer.getterSelectComputerNum();
        selectUsers = user.getterSelectUsersNum();

        System.out.println(selectComputers);
        System.out.println(selectUsers);

    }

    public boolean equalsComputerAndUser() {
        System.out.println("equalComputerAndUser 입성");
        int strikeCount = 0;
        int ballCount = 0;

        for (int i =0; i< selectComputers.length; i++) {
            for(int j = 0; j < selectUsers.length; j++) {
                if ((selectComputers[i] == selectUsers[j]) && equalsIndex(i, j)) {
                    result.setterResult("스트라이크", ++strikeCount);
                    break;
                }
                if ((selectComputers[i] == selectUsers[j]) && !(equalsIndex(i, j))) {
                    result.setterResult("볼", ++ballCount);
                    break;
                }
            }
        }
        playResult = result.getterResult();
        return resultPrint();
    }

    private boolean equalsIndex(int i, int j) {
        if (i == j) {
            return true;
        }
        return false;
    }

    private boolean resultPrint() {
        System.out.println(playResult);
        if(playResult.isEmpty()) {
            System.out.println("낫싱");
            return false;
        }

        Set<String> keySet =playResult.keySet();
        for (String key : keySet) {
            System.out.print(playResult.get(key) + key + " ");
        }
        System.out.println();

        if(playResult.get("스트라이크") != null && playResult.get("스트라이크") == 3) {
            return true;
        }

        return false;
    }
}
