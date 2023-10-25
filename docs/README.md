# 프리코스 1주차 : 숫자 야구 게임

### 기능 구현 목록


### 프로그래밍 주의사항

- JDK 17 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다. 
- Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다. 
  - Indent depth 는 3이 넘지 않도록 구현
  - Ternary expression 금지
  - Modularize code. 함수가 한가지 일만 하도록 최대한 작게 만든다
  - Google Code Style 을 준수하되 다음 사항은 변경한다.
    - (4.2) 블럭 들여쓰기: +2 스페이스 -> +4 스페이스
    - (4.4) 열 제한 : 100 -> 120
    - (4.5.2) 들여쓰기 지속은 최소 +4 스페이스 -> +8 스페이스
    - (4.6.1) 수직 빈 줄 : 빈 줄은 가독성을 향상시키기 위해서라면 어디든(예를 들면 논리적으로 코드를 구분하기 위해 문장 사이) 사용 될 수 있다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다. 
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console`API를 사용하여 구현해야 한다. 
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다. 
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.