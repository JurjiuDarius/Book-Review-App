package repository;

import entity.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository <T extends Identifiable>{

	public Repository() {
		this.entities = new ArrayList<>();
	}

	private List<T> entities;

	public List<T> findAll(){
		return entities;
	}
	public Optional<T> findById(int id) {
		for(T entity:entities)
		{
			if(entity.getId()==id)
				return Optional.of(entity);
		}
		return Optional.empty();

	}
	public void deleteById(int id){
		for(T entity:entities){
			if(entity.getId()==id){
				entities.remove(entity);
			}
		}
	}
	public T add(T element){
		entities.add(element);
		return element;
	}
	public T update(T element){
		for(int i=0;i<=entities.size();i++){
			if(entities.get(i).getId()==element.getId()){
				entities.set(i,element);
				return element;
			}
		}
		return null;
	}

}
