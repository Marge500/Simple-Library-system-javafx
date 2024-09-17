import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class BookController {

    private BookView view;
    private FilteredList<Book> filteredList;

    public BookController(BookView view, ObservableList<Book> bookList) {
        this.view = view;
        this.filteredList = new FilteredList<>(bookList, p -> true);
        view.getBookTable().setItems(filteredList);

        Controller();
    }

    private void Controller() {
        view.getBookButton().setOnAction(e -> bookSelectedBooks());
        view.getSearchField().textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(book -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (book.getBookName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (book.getAuthorName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (book.getGenre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
    }

    private void bookSelectedBooks() {
        for (Book book : view.getBookTable().getSelectionModel().getSelectedItems()) {
            book.setBookStatus("Booked");
        }
    }
}
