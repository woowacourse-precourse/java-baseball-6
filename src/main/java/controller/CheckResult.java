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

    private StringBuilder selectComputers;
    private String selectUsers;

    private int strikeCount = 0;
    private int ballCount = 0;

    private Map<String, Integer> playResult = new HashMap<String, Integer>();

    public CheckResult(Computer computer, User user) {
        try{
            this.computer = computer;
            this.user = user;
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Exception occur CheckResult Class: NullPointerException");
        }
        selectComputers = computer.getterSelectComputerNum();
        selectUsers = user.getterSelectUsersNum();
        System.out.println(selectComputers);
        System.out.println(selectUsers);
    }

    public boolean equalsComputerAndUser() {
        for (int i = 0; i < selectComputers.length(); i++) {
            for(int j = 0; j < selectUsers.length(); j++) {
                checkString(i, j);
            }
        }
        playResult = result.getterResult();
        return resultPrint();
    }

    private void checkString(int i, int j) {
        if (selectComputers.charAt(i) == selectUsers.charAt(j)) {
            if(i == j) {
                result.setterResult("스트라이크", ++strikeCount);
                return;
            }
            result.setterResult("볼", ++ballCount);
        }
    }

    private boolean resultPrint() {
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
