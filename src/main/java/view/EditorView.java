package view;

import entity.Editor;

import java.util.List;
import java.util.Scanner;

public class EditorView {

    public void displayEditor(Editor editor) {
        System.out.println(editor);
    }

    public void displayEditors(List<Editor> editors) {
        for (Editor editor : editors) {
            System.out.println(editor);
        }
    }

    public Editor newEditor() {
        Editor editor;
        Scanner menu = new Scanner(System.in);
        System.out.println(" Establishment Year");
        int establishmentYear = menu.nextInt();
        menu.nextLine();
        System.out.println("Enter Name: ");
        String name = menu.nextLine();
        editor = Editor.builder().establishmentYear(establishmentYear).name(name).build();
        return editor;
    }

}