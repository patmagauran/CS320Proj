package cs320proj;

import cs320proj.loading.Loader;
import cs320proj.loading.ProcessRecord;
import cs320proj.scheduler.HRRNScheduler;
import cs320proj.scheduler.IScheduler;
import cs320proj.scheduler.PriorityScheduler;
import cs320proj.scheduler.RoundRobinScheduler;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    //Should handle starting the program by cs320proj.loading in the input file and running the cs320proj.scheduler
    //Let things run as defined and then put out audit log
    public static void main(String[] args) {
        try {
            int timeSlice = 20;
            IScheduler scheduler;
            String inputFileName = "textFile.txt";
            if (args.length == 1) {
                timeSlice = Integer.parseInt(args[0]);
                scheduler = new RoundRobinScheduler(timeSlice);

            } else if (args.length == 2) {
                timeSlice = Integer.parseInt(args[0]);
                scheduler = new RoundRobinScheduler(timeSlice);
                 inputFileName = args[1];

            } else if (args.length >= 3) {
                timeSlice = Integer.parseInt(args[0]);
                inputFileName = args[1];
                switch (args[2].toLowerCase()) {
                    case "p":
                        scheduler = new PriorityScheduler(timeSlice);
                        break;
                    case "h":
                        scheduler = new HRRNScheduler();
                        break;
                    default:
                        scheduler = new RoundRobinScheduler(timeSlice);
                        break;

                }
            } else {
                scheduler = new RoundRobinScheduler(timeSlice);
            }
            System.out.println("Hello world!");

            Loader loader = new Loader();
            List<ProcessRecord> loadedProcesses = loader.loadFile(inputFileName);
            Queue<MyProcess> pList = new LinkedList<>();
            int i = 0;
            for (ProcessRecord loadedProcess : loadedProcesses) {
                System.out.println(loadedProcess);
                pList.add(new MyProcess(loadedProcess.runTime, i++, loadedProcess.processName, loadedProcess.priority));
            }

           // RoundRobinScheduler scheduler = new RoundRobinScheduler(timeSlice);

          

            scheduler.loadProgram(pList);

            int num = 0;
            while (!(scheduler.getProcesses().isEmpty())) {
                num++;
                System.out.println("Run " + num + ": ");
                System.out.println(scheduler.runNext());
                scheduler.getClock().tick();
                scheduler.getClock().tick();

            }

            System.out.println(scheduler.getDoneList());

            Auditor auditor = new Auditor(scheduler.getDoneList());
            String auditLogName = inputFileName + "-" + timeSlice + "-ticks.csv";


            auditor.printAuditLog(auditLogName);

            System.out.println("Running programs took " + scheduler.getCurrentTick() + " ticks");
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

