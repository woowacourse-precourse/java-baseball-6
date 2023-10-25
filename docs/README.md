main
게임의 전체적인 흐름
정답 결정
user가 정답을 맞출 때까지 round를 진행하고
더 게임을 할지 말지 user에게 입력받는다.

setComputerNumber
정답을 결정한다.

userRound
user가 입력한 userImput이 형식에 맞는지 확인한다.
맞다면 List<Integer>로 변환한 후
정답과 확인한다.

strNumToIntegerList
string을 List<Integer>로 변환한다

problemWithUserInput
userInput 예외 처리
길이가 3이면서 입력값 내에 중복값이 없는지 확인한다.

problemWithMoreGame
newOrEndGame 예외처리
1, 2 외의 값을 입력했는지 확인한다.

isCorrectAnswer
strike, ball의 개수를 구한 후 결과값을 출력한다.
정답인 경우에는 true를, 틀렸다면 false를 반환한다.

showTrialResult
s, b의 개수에 따라 알맞은 문구를 출력한다.