package cs320proj.scheduler;

import cs320proj.MyProcess;

import java.util.Queue;
//import java.util.LinkedList;

public interface IScheduler {
    //Defines the features the cs320proj.scheduler needs to support.

    //Load list of programs
    public void loadProgram(Queue<MyProcess> p);
    //Get next program to run
    public Queue<MyProcess> runNext();
    //Maintain state of programs
    public Queue<MyProcess> getDoneList();

    public long getCurrentTick();

}
