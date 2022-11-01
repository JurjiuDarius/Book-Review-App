package entity;

public class Review extends Identifiable {
    public String text;
    public int publication_date;


    public Review(String text, int publication_date,int id) {
        super(id);
        this.text = text;
        this.publication_date = publication_date;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPublication_date() {
        return publication_date;
    }

    public void setPublicationDate(int publication_date) {
        this.publication_date = publication_date;
    }

}
