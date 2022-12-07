package controller;

import entity.Editor;
import exception.BadValueException;
import repository.Repository;
import view.EditorView;

import java.util.Optional;

public class EditorController {

	private final Repository<Editor> editorRepository;
	private final EditorView editorView;

	public EditorController(Repository<Editor> repository, EditorView editorView) {
		this.editorRepository = repository;
		this.editorView = editorView;
	}

	public Editor addEditor(Editor editor) throws BadValueException {
		if (editor.getId() < 0) {
			throw new BadValueException("Ids are positive numbers");
		}

		return editorRepository.add(editor);
	}

	public Editor updateEditor(Editor editor) throws BadValueException {
		if (editor.getId() < 0) {
			throw new BadValueException("Ids are positive numbers");
		}
		return editorRepository.update(editor);
	}

	public void deleteEditorById(int id) throws BadValueException {
		if (id < 0) {
			throw new BadValueException("Ids are positive numbers");
		}
		editorRepository.deleteById(id);
	}

	public void displayAll() {

		editorView.displayEditors(editorRepository.findAll());
	}

	public void displayById(int id) throws BadValueException {
		Optional<Editor> editorOptional = editorRepository.findById(id);
		if (id < 0) {
			throw new BadValueException("Ids are positive numbers");
		}
		if (!editorOptional.isEmpty()) {
			editorView.displayEditor(editorOptional.get());
		}
	}

}

