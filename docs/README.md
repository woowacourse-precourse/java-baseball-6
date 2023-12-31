## 기능명세서

### Controller

- BaseballController
    - view와 domain을 연결해주는 역할
    - 프로그램 전체 흐름 제어

### Dto

- BallRequestDto
    - 입력 받은 플레이어의 공의 값을 담는 객체
- OptionRequestDto
    - 입력 받은 옵션 값을 담는 객체

### Model

- Ball
    - 야구공
    - 중복 숫자가 들어오면 예외 발생
    - 숫자가 3자리수 이상이면 예외 발생
    - 공을 비교해 스트라이크와 볼 값을 출력

- BallGenerator
    - 정답 야구공을 생성하는 클래스
    - 중복 없이 생성

- Option
    - 게임 옵션
    - 1번을 누르면 게임시작
    - 2번을 누르면 게임종료
    - 1, 2외의 값이면 예외 발생

- Result
    - 정답 공과 플레이어 공을 비교해서 스트라이크와 볼 카운트를 저장

### BaseballService

- 정답 야구공과 플레이어 야구공을 받아서 결과 출력

### InputView

- BallInputView
    - 플레이어에게 공 숫자를 입력받는 크래스
    - 입력 받은 값이 숫자가 아니면 예외처리

- OptionInputView
    - 플레이어에게 옵션 값을 입력받는 클래스
    - 입력 받은 값이 숫자가 아니면 예외처리

### OutputView

- 결과값을 출력