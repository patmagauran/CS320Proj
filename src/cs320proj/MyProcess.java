package cs320proj;

public class MyProcess {

    public final Long runTime;
    public Long timeRan;
    public Long lastTimeRun;



    public ProcessState processState;

    public MyProcess(Long runTime) {
        this.runTime = runTime;
    }
    //Manages state of the process
}
