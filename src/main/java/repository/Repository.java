package repository;

import entity.Identifiable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class Repository<T extends Identifiable> implements CrudRepositoryInterface<T> {

    private final EntityManager entityManager;
    private final String className;
    private List<T> entities;

    public Repository(EntityManager entityManager, String className) {
        this.className = className;
        this.entityManager = entityManager;
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT entity FROM " + className + " entity").getResultList();
    }

    public Optional<T> findById(Integer id) {
        List<T> list = entityManager.createQuery("SELECT entity FROM " + className + " entity WHERE entity.id=" + id.toString()).getResultList();
        if (list.isEmpty()) {
            return Optional.empty();
        } else return Optional.of(list.get(0));
    }

    public void deleteById(Integer id) throws EntityNotFoundException {
        Optional<T> optional = this.findById(id);
        if (!optional.isEmpty()) {
            entityManager.getTransaction().begin();
            entityManager.remove(optional.get());
            entityManager.getTransaction().commit();
        }
    }

    public T add(T element) {
        entityManager.getTransaction().begin();
        entityManager.persist(element);
        entityManager.getTransaction().commit();
        return element;
    }

    public T update(T element) {
        entityManager.getTransaction().begin();
        entityManager.merge(element);
        entityManager.getTransaction().commit();
        return element;
    }

}
