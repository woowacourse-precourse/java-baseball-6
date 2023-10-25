#1주차 숫자야구
    1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
    
    같은 수가 같은 자리에 있으면 스트라이크,
    다른 자리에 있으면 볼,
    같은 수가 전혀 없으면 낫싱이란 힌트를 얻고,
    그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리합니다.
    
#기능 구현
 -Application : 전체 class 실행 관리
 -Computer : 1~9까지 서로 다른 임의의 3개의 숫자 리스트 생성
 -Player : 1~9까지 서로 다른 임의의 3개의 숫자 리스트 생성
 -Game : Computer와 Player의 값을 비교해 점수 반환
 - Restart : 정답을 맞춘 후 '재시작 : 1, 게임 종료 : 2'

#Exception
[Player] 
 - exception : 중복된 숫자가 인렵된 경우
 - exceptionPlayer : 입력된 숫자가 1~9 사이의 숫자가 아닌 경우
 - exceptionFormat : 문자열이 포함되어있거나 입력된 숫자가 3자리가 아닌 경우
[Restart]
 - exception : 1 또는 2가 아닌 값을 입력한 경우
