package se.mete.springinloggning.component;

import se.mete.springinloggning.model.ManagerInfo;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component // Bean, registered in Spring Application Context, auto-detection, used for DI
public class ManagerComponent {
    /**
     * @return List<ManagerInfo> = a list of documents to shown in admin and manager pages
     */
    public List<ManagerInfo> documentList() {
        List<ManagerInfo> mylist2 = new ArrayList<>();

        mylist2.add(new ManagerInfo("Employee Performance Reviews Q1 2023", "Contains performance evaluations for all employees for the first quarter of 2023."));
        mylist2.add(new ManagerInfo("Project Alpha Budget Report", "Detailed budget breakdown and expenditure report for Project Alpha."));
        mylist2.add(new ManagerInfo("Annual Strategy Meeting Minutes", "Minutes from the annual strategy meeting held on January 15, 2023."));
        mylist2.add(new ManagerInfo("IT Infrastructure Upgrade Plan", "Proposal and timeline for upgrading the company's IT infrastructure."));
        mylist2.add(new ManagerInfo("Client Feedback Summary", "Compilation of client feedback received during Q2 2023."));

        return mylist2;
    }
}
