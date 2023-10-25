# 주요 Class 및 Method 설명
### Computer
ArrayList<Integer> number : '서로다른 랜덤 변수(1~9) 3개를 저장하는 ArrayList
CreateComputer() : `Computer` 객체를 생성한다. \
createComputerNumber() : `Computer` 객체의 1~9의 서로 다른`number`를 생성한다.

### Judge
#### class 변수
strike : `Strike` 개수 저장 \
ball : `Ball` 개수 저장 \
#### class method
CreateJudge() : `Judge` 객체를 생성한다. \
outCome() : `Judge` 객체의 `computerNumber`와 `userNumber`를 비교하여 결과를 배열로 return한다.(index = 0 : strike, index = 1 : ball) \
### PlayGame
startGame() : 게임을 시작한다. \
reStart() : 사용자가 원할시 게임을 재시작한다. (1:재시작, 2:종료)\
### User