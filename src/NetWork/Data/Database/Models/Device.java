package NetWork.Data.Database.Models;

import NetWork.Data.Database.Interface.IDatabaseModel;

public class Device implements IDatabaseModel {
    private int Id;
    private String Name;

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }
}
