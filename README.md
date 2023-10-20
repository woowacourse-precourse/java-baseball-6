# 미션 - ⚾ 숫자 야구 ⚾

---

## 💡 기능 요구 사항

컴퓨터와 1부터 9까지의 수로 이루어진 3자리의 수를 맞추는 게임

### **핵심 알고리즘 및 구현할 기능 순서**

1. "숫자 야구 게임을 시작합니다." 출력
2. 컴퓨터가 서로 다른 임의의 수 3개를 선택
3. 유저가 3자리 수 입력
    - 유저가 잘못된 값을 입력할 경우 IllegalArgumentException발생 후 앱 종료
    - 아래의 조건을 토대로 유저가 입력한 수와 컴퓨터가 정한 수를 자리수에 따라 비교
        - 유저가 입력한 수의 특정 자리의 수의 위치가 같을 경우 : 스트라이크
        - 유저가 입력한 수의 특정 자리의 수의 위치가 다르지만, 해당 수가 존재할 경우 : 볼
        - 유저가 입력한 수가 위 2가지 조건을 하나라도 채우지 못한 경우 : 낫싱
4. 아래의 조건에 따라 출력
    - 볼이 A(1~3)개 혹은 스트라이크가 A(1~2)개 일 경우 : "A볼" 혹은 "A스트라이크" 출력
    - 볼이 A(1~3)개, 스트라이크가 B(1~2)개 일 경우 : "A볼 B스트라이크" 출력
    - 낫싱일 경우 : "낫싱" 출력
    - 3 스트라이크일 경우, 재시작 혹은 종료를 위해 특정 수 입력
        - 1을 입력한 경우, 재시작하기 위해 2번으로 진행
        - 2를 입력한 경우, 종료를 위해 5번으로 진행
5. 애플리케이션 종료


### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```



---
## 👓 프로그래밍 요구 사항 정리

- 실행 환경 : JDK 17
- build.gradle 변경 및 외부 라이브러리 사용 불가
- Java 코드 컨벤션 가이드 준수
    - 들여쓰기 : +4 스페이스
    - 들여쓰기 지속 : 최소 +8 스페이스
    - 최대 열 : 120
- System.exit() 사용 금지, ApplicationTest 성공 필수
- 요구사항에서 달리 명시하지 않는 파일, 패키지 이름 수정 혹은 이동 불가
- 라이브러리
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
        - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
        - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 라이브러리 사용 예시
```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

## 💻 과제 진행 요구 사항

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
