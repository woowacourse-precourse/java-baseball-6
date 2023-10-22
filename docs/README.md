# 기능 목록

---

# Controller

## ⚾️ BaseballGameController

- startGame() : Game을 시작한다.
- stopGame() : 3스트라이크시 Game 재시작 or Game 종료 여부를 결정 짓는다.
- checkNumber() : Computer와 User의 숫자를 비교하여 ball, strike, nothing을 check한다.
- initGame() : User의 입력마다 초기화가 필요한 변수를 초기화한다.
- printOutput() : checkNumber()를 통해 계산된 결과를 출력한다.
- inputNumber() : User의 서로 다른 3자리 수를 입력받는다.
- inputExitNumber() : User의 Game 재시작 or Game 종료 여부 숫자를 입력받는다.

---

# Domain

## 🖥️ Computer

- makeNumber() : 1 ~ 9까지 서로 다른 수로 이루어진 3자리 수를 생성한다.
- getBall() : Computer의 서로 다른 3자리 수 중 index의 위치한 수를 가져온다.
- containsBall() : Computer의 서로 다른 3자리 수 중 매개변수로 받은 하나의 정수가 포함되는지 묻는다.

## 🧑🏻‍💻 User

- inputNumber() : Console API를 통해 User의 숫자를 입력 받는다.
- getBall() : User의 3자리 수 중 index의 위치한 수를 가져온다.
- addNumber() : User의 서로 다른 3자리르 저장하는 List에 정수를 추가한다.

---

## 🛠️ Util

## ❗️ Validation

### IllegalArgumentException 발생 (숫자 입력시)

- [x] User가 Console API를 통해 입력한 문자열이 숫자가 아닌 경우
- [x] User가 Console API를 통해 입력한 문자열이 숫자이나 3자리가 아닌 경우
- [x] User가 Console API를 통해 입력한 문자열이 서로 다른 3자리가 아닌 경우
- [x] User가 Console API를 통해 입력한 문자열에 0이 포함된 경우

### IllegalArgumentException 발생 (종료 숫자 입력시)

- [x] User가 Console API를 통해 입력한 문자열이 숫자가 아닌 경우
- [x] User가 Console API를 통해 입력한 문자열이 숫자이나 1자리가 아닌 경우
- [x] User가 Console API를 통해 입력한 문자열이 1이나 2가 아닌 경우