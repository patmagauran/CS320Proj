public class Clock {


    private long clock = 0L;

    public Clock() {

    }

    public Long tick() {
        return clock++;
    }

    public Long getCurrentTick() {
        return clock;
    }


}
