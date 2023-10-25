<h1>프리코스 1주차 (숫자 야구 게임)</h1>
<h2>구현할 기능 목록</h2>

<b>1 숫자 입력 받기</b>
- 입력 받은 문자열 길이가 3이 아닌 경우 -> IllegalArgumentException()
- 1~9 이외에 다른 문자가 입력되었을 경우 -> IllegalArgumentException()
- 입력 받은 숫자가 중복 된 경우 -> IllegalArgumentException()

<b>2 랜덤 숫자 생성하기</b>
- 1~9사이 숫자 3개를 중복 없이 생성한다

<b>3 입력 받은 숫자와 랜덤 숫자 비교하기 + 힌트 출력</b>
- 같은 위치에 같은 숫자가 있으면 strike
- 같은 위치는 아니지만 같은 숫자가 있으면 ball
- 3 strike 이면 더 이상 숫자 입력 받지 않기

<b>4 게임 종료 또는 한번 더 진행</b>
- 1 입력 -> 게임 한번 더 진행 (1번으로 이동)
- 2 입력 -> 종료
- 1, 2가 아닌 문자가 입력 된 경우 -> IllegalArgumentException()
