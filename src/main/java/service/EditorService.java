package service;

import entity.Editor;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

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

}
