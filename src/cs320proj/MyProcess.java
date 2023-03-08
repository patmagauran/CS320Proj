package cs320proj;

public class MyProcess {

    public final Long runTime;
    public Long timeRan;
    public Long lastTimeRun = 0L;

    public int timesRan = 0;

    public Long totalTimeWait = 0L;
    public final int processID;

    public final String processName;



    public ProcessState processState;

    @Override
    public String toString() {
        return "MyProcess{" +
                "processID=" + processID +
                ", runTime=" + runTime +
                ", timeRan=" + timeRan +
                ", lastTimeRun=" + lastTimeRun +
                ", timesRan=" + timesRan +
                ", totalTimeWait=" + totalTimeWait +
                ", processName='" + processName + '\'' +
                '}';
    }

    public MyProcess(Long runTime, int processID, String processName) {
        this.processID = processID;
        this.processName = processName;
        this.timeRan = 0L;
        this.lastTimeRun=0L;
        this.runTime = runTime;
    }
    //Manages state of the process
}
