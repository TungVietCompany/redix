package redix.booxtown.model;

import java.util.List;

/**
 * Created by thuyetpham94 on 16/09/2016.
 */
public class ThreadResult {
    private int code;
    private List<Thread> listThread;

    public ThreadResult(List<Thread> listThread, int code) {
        this.listThread = listThread;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Thread> getListThread() {
        return listThread;
    }

    public void setListThread(List<Thread> listThread) {
        this.listThread = listThread;
    }
}
