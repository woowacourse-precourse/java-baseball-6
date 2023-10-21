구현할 기능 목록

-- 코드 작성 전 --

StartBaseball - 숫자야구게임 시작 문구 출력
GenerateNumber - 요구사항에 적혀있는 random API 를 이용하여 상대방(컴퓨터) 의 랜덤한 번호 생성
GuessNumber - 숫자입력문구 출력, 숫자 입력
CompNumber - 입력 받은 숫자와 상대방의 번호 비교
CheckResult - IsStrike, IsBall, IsCorrect(이건 넣을 위치 고민) 을 실행하여 결과를 종합
*IsCorrect (Gameover) 굳이 함수를 새로 생성하는것보단 변수로 선언하는게 가독성이 높을듯?
IsStrike - 스트라이크 수를 계산한다.
IsBall - 볼 수를 계산한다.

PrintResult - 종합한 값을 출력한다.

NextOrStop - StartGame, EndGame을 통해 재시작, 종료를 정한다.



------------------------------------------------
-- 코드 작성 후 --

StartBaseball - 숫자야구게임 시작 문구 출력
GenerateNumber - 요구사항에 적혀있는 random API 를 이용하여 상대방(컴퓨터) 의 랜덤한 번호 생성
GuessNumber - 숫자입력문구 출력, 예상숫자 입력
CompareNumber - 입력 받은 숫자와 상대방의 숫자 비교 하여 볼과 스트라이크의 갯수를 세고, 스트라이크의 개수를 gameresult 에 return
CheckResult - 스트라이크의 갯수를 받아 그것이 3(숫자의 개수) 와 같다면 해당 게임 종료후 NextOrStop 호출
NextOrStop - 재시작/종료 문구 출력 후 입력받은 숫자에 따라 재시작/종료를 정함
