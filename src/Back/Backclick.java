package Back;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

/**
 * 后台点击
 */
public class Backclick {
    public static void doMouseByPostMessage(WinDef.HWND hWnd, int x, int y) throws InterruptedException {
        WinDef.WPARAM wParam = new WinDef.WPARAM(0);
        // window's coordinate
        // User32.INSTANCE.SetForegroundWindow(hWnd);
        WinDef.LPARAM lParam = makeLParam(x, y);
        System.out.println(x+"--"+y);
        User32.INSTANCE.PostMessage(hWnd, MessageType.WM_LBUTTONDOWN.getValue(), wParam, lParam);
        Thread.sleep(137);
        User32.INSTANCE.PostMessage(hWnd, MessageType.WM_LBUTTONUP.getValue(), wParam, lParam);
    }

    private static WinDef.LPARAM makeLParam(int a, int b) {
        System.out.println(a+"--"+b);
        return new WinDef.LPARAM(makeLong(a, b));
    }

    private static long makeLong(int a, int b) {
        int wordShift = 16;
        return a | ((long) b << wordShift);
    }
}
