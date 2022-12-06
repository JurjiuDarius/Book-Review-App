package controller;

import entity.Admin;
import exception.BadValueException;
import repository.Repository;
import view.AdminView;

import java.util.Optional;

public class AdminController {

    private Repository<Admin> adminRepository;
    private AdminView adminView;

    public AdminController(Repository<Admin> repository,AdminView adminView) {
        this.adminRepository=repository;
        this.adminView=adminView;
    }
    public Admin addAdmin(Admin admin) throws BadValueException{
        if(admin.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return adminRepository.add(admin);
    }
    public Admin updateAdmin(Admin admin) throws BadValueException{
        if(admin.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return adminRepository.update(admin);
    }
    public void deleteAdminById(int id) throws BadValueException {
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        adminRepository.deleteById(id);
    }
    public void displayAll(){

        adminView.displayAdmins(adminRepository.findAll());
    }
    public void displayById(int id) throws BadValueException {
        Optional<Admin> adminOptional=adminRepository.findById(id);
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        if(!adminOptional.isEmpty()) {
            adminView.displayAdmin(adminOptional.get());
        }
    }

}
