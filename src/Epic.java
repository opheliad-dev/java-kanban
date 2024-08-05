import java.util.ArrayList;
public class Epic extends Task {
    ArrayList<Integer> subtasksId = new ArrayList<>();
    Epic(String name, String description, Integer id, Status status) {
        super(name, description, id, status);
    }
}
