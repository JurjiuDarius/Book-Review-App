package service;

import entity.BookStore;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class BookStoreService {

    private Repository<BookStore> bookStoreRepository;

    public BookStore add(BookStore bookStore) {
        return bookStoreRepository.add(bookStore);
    }

    public BookStore update(BookStore bookStore) {
        return bookStoreRepository.update(bookStore);
    }

    public void deleteById(Integer id) {
        bookStoreRepository.deleteById(id);
    }

    public BookStore findById(Integer id) {
        return bookStoreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BookStore not found!"));
    }

    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

}
