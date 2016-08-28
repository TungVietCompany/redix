package redix.booxtown.model;

/**
 * Created by Administrator on 27/08/2016.
 */
public class InteractThread {

    private String interactThreadTitle;
    private String interactThreadCount;
    private String interactThreadAddBy;
    private boolean status;

    public InteractThread() {
    }

    public InteractThread(String interactThreadTitle, String interactThreadCount, String interactThreadAddBy, boolean status) {
        this.interactThreadTitle = interactThreadTitle;
        this.interactThreadCount = interactThreadCount;
        this.interactThreadAddBy = interactThreadAddBy;
        this.status = status;
    }

    public String getInteractThreadTitle() {
        return interactThreadTitle;
    }

    public void setInteractThreadTitle(String interactThreadTitle) {
        this.interactThreadTitle = interactThreadTitle;
    }

    public String getInteractThreadCount() {
        return interactThreadCount;
    }

    public void setInteractThreadCount(String interactThreadCount) {
        this.interactThreadCount = interactThreadCount;
    }

    public String getInteractThreadAddBy() {
        return interactThreadAddBy;
    }

    public void setInteractThreadAddBy(String interactThreadAddBy) {
        this.interactThreadAddBy = interactThreadAddBy;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
