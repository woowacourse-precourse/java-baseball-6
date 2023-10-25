# 미션 - 숫자 야구

> 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를
> 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.

## 🔒 제약 사항

- JDK 17
- 구현할 기능 목록을 `README.md`에 작성한다
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 준수하며
  프로그래밍한다. ([한글 번역 - 1기 제이](https://github.com/JunHoPark93/google-java-styleguide),[한글 번역 - 3기 아마찌](https://newwisdom.tistory.com/m/96), [4.포맷팅 부분 다른점 유의](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java))
- Random, Scanner API 말고 `camp.nextstep.edu.missionutils`에서 제공하는`Randoms`및`Console`API를 사용하여 구현해야 한다.
- `ApplicationTest`의 모든 테스트가 통과해야 한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 17인지 확인한다.
  Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,
  Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 📝 구현할 기능 목록

- 게임 시작
- 랜덤한 3자리 수 생성
    - 서로 다른 3자리의 수인지 체크
- 사용자 입력 받기
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
    - 서로 다른 수인지 체크
    - 1~9 사이 정수로만 이루어진 수인지 체크
    - 3자리 수인지 체크
- 정답 체크
    - 정답이 맞으면 게 재시작 또는 종료 함수 호출
    - 정답이 아니면 힌트 제공
- 힌트 제공
    - 같은 수가 같은 자리에 있으면 스트라이크
    - 다른 자리에 있으면 볼
    - 같은 수가 전혀 없으면 낫싱
- 게임 재시작 또는 종료
    - 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

---

## 🚀 기능 구현 체크리스트

1. [x] 게임 시작 메소드
2. [x] 랜덤한 3자리 수 생성 메소드
    3. [x] `camp.nextstep.edu.missionutils`에서 제공하는`Randoms` 사용
    4. [x] 서로 다른 3자리의 수인지 체크
5. [x] 사용자 입력 받기
    6. [x] `camp.nextstep.edu.missionutils`에서 제공하는`Console` 사용
7. [ ] 사용자 입력 유효성 검사
    8. [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
    9. [ ] 서로 다른 수인지 체크
    10. [ ] 1~9 사이 정수로만 이루어진 수인지 체크
    11. [ ] 3자리 수인지 체크
12. [ ] 정답 체크
    13. [ ] 정답이 맞으면 게임 재시작 또는 종료 함수 호출
    14. [ ] 정답이 아니면 힌트 출력
15. [ ] 힌트 제공
    16. [ ] 같은 수가 같은 자리에 있으면 스트라이크
    17. [ ] 다른 자리에 있으면 볼
    18. [ ] 같은 수가 전혀 없으면 낫싱
19. [ ] 게임 재시작 또는 종료
    20. [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
    21. [ ] 재시작 1, 종료 2

