package test;

import entity.Editor;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.EditorService;

public class EditorServiceTest {
    @Mock
    private Repository<Editor> editorRepository;
    @Mock
    private EditorService editorService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        editorService = new EditorService(editorRepository);


    }

    @Test

    void addEditorTest(){
        Editor editor = Editor.builder().id(2).build();

        try {
            editorService.add(editor);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void deleteEditorTest(){
        Editor editor = Editor.builder().id(2).build();
        try {
            editorService.deleteById(editor.getId());
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void updateEditorTest(){
        Editor editor = Editor.builder().id(2).build();
        try {
            editorService.update(editor);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}


