package cs320proj.loading;

public class ProcessRecord {
//Defines the process records in the context of the input file
    public final Long runTime;
    public final String processName;

    @Override
    public String toString() {
        return "ProcessRecord{" +
                "runTime=" + runTime +
                ", processName='" + processName + '\'' +
                '}';
    }

    public ProcessRecord(Long runTime, String processName) {
        this.runTime = runTime;
        this.processName = processName;
    }
}

