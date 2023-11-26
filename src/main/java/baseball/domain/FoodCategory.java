package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public enum FoodCategory {
    JAPAN(1, "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA(2, "한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA(3, "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIA(4, "아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WEST(5, "양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private int number;
    private String name;
    private List<String> menus;

    FoodCategory(int number, String name, List<String> menus) {
        this.number = number;
        this.name = name;
        this.menus = menus;
    }

//    public static String getFood(String prohibitedFoodName) {
//        return Arrays.stream(values())
//                .map(foodCategory -> foodCategory.menus)
//                .flatMap(Collection::stream)
//                .filter(name -> !name.isBlank())
//                .filter(name -> name.equals(prohibitedFoodName))
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다."));
//    }

    public static FoodCategory getCategory(int index) {
        return Arrays.stream(values())
                .filter(foodCategory -> foodCategory.number == index)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다."));
    }

    public static boolean contain(String prohibitedFoodName) {
        return Arrays.stream(values())
                .map(foodCategory -> foodCategory.menus)
                .flatMap(Collection::stream)
                .toList()
                .contains(prohibitedFoodName);
    }

    public String recommendFood() {
        return Randoms.shuffle(this.menus).get(0);
    }

    public String getName() {
        return name;
    }
}
