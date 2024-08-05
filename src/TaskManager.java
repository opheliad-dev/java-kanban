import java.util.ArrayList;
import java.util.HashMap;
public class TaskManager {

    int id = 1;
    HashMap <Integer, Task> idToTask = new HashMap<>();
    HashMap <Integer, Epic> idToEpic = new HashMap<>();
    HashMap <Integer, SubTask> idToSubTask = new HashMap<>();

    Task addTask (Task newTask) {
        int newId = id++;
        newTask.setId(newId);
        idToTask.put(newTask.getId(), newTask);
        return newTask;
    }

    SubTask addSubTask (SubTask newSubTask) {
        int newId = id++;
        newSubTask.setId(newId);
        if (idToEpic.containsKey(newSubTask.getEpicId())) {
            Epic epicSubTask = idToEpic.get(newSubTask.getEpicId());
            epicSubTask.subtasksId.add(newSubTask.getId());
        } else {
            System.out.println("Epic с таким id не найден");
            return null;
        }
        idToSubTask.put(newSubTask.getId(), newSubTask);
        return newSubTask;
    }
    Epic addEpic (Epic newEpic) {
        int newId = id++;
        newEpic.setId(newId);
        idToEpic.put(newEpic.getId(), newEpic);
        return newEpic;
    }

    Task updateTask (Task updatedTask) {
        int id = updatedTask.getId();
        if (idToTask.containsKey(id)) {
            idToTask.put(id, updatedTask);
        } else {
            return null;
        }
        return updatedTask;
    }

    SubTask updateSubTask (SubTask updatedTask) {
        int id = updatedTask.getId();
        if (idToSubTask.containsKey(id)) {
            idToSubTask.put(id, updatedTask);
        } else {
            return null;
        }
        Epic epicSubTask = idToEpic.get(updatedTask.getEpicId());
        int countDone = 0;
        int countNew = 0;
        for (Integer i : epicSubTask.subtasksId) {
            SubTask task = idToSubTask.get(i);
            if (task.status.equals(Status.DONE))
                countDone++;
            else if ((task.status.equals(Status.NEW)))
                countNew++;
        }
        if (countDone == epicSubTask.subtasksId.size())
            epicSubTask.setStatus(Status.DONE);
        else if (countNew == epicSubTask.subtasksId.size())
            epicSubTask.setStatus(Status.NEW);
        else
            epicSubTask.setStatus(Status.IN_PROGRESS);
        return updatedTask;
    }

    Epic updateEpic (Epic updatedEpic) {
        int id = updatedEpic.getId();
        if (idToEpic.containsKey(id)) {
            idToEpic.put(id, updatedEpic);
        } else {
            return null;
        }
        return updatedEpic;
    }

    public Task deleteTask (Integer id) {
        Task task = idToTask.get(id);
        idToTask.remove(id);
        return task;
    }

    public SubTask deleteSubTask (Integer id) {
        SubTask task = idToSubTask.get(id);
        idToSubTask.remove(id);
        return task;
    }

    public Epic deleteEpic (Integer id) {
        Epic epicTask = idToEpic.get(id);
        idToEpic.get(id).subtasksId.clear();
        idToEpic.remove(id);
        return epicTask;
    }

    HashMap <Integer, Task> getAllTasks () {
        return idToTask;
    }

    HashMap <Integer, SubTask> getAllSubTasks () {
        return idToSubTask;
    }

    HashMap <Integer, Epic> getAllEpics () {
        return idToEpic;
    }

    void removeAllTasks () {
        idToTask.clear();
    }

    void removeAllSubTasks () {
        idToSubTask.clear();
    }

    void removeAllEpics () {
        idToEpic.clear();
    }

    Task getTaskById (Integer id) {
        return idToTask.get(id);
    }

    SubTask getSubTaskById (Integer id) {
        return idToSubTask.get(id);
    }

    Epic getEpicById (Integer id) {
        return idToEpic.get(id);
    }

    ArrayList<SubTask> getSubTasksOfEpic (Integer id) {
        Epic epicTask = idToEpic.get(id);
        ArrayList<SubTask> subTasks = new ArrayList<>();
        for (Integer i : epicTask.subtasksId) {
            subTasks.add(idToSubTask.get(i));
        }
        return subTasks;
    }
}
