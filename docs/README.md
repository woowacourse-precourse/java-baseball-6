# 기능 목록 정리

## 숫자 야구

### 기능 요구 사항

---

- 컴퓨터
    - [x]  `generateNumbers()`
        - 1 - 9 까지 서로 다른 임의의 수 3개를 생성
    - [ ]  힌트 제공
        - 같은 수가 같은 자리에 있으면 스트라이크
        - 같은 수가 다른 자리에 있으면 볼
        - 같은 수가 전혀 없으면 낫싱
- 유저
    - [ ]  3개의 숫자 입력
    - [ ]  종료 후 시작 혹은 종료 입력
- 운영
    - [ ]  종료 로직
        - 종료
        - 새로 시작
    - [ ]  잘못된 값을 입력 시 예외처리

### 입출력 요구 사항

---

- 입력
    - [ ]  서로 다른 3자리의 수
    - [ ]  게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
- 출력
    - [ ]  입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
        - `1볼 1스트라이크`
        - `낫싱`
        - 3개의 숫자를 모두 맞힐 경우
            - `3스트라이크
              3개의 숫자를 모두 맞히셨습니다! 게임 종료`
        - 게임 시작 문구 출력
            - `숫자 야구 게임을 시작합니다.`

### 프로그래밍 요구 사항

---

- [x]  JDK 17 사용
- [ ]  프로그램 실행 시작점은 Application의 main()이다.
- [ ]  build.gradle 수정 x
- [x]  Java 코드 컨벤션 준수
- [ ]  System.exit() 호출 x
- [ ]  ApplicationTest의 모든 테스트가 성공
- [ ]  기존 파일 이름, 패키지 이름 수정 x
- [x]  Random값 추출은 `camp.nextstep.edu.missionutils.Randoms`의`pickNumberInRange()`를 활용한다.
- [ ]  사용자가 입력하는 값은`camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용한다.

### 과제 진행 요구 사항

---

- [x]  미션은[java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6)저장소를 Fork & Clone해 시작한다.
- [ ]  **기능을 구현하기 전`docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [ ]  과제 진행 및 제출 방법은[프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse)문서를 참고한다.