package cs320proj;

import cs320proj.loading.Loader;
import cs320proj.loading.ProcessRecord;
import cs320proj.scheduler.RoundRobinScheduler;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    //Should handle starting the program by cs320proj.loading in the input file and running the cs320proj.scheduler
    //Let things run as defined and then put out audit log
    public static void main(String[] args) {
        try {

            System.out.println("Hello world!");

            Loader loader = new Loader();
            String inputFileName = "textFile.txt";
            int timeSlice = 20;
            List<ProcessRecord> loadedProcesses = loader.loadFile(inputFileName);
            Queue<MyProcess> pList = new LinkedList<>();
            int i = 0;
            for (ProcessRecord loadedProcess : loadedProcesses) {
                System.out.println(loadedProcess);
                pList.add(new MyProcess(loadedProcess.runTime, i++, loadedProcess.processName));
            }

            RoundRobinScheduler rr = new RoundRobinScheduler(timeSlice);

            long la = (long) 18.57;
            long lb = (long) 283.0;
            long lc = (long) 17.5;
            long ld = (long) 221.1;

            MyProcess a = new MyProcess(la, 1, "P1");
            MyProcess b = new MyProcess(lb, 2, "P2");
            MyProcess c = new MyProcess(lc, 3, "P3");
            MyProcess d = new MyProcess(ld, 4, "P4");


       /* pList.add(a);
        pList.add(b);
        pList.add(c);
        pList.add(d);*/

            rr.loadProgram(pList);

            int num = 0;
            while (!(rr.processes.isEmpty())) {
                num++;
                System.out.println("Run " + num + ": ");
                System.out.println(rr.runNext());
            }

            System.out.println(rr.getDoneList());

            Auditor auditor = new Auditor(rr.getDoneList());
            String auditLogName = inputFileName + "-" + timeSlice + "-ticks.csv";


            auditor.printAuditLog(auditLogName);

            System.out.println("Running programs took " + rr.getCurrentTick() + " ticks");
            System.out.println("It took " + num + " slices");
            System.out.println("With a timeslice of " + timeSlice + " ticks");
            System.out.println("Results printed to: " + auditLogName);


            //Call Loader to get list of ProcessRecords

            //Turn ProcessRecords into Processes

            //Create Scheduler Object

            //Pass processes to cs320proj.scheduler

            //Recieve finished processes from cs320proj.scheduler

            //Pass finished Processes to cs320proj.Auditor
           // System.out.println("Hello world!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

