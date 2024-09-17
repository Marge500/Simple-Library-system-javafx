import javafx.collections.ObservableList;

public class RoomController {
    //Calling the View and Models to interact with each other 
    private final ObservableList<Room> roomList;
    private final RoomView view;

    public RoomController(ObservableList<Room> roomList, RoomView view) {
        this.roomList = roomList;
        this.view = view;
        Controller();
    }

    private void Controller() {
        view.getBookButton().setOnAction(e -> bookSelectedRooms());
    }

    private void bookSelectedRooms() {
        ObservableList<Room> selectedRooms = view.getTableView().getSelectionModel().getSelectedItems();
        for (Room room : selectedRooms) {
            room.setRoomStatus("booked");
        }
        view.getTableView().refresh(); // Refresh the table to show the updated status
    }
}
