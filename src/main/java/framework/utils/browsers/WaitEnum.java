package framework.utils.browsers;

/**
 * Created by User on 22.06.2017.
 */
public enum  WaitEnum {
    IMPLICITLY(30),
    EXPLICITLY(30),
    THREAD_SLEEP_ACTIONPAGE(3000);

    private int time;

    WaitEnum(int time) {
        this.time = time;
    }

    public int getTime(){
        return time;
    }
}
