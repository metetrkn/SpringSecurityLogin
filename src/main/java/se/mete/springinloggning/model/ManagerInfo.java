package se.mete.springinloggning.model;

import lombok.Data;


@Data // Lombok annotation, automatic getters and setters
public class ManagerInfo {
    private String title;
    private String description;


    /**
     * Parametrised constructor
     *
     * @param title = the name/title of document
     * @param description = description to related document
     */
    public ManagerInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
