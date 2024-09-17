import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleStringProperty bookName = new SimpleStringProperty(this, "bookName", "");
    private SimpleStringProperty authorName = new SimpleStringProperty(this, "authorName", "");
    private SimpleStringProperty genre = new SimpleStringProperty(this, "genre", "");
    private final SimpleStringProperty bookStatus;

    public Book(String bookName, String authorName, String genre) {
        this.bookName.set(bookName);
        this.authorName.set(authorName);
        this.genre.set(genre);
        this.bookStatus = new SimpleStringProperty("Available");
    }

    // Book name Properties
    public final SimpleStringProperty bookNameProperty() {
        return this.bookName;
    }
    public final String getBookName() {
        return this.bookNameProperty().get();
    }
    public final void setBookName(final String bookName) {
        this.bookNameProperty().set(bookName);
    }

    // Author Name Properties
    public final SimpleStringProperty authorNameProperty() {
        return this.authorName;
    }
    public final String getAuthorName() {
        return this.authorNameProperty().get();
    }
    public final void setAuthorName(final String authorName) {
        this.authorNameProperty().set(authorName);
    }

    // Book Genre Properties
    public final SimpleStringProperty genreProperty() {
        return this.genre;
    }
    public final String getGenre() {
        return this.genreProperty().get();
    }
    public final void setGenre(final String genre) {
        this.genreProperty().set(genre);
    }

    public final SimpleStringProperty bookStatusProperty() {
        return this.bookStatus;
    }
    public final String getBookStatus() {
        return this.bookStatus.get();
    }
    public final void setBookStatus(String bookStatus) {
        this.bookStatus.set(bookStatus);
    }
}
