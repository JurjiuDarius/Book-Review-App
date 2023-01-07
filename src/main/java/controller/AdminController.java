package controller;

import entity.Author;
import lombok.AllArgsConstructor;
import service.AdminService;

@AllArgsConstructor
public class AdminController {
///

    private AdminService adminService;

    public void deleteUserByID(int id) {
        adminService.deleteUserById(id);
    }

    public void addAuthor(Author author) {
        adminService.addAuthor(author);
    }

    public void addBookForAuth(Integer authorId, Integer bookId) {
        adminService.addBookForAuthor(authorId, bookId);
    }

    public void addBookToBookstore(Integer bookId, Integer bookStoreId) {
        adminService.addBookToBookStore(bookId, bookStoreId);
    }

    public void addBookToEditor(Integer bookId, Integer editorId) {
        adminService.addBookToEditor(bookId, editorId);
    }

}
