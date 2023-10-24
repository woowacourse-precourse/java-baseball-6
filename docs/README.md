기능 목록
구현 내용: 숫자 야구 게임
1. check 함수: user가 입력한 숫자가 적절한 숫자인지, 서로 다른 숫자 3개가 
잘 들어가 있는지 test해보는 함수
2. createAnswer 함수: 서로 다른 3개의 숫자를 생성하는 함수
   (유저가 맞추어야 하는 answer를 생성)
3. BaseballGame 함수: 야구 게임 함수
-> 숫자가 각 자리까지 정확히 맞으면 strike, 숫자가 정답 리스트에 들어가는 있으나
자리가 틀렸으면 ball, 그렇지 않으면 nothing을 1씩 증가시킨다.
그리고 이를 3번 계산한 후에 strike, ball의 횟수를 출력한다.
4. main 함수 : 위의 3가지 함수를 사용하고, 추가로 IllegalArgumentException을
이용하여 예외 처리한다.