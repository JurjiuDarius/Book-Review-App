package service;

import entity.Author;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AuthorService {

    private Repository<Author> authorRepository;

    public Author add(Author author) {
        return authorRepository.add(author);
    }

    public Author update(Author author) {
        return authorRepository.update(author);
    }

    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }

    public Author findById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author not found!"));
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> authorsOlderThan(int year) {
        return authorRepository.findAll().stream().filter(el -> el.getBirthYear() > year).collect(Collectors.toList());
    }

    public List<Author> authorsSortedByYear() {
        return authorRepository.findAll().stream().sorted(Comparator.comparingInt(Author::getBirthYear)).collect(Collectors.toList());
    }

    public List<Author> authorsSortedByName() {
        return authorRepository.findAll().stream().sorted(Comparator.comparing(Author::getName)).collect(Collectors.toList());
    }

    public List<Author> authorsSortedByBooks() {
        return authorRepository.findAll().stream().sorted(Comparator.comparingInt(author -> author.getBooks().size())).collect(Collectors.toList());
    }

}
