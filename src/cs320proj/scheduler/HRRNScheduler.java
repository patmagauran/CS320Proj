package cs320proj.scheduler;

import cs320proj.Clock;
import cs320proj.MyProcess;

import java.util.LinkedList;
import java.util.Queue;

public class HRRNScheduler implements IScheduler{

    //Implement cs320proj.scheduler using simple Round Robin

    public Queue<MyProcess> processes = new LinkedList<>();

    public Queue<MyProcess> getProcesses() {
        return processes;
    }

    public Queue<MyProcess> getDoneList() {
        return done;
    }

    @Override
    public long getCurrentTick() {
        return c.getCurrentTick();
    }

    public HRRNScheduler() {

    }
    Queue<MyProcess> done = new LinkedList<>(); //Remove once cs320proj.Auditor List is implemented!

    Clock c = new Clock();

    //Load list of programs
    public void loadProgram(Queue<MyProcess> p){
        while(p.size()!=0){
            processes.add(p.remove());
        }
        // takes in list of programs

    }

    @Override
    public Clock getClock() {
        return c;
    }

    private MyProcess getHighestRatio(){
        MyProcess highest = null;
        for (MyProcess process : processes) {
            long startTick = c.getCurrentTick();
            process.totalTimeWait += startTick - process.lastTimeRun;
            process.normalizedTurnaround = (double) (process.totalTimeWait + process.runTime) / process.runTime;
            if (highest == null || highest.normalizedTurnaround < process.normalizedTurnaround) {
                highest = process;
            }
        }
        return highest;
    }

    //Get next program to run
    public Queue<MyProcess> runNext(){


        MyProcess currentProcess = getHighestRatio();
        processes.remove(currentProcess);

        long startTick = c.getCurrentTick();
        currentProcess.totalTimeWait += startTick - currentProcess.lastTimeRun;
        currentProcess.timesRan++;
        while (currentProcess.timeRan < currentProcess.runTime) {
            c.tick();
            currentProcess.timeRan++;
        }
        currentProcess.lastTimeRun = c.getCurrentTick();
        done.add(currentProcess); //Change to cs320proj.Auditor list once implemented!
        return processes;
        // return list of processes
    }
}
