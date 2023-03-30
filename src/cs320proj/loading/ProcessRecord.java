package cs320proj.loading;

public class ProcessRecord {
//Defines the process records in the context of the input file
    public final Long runTime;
    public final int priority;
    public final String processName;

    @Override
    public String toString() {
        return "ProcessRecord{" +
                "runTime=" + runTime +
                ", processName='" + processName + '\'' +
                ", priority='" + priority +'\'' +
                '}';
    }

    public ProcessRecord(Long runTime, String processName) {
        this(runTime, processName, 0);
    }

    public ProcessRecord(Long runTime, String processName, int priority) {
        this.runTime = runTime;
        this.processName = processName;
        this.priority = priority;
    }
}

