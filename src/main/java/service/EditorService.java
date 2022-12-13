package service;

import entity.Editor;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class EditorService {

	private Repository<Editor> editorRepository;

	public void addEditor(Editor editor) {
		editorRepository.add(editor);
	}

	public void updateEditor(Editor editor) {
		editorRepository.update(editor);
	}

	public void deleteEditor(Integer id) {
		editorRepository.deleteById(id);
	}

	public List<Editor> getAllEditors(Integer id) {
		return editorRepository.findAll();
	}

}
