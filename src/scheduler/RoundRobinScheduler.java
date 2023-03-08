package scheduler;

import java.util.Queue;
import java.util.LinkedList;

public class RoundRobinScheduler implements IScheduler{
    
    //Implement scheduler using simple Round Robin

    Queue<Process> processes = new LinkedList<>();
    Queue<Process> done = new LinkedList<>(); //Remove once Auditor List is implemented!
    int timeSlice = 20; // adjust later!

    Clock c = new Clock();

    //Load list of programs
    public void loadProgram(Queue<Process> p){
        while(p.size()!=0){
            processes.add(p.remove());
        }
        // takes in list of programs

    }
    //Get next program to run
    public Queue<Process> runNext(){
        Process currentProcess = processes.remove();

        long startTick = c.getCurrentTick();
        while(((c.getCurrentTick()) - startTick < timeSlice) &&
                (currentProcess.timeRan < currentProcess.runTime)) {
                        c.tick();
                        currentProcess.timeRan++;
        }
        if (currentProcess.timeRan >= currentProcess.runTime) {
                done.add(currentProcess); //Change to Auditor list once implemented!
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
