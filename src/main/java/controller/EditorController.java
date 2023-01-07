package controller;

import entity.Editor;
import exception.BadValueException;
import service.EditorService;
import view.EditorView;

public class EditorController {

    private final EditorService editorService;
    private final EditorView editorView;

    public EditorController(EditorService editorService, EditorView editorView) {
        this.editorService = editorService;
        this.editorView = editorView;
    }

    public Editor addEditor(Editor editor) throws BadValueException {
        if (editor.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return editorService.add(editor);
    }

    public Editor updateEditor(Editor editor) throws BadValueException {
        if (editor.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return editorService.update(editor);
    }

    public void deleteEditorById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        editorService.deleteById(id);
    }

    public void displayAll() {
        editorView.displayEditors(editorService.findAll());
    }

    public void displayById(int id) throws BadValueException {

        editorView.displayEditor(editorService.findById(id));

    }

}

