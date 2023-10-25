## 구현할 기능 && 구현 순서 정리

> 요구 사항 정리
> - 사용자가 입력 가능한 값은 3자리 숫자혹은 1,2
> - 게임 시작 안내 문자열을 출력해야하고, 사용자가 정답을 입력하기 전까지 입력을 받아야한다
> - 사용자가 잘못된 형식의 값을 입력한 경우 System.exit()을 호출하지 않고 애플리케이션을 종료한다
> - 정답을 입력하면 게임을 새로 시작할지, 종료할지를 입력받는다
> - ApplicationTest를 통과해야한다.

### 생성할 클래스들

- Game - 게임 진행을 담당하는 클래스
  - game.start() - 게임을 실행하는 메소드
  - game.init() - 정답을 설정하는 메소드
  - game.run() - 사용자한테 입력을 받으면서 게임을 진행하는 메소드
  - game.rerunOrTerminate() - 사용자한테 입력을 받아서 게임을 재 진행하거나, 종료하는 메소드
- Constant - 상수를 저장하기 위한 클래스
- InputUtil - 사용자 입력값을 입력 받기 위한 클래스
  - getUserInput() - 사용자 입력 값을 검증하고, 잘못된 값 입력시 예외를 발생하는 메소드

### 구현 순서 
1. Constant 클래스에 필요한 상수 정리
2. InputUtil.getUserInput() 메소드 기능 구현
3. game.start() && game.init() 메소드 기능 구현
4. game.run() && game.rerunOrTerminate() 기능 구현
