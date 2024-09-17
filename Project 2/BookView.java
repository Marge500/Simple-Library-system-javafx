import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookView {

    private TableView<Book> bookTable;
    private Button bookButton;
    private TextField searchField;

    public BookView(Stage primaryStage) {
        primaryStage.setTitle("Library Book Manager");

        // Initialize the TableView and its columns
        bookTable = new TableView<>();
        
        TableColumn<Book, String> bookNameColumn = new TableColumn<>("Book Name");
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));

        TableColumn<Book, String> authorNameColumn = new TableColumn<>("Author Name");
        authorNameColumn.setCellValueFactory(new PropertyValueFactory<>("authorName"));

        TableColumn<Book, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Book, String> bookStatusColumn = new TableColumn<>("Status");
        bookStatusColumn.setCellValueFactory(new PropertyValueFactory<>("bookStatus"));

        bookTable.getColumns().addAll(bookNameColumn, authorNameColumn, genreColumn, bookStatusColumn);

        // Initialize the buttons and search field
        bookButton = new Button("Book Selected Book(s)");
        searchField = new TextField();
        searchField.setPromptText("Search");

        // Layout
        GridPane inputPane = new GridPane();
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.setPadding(new Insets(10));
        inputPane.add(bookButton, 0, 0);
        

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(searchField, bookTable, inputPane);

        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public TableView<Book> getBookTable() {
        return bookTable;
    }

    public Button getBookButton() {
        return bookButton;
    }

    public TextField getSearchField() {
        return searchField;
    }
}
