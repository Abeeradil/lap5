package org.example.lap52.Model;

import lombok.Data;

@Data
public class Project {
    public int ID;
    public String title;
    public String description;
    public boolean status;
    public String companyName;

    public String getStatus() {
        if (status) {
            return "Done";
        } else {
            return "Not Done";
        }
    }

}