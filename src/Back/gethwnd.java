package Back;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public class gethwnd {
    public static WinDef.HWND thehwnd()
    {
        return User32.INSTANCE.FindWindow(null, "阴阳师-网易游戏");
    }
    // 第一个参数是Windows窗体的窗体类，第二个参数是窗体的标题。不熟悉windows编程的需要先找一些Windows窗体数据结构的知识来看看，还有windows消息循环处理，其他的东西不用看太多。
}
