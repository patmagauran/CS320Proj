package cs320proj;

public class AuditRecord {

    public int PID;

    public String processName;
    public Long totalTicks;

    public Long runningTicks;

    public Long avgWait;

    public Long waitingTime;
    public double normalizedTurnAroundTime;

    public int numTurns;

    public AuditRecord(int PID, String processName, Long totalTicks, Long runningTicks, Long avgWait, Long waitingTime, int numTurns, double normalizedTurnAroundTime) {
        this.PID = PID;
        this.processName = processName;
        this.totalTicks = totalTicks;
        this.runningTicks = runningTicks;
        this.avgWait = avgWait;
        this.waitingTime = waitingTime;
        this.numTurns = numTurns;
        this.normalizedTurnAroundTime = normalizedTurnAroundTime;
    }

    @Override
    public String toString() {
        return "AuditRecord{" +
                "PID=" + PID +
                ", processName='" + processName + '\'' +
                ", totalTicks=" + totalTicks +
                ", runningTicks=" + runningTicks +
                ", avgWait=" + avgWait +
                ", waitingTime=" + waitingTime +
                ", normalizedTurnAroundTime=" + normalizedTurnAroundTime +
                ", numTurns=" + numTurns +
                '}';
    }
}
