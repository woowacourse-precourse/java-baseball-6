기능 목록 정의
게임 시작
텍스트 출력
'숫자 야구 게임을 시작합니다.'
(loop)
정답 결정
Randoms 라이브러리를 통해 임의의 수 3자리를 결정
이후 answer 라고 한다
(loop)
숫자 맞추기 실행
결과가 3 스트라이크이면, (Break)
게임 종료
게임 완료 실행
1이면 (Continue)
2이면 (Break)
숫자 맞추기
텍스트 출력
숫자를 입력해주세요 :
숫자 입력 받기
Console 활용
서로 다른 3자리의 수
그 외 : IllegalArgumentException
이후 guessTheAnswer라고 한다
결과 판정
스트라이크 +1
answer과 guessTheAnswer 비교 해서 같은 수가 같은 자리일 경우
볼 + 1
answer과 guessTheAnswer 비교 해서 같은 수가 다른 자리일 경우
낫싱
같은 수가 전혀 없을 경우
결과 출력하기
3 스트라이크일 경우
3개의 숫자를 모두 맞히셨습니다! 게임 종료
입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
n볼 n스트라이크
하나도 없는 경우
낫싱
게임 완료
텍스트 출력
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
숫자 입력 받기
Console 활용
1: 재시작
2: 종료
그 외 : IllegalArgumentException