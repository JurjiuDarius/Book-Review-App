package service;

import entity.BookStore;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class BookStoreService {

    private Repository<BookStore> bookStoreRepository;

    public void addBookStore(BookStore bookStore) {
        bookStoreRepository.add(bookStore);
    }

    public void updateBookStore(BookStore bookStore) {
        bookStoreRepository.update(bookStore);
    }

    public void deleteBookStore(Integer id) {
        bookStoreRepository.deleteById(id);
    }

    public List<BookStore> getAllBookStores(Integer id) {
        return bookStoreRepository.findAll();
    }

}
