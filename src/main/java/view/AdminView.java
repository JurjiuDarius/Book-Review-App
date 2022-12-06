package view;

import entity.Admin;
import java.util.List;

public class AdminView {

    public void displayAdmin(Admin admin){
        System.out.println(admin);
    }
    public void displayAdmins(List<Admin> admins){
        for(Admin admin:admins){
            System.out.println(admin);
        }
    }

}
