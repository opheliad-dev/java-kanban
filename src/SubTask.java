public class SubTask extends Task {
    Integer epicId;
    SubTask (String name, String description, Integer id, Status status, Integer epicId) {
        super (name, description, id, status);
        this.epicId = epicId;
    }

    public Integer getEpicId() {
        return epicId;
    }
}
