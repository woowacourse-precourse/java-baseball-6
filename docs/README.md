프로젝트 목표

MVC 패턴을 적용하기
테스트 커버리지 높게
코드 컨벤션 지키기

기능 목록

- 1~9까지 서로 다른 임의의 수 3개를 생성한다.
- 사용자로부터 3개의 수를 입력받는다.
- 입력받은 수가 1~9까지 서로 다른 수인지 확인한다.
- 입력받은 수와 생성한 수를 비교하여 볼과 스트라이크를 계산한다.
- 볼과 스트라이크를 출력한다.
- 3개의 숫자를 모두 맞히면 게임을 종료한다.
- 게임을 종료한 후 다시 시작하거나 완전히 종료할 수 있다.

도메인

- Baseball
  - 범위, 중복, 길이 검증
- Command
  - Command 검증
- generator
  - BaseballNumbersGenerator 숫자 생성 interface
  - BaseballRandomNumbersGenerator 숫자 생성 interface 구현체
- Computer
  - generator를 받아서 생성
  - 정답 숫자들 생성
- Player
  - 입력을 받고, IntegerList로 변환 후 Baseball로 검증
- RoundResult
  - 볼, 스트라이크 결과
  - toString으로 출력 포맷

기타

- 전역 예외 처리, 예외 메시지 관리
- view 분리
- controller, service 분리
