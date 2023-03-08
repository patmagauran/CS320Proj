package cs320proj.scheduler;

import cs320proj.Clock;
import cs320proj.MyProcess;

import java.util.Queue;
import java.util.LinkedList;

public class RoundRobinScheduler implements cs320proj.scheduler.IScheduler {
    
    //Implement cs320proj.scheduler using simple Round Robin

    public Queue<MyProcess> processes = new LinkedList<>();
    Queue<MyProcess> done = new LinkedList<>(); //Remove once cs320proj.Auditor List is implemented!
    int timeSlice = 20; // adjust later!

    Clock c = new Clock();

    //Load list of programs
    public void loadProgram(Queue<MyProcess> p){
        while(p.size()!=0){
            processes.add(p.remove());
        }
        // takes in list of programs

    }
    //Get next program to run
    public Queue<MyProcess> runNext(){
        MyProcess currentProcess = processes.remove();

        long startTick = c.getCurrentTick();
        while(((c.getCurrentTick()) - startTick < timeSlice) &&
                (currentProcess.timeRan < currentProcess.runTime)) {
                        c.tick();
                        currentProcess.timeRan++;
        }
        if (currentProcess.timeRan >= currentProcess.runTime) {
                done.add(currentProcess); //Change to cs320proj.Auditor list once implemented!
        } else {
            currentProcess.lastTimeRun = c.getCurrentTick();
            processes.add(currentProcess);
        }
        return processes;
        // return list of processes
    }
    //Maintain state of programs

    /*
    • Maybe time entered onto the queue, time started on CPU, time spent waiting, and time completed.
     */

}