package Back;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

/**
 * 返回窗口的大小;长宽
 */

public class Windowsize {
    public static WinDef.RECT getClientRect(WinDef.HWND hWnd) {
        // origin coordinate: application window's upper left corner
        WinDef.RECT rect = new WinDef.RECT();
        boolean succeed = User32.INSTANCE.GetClientRect(hWnd, rect);
        return succeed ? rect : null;
    }

    public static void main(String[] args) {
        System.out.println(getClientRect(User32.INSTANCE.FindWindow(null, "阴阳师-网易游戏")));
    }
}
