# 야구게임

### 프로그램 실행 흐름

1. 1에서 9까지 서로 다른 임의의 수 3개를 선택
   (`camp.nextstep.edu.missionutils.Randoms` - `pickNumberInRange()` 사용)
2. 사용자로부터 서로 다른 3개의 숫자 입력 받기
   (`camp.nextstep.edu.missionutils.Console` - `readLine()` 사용)
3. 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
4. 입력한 숫자에 대한 결과를 출력
    - 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

        ```sql
        1스트라이크
        1볼
        1볼 1스트라이크
        ```

    - 하나도 없는 경우

        ```sql
        낫싱
        ```

    - 3개의 숫자를 모두 맞힐 경우

        ```sql
        3스트라이크
        3개의 숫자를 모두 맞히셨습니다! 게임 종료
        ```

5. 사용자가 입력한 숫자가 컴퓨터가 선택한 임의의 숫자와 일치할 때까지 2, 3, 4번 반복
6. 게임을 다시 시작하거나 완전히 종료
    - 재시작: 1
    - 종료: 2

### 구현할 기능 목록

- Constant.java
    - 출력 메시지
    - 고정 상수
- BaseballGame.java
    - 게임 실행하는 메인 play() 함수
    - 컴퓨터 랜덤 숫자 생성하는 함수
    - 사용자에게 숫자 입력받는 함수
    - 사용자 숫자 입력 검증하는 함수 (숫자 길이 3이상인 경우, 1~9 사이값 아닌 경우, 중복된 숫자가 있는 경우)
    - 볼, 스트라이크 계산하는 함수

### 추가 요구사항

- [ ]  JDK 17 버전에서 실행 가능해야 한다.
- [ ]  `build.gradle`파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [ ]  [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)가이드를 준수한다.
- [ ]  `System.exit()`를 호출하지 않는다.
- [ ]  `ApplicationTest`의 모든 테스트가 성공해야 한다.
- [ ]  파일, 패키지 이름을 수정하거나 이동하지 않는다.