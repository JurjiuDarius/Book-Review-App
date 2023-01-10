package controller;

import entity.Editor;
import exception.BadValueException;
import service.EditorService;
import view.BookView;
import view.EditorView;

public class EditorController {

    private final EditorService editorService;
    private final EditorView editorView;
    private final BookView bookView;

    public EditorController(EditorService editorService, EditorView editorView, BookView bookView) {
        this.editorService = editorService;
        this.editorView = editorView;
        this.bookView = bookView;
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

    public void displayBooksForEditor(String name) throws BadValueException {
        bookView.displayBooks(editorService.booksForEditor(name));
    }


}

