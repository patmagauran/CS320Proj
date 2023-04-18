package cs320proj;

public class MyProcess implements Comparable<MyProcess> {

    public final Long runTime;
    public Long timeRan;
    public Long lastTimeRun = 0L;

    public int timesRan = 0;

    public Long totalTimeWait = 0L;
    public final int processID;

    public final String processName;

    public final int priority;

    public double normalizedTurnaround = 0;

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
                ", normalizedTurnaround=" + normalizedTurnaround +
                ", processName='" + processName + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

    public MyProcess(Long runTime, int processID, String processName, int priority) {
        this.processID = processID;
        this.processName = processName;
        this.priority = priority;
        this.timeRan = 0L;
        this.lastTimeRun=0L;
        this.runTime = runTime;
    }

    @Override
    public int compareTo(MyProcess o) {
        return this.priority - o.priority;
    }
    //Manages state of the process
}
