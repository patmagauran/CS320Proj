package scheduler;

import java.util.Queue;
//import java.util.LinkedList;

public interface IScheduler {
    //Defines the features the scheduler needs to support.

    //Load list of programs
    public void loadProgram(Queue<Process> p);
    //Get next program to run
    public Queue<Process> runNext();
    //Maintain state of programs

}
