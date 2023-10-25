# 1. 기능 명세서
## 입력
- [x] 사용자로부터 수 입력받는 readNum() 메서드 작성
## 출력
- [x] 사용자의 입력에 따른 출력 printGameResult() 메서드 작성
- [x] 사용자가 정답을 맞췄을때 출력 printEndGame() 메서드 작성
- [x] 게임이 완전히 종료됐을 때 출력 endOfGame() 메서드 작성
- [x] 예외 발생시 예외 메시지 출력 printExceptionMessage() 메서드 작성
## 로직
- [x] 컴퓨터의 랜덤 수를 생성하기 위해 generateRandNum() 메서드 작성
- [x] 스트라이크와 볼의 개수를 구하는 countStrikeAndBall() 메서드 작성
- [x] 게임이 재시작 됐을 때 새 NumberBaseball 인스턴스 생성하는 newGame() 메서드 작성
- [x] 컴퓨터의 수와 입력 값이 같은지 비교하는 isSameNum() 메서드 작성

# 2. 예외 처리
- [x] 입력 숫자가 서로 다르지 않은 경우 ex) 222
- [x] 1 ~ 9 외에 다른 수를 입력한 경우 ex) 012
- [x] 입력 수가 세자리가 아닌 경우 ex) 1, 12345
- [x] 문자가 입력된 경우 ex) abc
- [x] 공백이 들어온 경우 ex) " "
- [x] 게임 재시작 유무값(1 or 2)외에 다른 값이 들어온 경우 ex) 3, 4,,,,
