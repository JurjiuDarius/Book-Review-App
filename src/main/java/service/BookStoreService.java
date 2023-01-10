package service;
import entity.Book;
import entity.BookStore;
import exception.BadValueException;
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

    public List<Book> booksForBookStore(String name) throws BadValueException {
        List<BookStore> bookStores = bookStoreRepository.findAll().stream().filter(store -> store.getName().equals(name)).toList();
        if (bookStores.isEmpty()) {
            throw new BadValueException("Store name does not exist");
        }

        return bookStores.get(0).getBooks();

    }


}
