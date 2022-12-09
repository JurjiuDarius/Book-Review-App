package controller;

import entity.Author;
import entity.Book;
import entity.User;
import lombok.AllArgsConstructor;
import repository.Repository;
import service.AdminService;

@AllArgsConstructor
public class AdminController {
///

	private AdminService adminService;


	public void deleteUserByID(int id){
		adminService.deleteUserById(id);
	}

	public void addAuthor(Author author){
		adminService.addAuthor(author);
	}

	public void addBookForAuth(Integer authorId, Book book){
		adminService.addBookForAuthor(authorId,book);
	}

}
