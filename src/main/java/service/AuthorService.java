package service;

import entity.Author;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class AuthorService {

    private Repository<Author> authorRepository;

    public void addAuthor(Author author) {
        authorRepository.add(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.update(author);
    }

    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    public List<Author> getAllAuthors(Integer id) {
        return authorRepository.findAll();
    }

}
