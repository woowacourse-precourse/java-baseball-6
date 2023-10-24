## Game

게임을 여러 번 진행하도록 도와주는 객체이자, 게임 시작을 위한 객체이다.
Computer 객체를 사용하여 1번의 게임을 진행한다.

- [x] Computer를 주입 받는 생성자
- [x] 게임을 시작하고 반복하는 기능
- start() 구현 완료

## Printer

게임 진행시 필요한 출력을 담당하는 객체이다.

- [x] 숫자를 입력 받기 위해 '숫자를 입력해주세요 : ' 출력 기능
- printInputMent() 구현 완료


- [x] 게임 종료 시 '게임을 새로 시작하려면 ~ 를 입력하세요.' 출력 기능
- printFinishMent() 구현 완료


- [x] 게임 결과를 출력하는 기능
- printResult(int ball, int strike) 구현 완료

## Computer

숫자를 랜덤하게 생성하고, 사용자의 입력을 바탕으로 게임을 진행하는 객체이다.
Printer 객체를 사용하여 출력을 한다.

- [x] Printer를 주입 받는 생성자
- [x] 한 게임을 실행하는 기능
- play() 구현 완료


- [x] 랜덤하게 숫자 생성하는 기능
- generateNumber() 구현 완료


- [x] 입력한 숫자를 사용해 결과를 반환하는 기능
- checkGuess(List<Integer> guessNumber) 구현 완료


- [x] 잘못된 값 입력시 예외를 반환하고 종료하는 기능
- checkInputFormat(String guessString) 구현 완료


- [x] 정답을 맞췄을 시 사용자의 입력을 받아 재시작을 확인하는 기능
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
- checkReplay() 구현 완료

---

## Computer Refactoring

- [x] checkInputFormat() 불필요한 try-catch 제외하고 로직 다시 구현하기
- invalid한 경우에 바로 throw 하도록 구현 완료


- [ ] checkInputFormat() indent 줄이기

- [x] checkReplay() 불필요한 try-catch 제외하고 로직 다시 구현하기

- [x] checkGuess() indent 줄이기

- [x] 인터페이스 상속하도록 변경

- [ ] 클래스 내부에서만 사용하는 함수 private로 변경
- private로 바꾸면 테스트를 하지 못하는 경우 발생 -> 알아보기!

## Printer Refactoring

- [ ] printResult() 코드 간결하게 만들기

- [x] 인터페이스 상속하도록 변경

