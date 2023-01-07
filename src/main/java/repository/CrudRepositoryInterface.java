package repository;

import entity.Identifiable;

import java.util.List;
import java.util.Optional;

public interface CrudRepositoryInterface<T extends Identifiable> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    void deleteById(Integer id);

    T update(T element);

    T add(T element);

}
