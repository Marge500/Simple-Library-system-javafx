import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoomView {

    private final TableView<Room> tableView = new TableView<>();
    private final TextField searchField = new TextField();
    private final Button bookButton = new Button("Book Selected Room");

    public void start(Stage primaryStage, ObservableList<Room> roomList) {
        primaryStage.setTitle("Room Table");

        // Create a Filtered List for searching
        FilteredList<Room> filteredList = new FilteredList<>(roomList, p -> true);
        tableView.setItems(filteredList);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Define columns
        TableColumn<Room, Number> roomNumColumn = new TableColumn<>("Room Number");
        roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty());

        TableColumn<Room, Number> floorNumColumn = new TableColumn<>("Floor Number");
        floorNumColumn.setCellValueFactory(cellData -> cellData.getValue().floorNumProperty());

        TableColumn<Room, String> roomTypeColumn = new TableColumn<>("Room Type");
        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());

        TableColumn<Room, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().roomStatusProperty());

        tableView.getColumns().addAll(roomNumColumn, floorNumColumn, roomTypeColumn, statusColumn);

        // Search bar
        searchField.setPromptText("Search");

        // Layout of the Room Table
        GridPane inputPane = new GridPane();
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.setPadding(new Insets(10));
        inputPane.add(bookButton, 3, 0);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(searchField, tableView, inputPane);

        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Using the filtering when the user types in the search bar
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(room -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(room.getRoomNum()).contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(room.getFloorNum()).contains(lowerCaseFilter)) {
                    return true;
                } else if (room.getRoomType().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (room.getRoomStatus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
    }

    public TableView<Room> getTableView() {
        return tableView;
    }

    public Button getBookButton() {
        return bookButton;
    }
}
