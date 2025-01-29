package se.mete.springinloggning.model;

public class ManagerInfo {
    private String title;
    private String description;

    public ManagerInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
