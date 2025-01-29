package se.mete.springinloggning.component;

import se.mete.springinloggning.model.ManagerInfo;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerComponent {
    public List<ManagerInfo> documentList() {
        List<ManagerInfo> mylist2 = new ArrayList<>();
        mylist2.add(new ManagerInfo("Dokument A", "Detta är det första dokumentet för manager."));
        mylist2.add(new ManagerInfo("Dokument B", "Detta är det andra dokumentet för manager."));
        mylist2.add(new ManagerInfo("Dokument C", "Detta är det tredje dokumentet för manager."));
        return mylist2;
    }
}
