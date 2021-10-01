package onmyoji;

import Back.gethwnd;
import com.sun.jna.platform.win32.WinDef;

public class hwndornull {
    public static WinDef.HWND back()
    {
        if(gethwnd.thehwnd()!=null)
        {
            return gethwnd.thehwnd();
        }
        return null;
    }
}
