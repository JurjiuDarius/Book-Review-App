package view;

import entity.Editor;

import java.util.List;

public class EditorView {

    public void displayEditor(Editor editor){
        System.out.println(editor);
    }
    public void displayEditors(List<Editor> editors){
        for(Editor editor:editors){
            System.out.println(editor);
        }
    }

}