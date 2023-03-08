package cs320proj;

import cs320proj.scheduler.RoundRobinScheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    //Should handle starting the program by cs320proj.loading in the input file and running the cs320proj.scheduler
    //Let things run as defined and then put out audit log
    public static void main(String[] args) {

        System.out.println("Hello world!");

        RoundRobinScheduler rr = new RoundRobinScheduler();

        long la = (long) 18.57;
        long lb = (long) 283.0;
        long lc = (long) 17.5;
        long ld = (long) 221.1;

        MyProcess a = new MyProcess(la);
        MyProcess b = new MyProcess(lb);
        MyProcess c = new MyProcess(lc);
        MyProcess d = new MyProcess(ld);

        Queue<MyProcess> pList = new LinkedList<>();

        pList.add(a);
        pList.add(b);
        pList.add(c);
        pList.add(d);

        rr.loadProgram(pList);

        int num = 0;
        while(!(rr.processes.isEmpty())){
            num++;
            System.out.println("Run " + num + ": ");
            System.out.println(rr.runNext());
        }





    //Call Loader to get list of ProcessRecords

        //Turn ProcessRecords into Processes

        //Create Scheduler Object

        //Pass processes to cs320proj.scheduler

        //Recieve finished processes from cs320proj.scheduler

        //Pass finished Processes to cs320proj.Auditor
        System.out.println("Hello world!");


    }
}

