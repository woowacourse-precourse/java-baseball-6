# 구현할 기능 목록
## 숫자 야구 게임
### 게임 생성
- 임의의 수 3개 생성
  - 임의의 수는 camp.nextstep.edu.missionutils.Randoms 의 pickNumberInRange 를 사용하여 구현
  - 수의 범위는 1~9, 중복되지 않도록 구현
  - 생성한 3개의 수를 답으로 정한다.
### 게임 진행
- 사용자에게 입력을 받아 결과를 출력
  - 사용자가 입력하는 값 camp.nextstep.edu.missionutils.Console 의 readLine()을 활용
- 입력한 값이 만약 서로 다른 3자리의 수가 아니면(같은 수가 있는 경우도 포함) IllegalArgumentException 을 발생시킨 후 애플리케이션을 종료
- 결과값이 3스트라이크라면 게임이 종료
  - 3스트라이크가 아니라면, 힌트를 출력
- 게임이 종료될때 재시작/종료를 1과 2중 하나의 수로 선택
  - 재시작 : 1, 종료 : 2
  - 1 혹은 2가 아닌 값을 입력시 IllegalArgumentException 을 발생시킨 후 애플리케이션을 종료
### 계산
- 볼, 스트라이크의 정보를 담는 클래스 구현
- 사용자가 입력한 숫자를 비교한 결과 클래스를 반환
### 기타(유의사항)
- Java 17로 구현
- 테크코스 기준의 Java 코드 컨벤션 가이드를 준수하며 프로그래밍
- 프로그램 종료 시 System.exit()로 호출 금지
- 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공하도록 구현
  - ./gradlew clean test 명령으로 실행하여 테스트