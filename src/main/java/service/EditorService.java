package service;

import entity.Book;
import entity.Editor;
import exception.BadValueException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EditorService {

    private Repository<Editor> editorRepository;

    public Editor add(Editor editor) {
        return editorRepository.add(editor);
    }

    public Editor update(Editor editor) {
        return editorRepository.update(editor);
    }

    public void deleteById(Integer id) {
        editorRepository.deleteById(id);
    }

    public Editor findById(Integer id) {
        return editorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Editor not found!"));
    }

    public List<Editor> findAll() {
        return editorRepository.findAll();
    }

    public List<Book> booksForEditor(String name) throws BadValueException {
        List<Editor> editors = editorRepository.findAll().stream().filter(editor1 -> editor1.getName().equals(name)).collect(Collectors.toList());
        if (editors.isEmpty()) {
            throw new BadValueException("Editor does not exist");
        }
        return editors.get(0).getBooks();
    }

}
