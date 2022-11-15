package test;

import controller.EditorController;
import entity.Editor;
import entity.Book;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.EditorView;

import java.util.ArrayList;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EditorControllerTest {

    Repository<Editor> editorRepository = new Repository<Editor>();
    EditorView editorView = new EditorView();
    EditorController editorController;

    ArrayList<Book> booklist = new ArrayList<Book>();

    @BeforeAll
    private void setup() {
        editorController = new EditorController(editorRepository, editorView);
    }

    @Test
    void testAdd() {

        Editor editor = new Editor(1,booklist);
        try {
            editorController.addEditor(editor);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testAddFail() {
        Editor editor = new Editor(-2,booklist);
        try {
            editorController.addEditor(editor);

        } catch (BadValueException e) {
            assert (e.getClass().equals(BadValueException.class));
        }
    }

    @Test
    void testUpdateFail() {
        Editor editor = new Editor(1,booklist);
        Editor updateEditor = new Editor(-2,booklist);
        try {
            editorController.addEditor(editor);

        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDelete() {
        Editor editor = new Editor(1,booklist);
        try {
            editorController.deleteEditorById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDeleteFail() {
        Editor editor = new Editor(1,booklist);
        try {
            editorController.deleteEditorById(-2);

        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void displayByIdTest() {
        Editor editor = new Editor(1,booklist);
        try {
            editorController.displayById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void displayByIdFail() {
        Editor editor = new Editor(1,booklist);
        try {
            editorController.displayById(2);
        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }
    }
}
