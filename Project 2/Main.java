import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene mainMenuScene, bookViewScene, roomViewScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Menu");

        // Initialize Data
        ObservableList<Room> roomList = FXCollections.observableArrayList(
            new Room(101, 1, "CONFERENCE"),
            new Room(102, 1, "INDIVIDUAL"),
            new Room(103, 1, "INDIVIDUAL"),
            new Room(104, 1, "CONFERENCE"),
            new Room(105, 1, "INDIVIDUAL"),
            new Room(201, 2, "CONFERENCE"),
            new Room(202, 2, "INDIVIDUAL"),
            new Room(203, 2, "INDIVIDUAL"),
            new Room(204, 2, "CONFERENCE"),
            new Room(205, 2, "CONFERENCE"),
            new Room(301, 3, "INDIVIDUAL"),
            new Room(302, 3, "CONFERENCE"),
            new Room(303, 3, "CONFERENCE"),
            new Room(304, 3, "INDIVIDUAL"),
            new Room(305, 3, "CONFERENCE")
        );
        ObservableList<Book>  bookList = FXCollections.observableArrayList(
            new Book("To kill", "Sam","horror"),
            new Book("To Kill a Mockingbird", "Harper Lee", "CLASSIC"),
            new Book("1984", "George Orwell", "SCIENCE_FICTION"),
            new Book("Pride and Prejudice", "Jane Austen", "ROMANCE"),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", "CLASSIC"),
            new Book("Moby Dick", "Herman Melville", "CLASSIC"),
            new Book("War and Peace", "Leo Tolstoy", "HISTORICAL"),
            new Book("The Catcher in the Rye", "J.D. Salinger", "FICTION"),
            new Book("The Hobbit", "J.R.R. Tolkien", "FANTASY"),
            new Book("Crime and Punishment", "Fyodor Dostoevsky", "CLASSIC"),
            new Book("The Odyssey", "Homer", "CLASSIC"),
            new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "CLASSIC"),
            new Book("Brave New World", "Aldous Huxley", "SCIENCE_FICTION"));
        Label uLabel = new Label("UTS LIBRARY");
        uLabel.setFont(new Font(50));
        Label qLabel = new Label("What would you like to reserve today ?");
        qLabel.setFont(new Font(15));
        // BookView and RoomView Initialization
        BookView bookView = new BookView(primaryStage);
        new BookController(bookView, bookList);
        bookViewScene = bookView.getBookTable().getScene();

        RoomView roomView = new RoomView();
        RoomController controller = new RoomController(roomList, roomView);
        roomViewScene = new Scene(roomView.getTableView(), 600, 400);

        // Create Main Menu
        Button bookViewButton = new Button("Go to Book View");
        Button roomViewButton = new Button("Go to Room View");

        bookViewButton.setOnAction(e -> primaryStage.setScene(bookViewScene));
        roomViewButton.setOnAction(e -> roomView.start(primaryStage, roomList));

        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(20));
        menuLayout.getChildren().addAll(uLabel, qLabel, bookViewButton, roomViewButton);

        mainMenuScene = new Scene(menuLayout, 600, 400);

        // Set the Main Menu Scene
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
