package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BaseballService {
    public static int [] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    public List<Integer> init() {
        //int [] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<Integer> ret = new ArrayList<>();

        try {
            while (ret.size() < 3) {
                int val = Randoms.pickNumberInRange(1, 9);

                if (!ret.contains(val)) {
                    ret.add(val);
                }
            }

        } catch (IllegalArgumentException e) {
            throw e;
        }

        return ret;
    }

    public String getStringInput() throws IllegalArgumentException {
        String user;
        user = Console.readLine();

        if (user.length() != 3 || !user.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        return user;
    }

    public Integer getIntInput() {
        String tmpInput = Console.readLine();
        int input = Integer.parseInt(tmpInput);

        if (input != 1 && input != 2) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
