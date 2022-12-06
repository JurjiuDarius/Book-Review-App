package entity;

public class Review extends Identifiable {
    public String text;
    public int publicationDate;


    public Review(String text, int publicationDate,int id) {
        super(id);
        this.text = text;
        this.publicationDate = publicationDate;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

}
