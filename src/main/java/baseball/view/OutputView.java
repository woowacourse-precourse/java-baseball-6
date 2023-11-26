package baseball.view;

import baseball.domain.MenuResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printResult(MenuResult menuResult) {
        printIntro();
        printCategories(menuResult);
        printMenus(menuResult);
        printOutro();
    }

    private static void printMenus(MenuResult menuResult) {
        Map<String, List<String>> menus = menuResult.getMenus();
        for (Map.Entry<String, List<String>> entry : menus.entrySet()) {
            List<String> menusForCoach = mergeMenuForCoach(entry);
            String joinedMenus = String.join(" | ", menusForCoach);
            System.out.println("[ " + joinedMenus + " ]" );
        }
    }

    private static List<String> mergeMenuForCoach(Map.Entry<String, List<String>> entry) {
        List<String> menusForCoach = new ArrayList<>();
        menusForCoach.add(0, entry.getKey());
        menusForCoach.addAll(entry.getValue());
        return menusForCoach;
    }

    private static void printCategories(MenuResult menuResult) {
        System.out.println("[ " + String.join(" | ", menuResult.getCategories()) + " ]");
    }

    private static void printOutro() {
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private static void printIntro() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }
}
