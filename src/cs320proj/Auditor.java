package cs320proj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Auditor {

    public List<AuditRecord> auditRecords;
    //Receives List of completed processes from cs320proj.Main program
    //Converts them to audit records
    //Writes them out in analyzable format(CSV?)

    //May need to add a no. of runs field to the process class

    public Auditor(Iterable<MyProcess> processes) {
        auditRecords = new ArrayList<>();
        for (MyProcess process : processes) {
            AuditRecord ar = new AuditRecord(process.processID, process.processName, process.timeRan + process.totalTimeWait, process.timeRan, process.totalTimeWait / process.timesRan, process.totalTimeWait, process.timesRan, process.normalizedTurnaround);
            auditRecords.add(ar);

        }
    }

    public void printAuditLog(String filename) throws Exception {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("PID,processName,totalTicks,runningTicks,avgWait,waitingTime,numTurns" + System.lineSeparator());
            for (AuditRecord auditRecord : auditRecords) {
                System.out.println(auditRecord.toString());
                String csvRecord = auditRecord.PID +
                        ",\"" + auditRecord.processName + '\"' +
                        "," + auditRecord.totalTicks +
                        "," + auditRecord.runningTicks +
                        "," + auditRecord.avgWait +
                        "," + auditRecord.waitingTime +
                        "," + auditRecord.numTurns +

                        System.lineSeparator();
                writer.write(csvRecord);

            }

            writer.close();
        } catch (IOException e) {
            throw new Exception("Couldn't write to file",e);
        }
    }
}
