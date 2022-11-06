package controller;

import entity.Critic;
import exception.BadValueException;
import repository.Repository;
import view.CriticView;

import java.util.Optional;

public class CriticController {

    private Repository<Critic> criticRepository;
    private CriticView criticView;

    public CriticController(Repository<Critic> repository,CriticView criticView) {
        this.criticRepository=repository;
        this.criticView=criticView;
    }
    public Critic addCritic(Critic critic) throws BadValueException{
        if(critic.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return criticRepository.add(critic);
    }
    public Critic updateCritic(Critic critic) throws BadValueException{
        if(critic.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return criticRepository.update(critic);
    }
    public void deleteCriticById(int id) throws BadValueException {
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        criticRepository.deleteById(id);
    }
    public void displayAll(){

        criticView.displayCritics(criticRepository.findAll());
    }
    public void displayById(int id) throws BadValueException {
        Optional<Critic> criticOptional=criticRepository.findById(id);
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        if(!criticOptional.isEmpty()) {
            criticView.displayCritic(criticOptional.get());
        }
    }

}
