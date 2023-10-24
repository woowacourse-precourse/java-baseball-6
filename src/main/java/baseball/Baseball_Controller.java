package baseball;

public class Baseball_Controller {
    private Baseball_Model model;
    private Baseball_View view;

    public Baseball_Controller() {
        model = new Baseball_Model();
        view = new Baseball_View();
    }

    public void Play_Game() {
        view.Start_Message();
        boolean Start_Game = false;

        while (!Start_Game) {
            String User_Input = view.User_Input();
            String result = model.Play(User_Input);
            view.Show_Result(result);

            if(result.contains("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")){
                String choice = view.ReStart_Meg();
                if(!"1".equals(choice)){
                    Start_Game = true;
                }
                else{
                    model = new Baseball_Model();
                }
            }
        }
    }
}
