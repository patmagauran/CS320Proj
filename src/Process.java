public class Process {

    public final Long runTime;
    public Long timeRan;
    public Long lastTimeRun;



    public ProcessState processState;

    public Process(Long runTime) {
        this.runTime = runTime;
    }
    //Manages state of the process
}
