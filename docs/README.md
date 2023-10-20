# Feature

< Recursive >

1. Game Start
    1. 출력 숫자 야구 게임을 시작합니다.
2. Game ing
    1. 상대방(컴퓨터) 숫자 3자리 만들기
    2. 출력 숫자를 입력해주세요 :
    3. ask
    4. 결과 계산
        1. 배열 만들어서 한자리씩 끊어주기
            1. 먼저 컴퓨터 세자리 숫자 1, 2, 3
            2. 내가 예상한 세자리 숫자 1, 2, 3
        2. 먼저, 스트라이크 판별하기
            1. 1,2,3 돌면서 같은 자리 같은지 스트라이크인지 체크
        3. 스트라이크 아니라면, 볼 판별하기
            1. 전체 돌면서 같은 수 있나 볼인지 체크
        4. 결과 출력
3. if Success Goal , Game Finish
    1. 출력 3스트라이크
       3개의 숫자를 모두 맞히셨습니다! 게임 종료
4. choose Restart/Exit
    1. ask 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
    2. user input
        1. 1 restart(recursive) 2 exit
        2. if wrong input , IllegalArgumentException & Exit