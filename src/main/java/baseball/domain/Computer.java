package baseball.domain;

import baseball.validator.BaseballValidator;

import java.util.List;

//컴퓨터가 가지고 있는 3개의 랜덤 수
//검증자를 상속받아 클래스 내부에서 검증
public class Computer extends BaseballValidator {
    List<Integer> baseball;
    public Computer (){};
    public void setBaseball(List<Integer> baseball) {
        this.baseball = baseball;
    }
    public List<Integer> getBaseball() {
        return baseball;
    }
}
