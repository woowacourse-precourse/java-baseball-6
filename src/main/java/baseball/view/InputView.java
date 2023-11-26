package baseball.view;

import baseball.service.CoachsDTO;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static void printIntro() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    
    public static List<String> takeInputNames() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String InputNames = Console.readLine();
        return Arrays.stream(InputNames.trim().split(",")).collect(Collectors.toList());
    }

    public static List<String> takeInputProhibitedFood(String coachName) {
        System.out.println();
        System.out.println(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName));

        String InputFoods = Console.readLine();
        return Arrays.stream(InputFoods.trim().split(",")).collect(Collectors.toList());
    }
}
