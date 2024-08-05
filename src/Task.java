public class Task {
    public String name;
    public String description;
    public Integer id;
    Status status;

    public Task (String name, String description, Integer id, Status status) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.status = status;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId () {
        return id;
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    public Status getStatus () {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + ", " + description + ", " + id + ", " + status;
    }
}

enum Status {
    NEW,
    IN_PROGRESS,
    DONE
}
