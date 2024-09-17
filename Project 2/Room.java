import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Room {
    //The varibles for Room Object
    private final SimpleIntegerProperty roomNum;
    private final SimpleIntegerProperty floorNum;
    private final SimpleStringProperty roomType;
    private final SimpleStringProperty roomStatus;

    //Constructor for the Room object
    public Room(int roomNum, int floorNum, String roomType) {
        this.roomNum = new SimpleIntegerProperty(roomNum);
        this.floorNum = new SimpleIntegerProperty(floorNum);
        this.roomType = new SimpleStringProperty(roomType);
        this.roomStatus = new SimpleStringProperty("Available");
    }
    //Property for Room Object
    public final SimpleIntegerProperty roomNumProperty() {
        return this.roomNum;
    }

    public final SimpleIntegerProperty floorNumProperty() {
        return this.floorNum;
    }

    public final SimpleStringProperty roomTypeProperty() {
        return this.roomType;
    }

    public final SimpleStringProperty roomStatusProperty() {
        return this.roomStatus;
    }
    //Setters and Getters for the Room Object's Data
    public int getRoomNum() {
        return roomNum.get();
    }

    public void setRoomNum(int roomNum) {
        this.roomNum.set(roomNum);
    }

    public int getFloorNum() {
        return floorNum.get();
    }

    public void setFloorNum(int floorNum) {
        this.floorNum.set(floorNum);
    }

    public String getRoomType() {
        return roomType.get();
    }

    public void setRoomType(String roomType) {
        this.roomType.set(roomType);
    }

    public String getRoomStatus() {
        return roomStatus.get();
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus.set(roomStatus);
    }
}
