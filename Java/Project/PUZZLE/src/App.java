import com.itheima.ui.GameJFrame;
import com.itheima.ui.LoginJFrame;
import com.itheima.ui.RegisterJFrame;

public class App {
    public static void main(String[] args){
        new LoginJFrame();//登录界面
        new GameJFrame();//主界面
        new RegisterJFrame();//注册界面
    }
}
