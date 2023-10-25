 1. [Model] </br> 
                 class -> baseball - RandomInput </br>
                 ball 호출 </br>
                 ball 3개까지 호출 </br>
        : Validate Range 1부터 9까지 숫자 명료화 하고 </br>
        : 아스키코드로 전환이 되어서 문자가 1~9로 전환되는 것도 제외시켜야 함 </br>
        : null일 경우도 제외시키기
 2. [Control] </br> 
    Game 실행 </br>
 3. Main (Application.java 실행) </br>
 4. [View] </br> 
 화면 첫 시작 밑 끝 : View 으로 구현

[Descriptions]

1. "[숫자 생성]" ball 및 ballString // 클래스를 나눌 것이냐
2. : null, 1~9사이 정수가 아닌 것이 입력될시 IllegalArgumentException을 발생
3. Game 실행 [숫자 생성] </br>
    "[컴퓨터 숫자 쪽]" </br>
    "[읽히는 숫자 쪽]" :: [사용자 숫자] </br>
4. 숫자비교
5. strike, ball, nothing
6. 모두 맞힐 시 종료
7. 게임 재시작