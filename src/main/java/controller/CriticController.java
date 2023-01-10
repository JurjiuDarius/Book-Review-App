package controller;

import entity.User;
import lombok.AllArgsConstructor;
import service.CriticService;

@AllArgsConstructor
public class CriticController {

    //
    private CriticService criticService;

    public void addReview(User critic, Integer bookId, String text) {
        criticService.addReview(critic, bookId, text);
    }

}
