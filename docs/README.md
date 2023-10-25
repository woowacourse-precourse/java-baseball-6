# 1. BasicController class

- 설명 : client는 Controller와만 통신을 하게 만들어 내부 동작을 추상화 시킨다. 
### checkNumber
- [x] 입력값을 비교하는 CheckService를 호출하고, 결과값을 리턴받는다.
- [x] 결과값을 ResultView에 매개변수로 전달하여, 결과를 출력한다.
- [x] 3 스트라이크 경우 True, 아닐 경우 False를 리턴한다. 
### makeIntegerArray
- [x] 입력값을 크기 3인 Integer 배열로 만들어 리턴한다.

# 2. CheckService class
- 설명 : client의 입력과 컴퓨터의 값을 비교
### matchNumber
- [x] 입력값과 컴퓨터 값을 파라미터로 받는다.
- [x] 파라미터로 받은 두 값을 비교한다.
- [x] GameResult 객체를 만들어 스트라이크 횟수, 볼 횟수, 3 스트라이크 여부를 저장한다.
- [x] GameResult를 리턴한다.

# 3. ResultView class
- 설명 : GameResult를 출력하는 역할
### printResult
- [x] 스트라이크, 볼 횟수가 0이 아닌 경우 해당 숫자와 문자열을 출력한다.
- [x] 스트라이크, 볼 둘다 0일 경우 "낫싱"을 출력한다.
- [x] 3 스트라이크 경우, 성공 문자열을 출력한다.

# 4. GameResult class
- 설명 : 게임 결과값을 저장하는 객체
- [x] 멤버변수 : 스트라이크, 볼, 성공(3 스트라이크) 