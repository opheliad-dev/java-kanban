public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Task task1 = new Task("помыть посуду", "помыть ложку и вилку", 1234, Status.NEW);
        Task task2 = new Task("убраться в квартире", "вынести мусор", 4534, Status.NEW);
        Epic epic1 = new Epic("эпик1", "эпик1d", 8452, Status.NEW);
        SubTask subTask1 = new SubTask("сабтаск1", "сабтаск1d", 9094,Status.NEW,3);
        SubTask subTask2 = new SubTask("сабтаск2", "сабтаск2d", 9091,Status.NEW,3);
        Epic epic2 = new Epic("эпик2", "эпик2d", 8450, Status.NEW);
        SubTask subTask3 = new SubTask("сабтаск3", "сабтаск3d", 9074,Status.NEW,4);
        System.out.println(manager.addTask(task1));
        System.out.println(manager.addTask(task2));
        System.out.println(manager.addEpic(epic1));
        System.out.println(manager.addEpic(epic2));
        System.out.println(manager.addSubTask(subTask1));
        System.out.println(manager.addSubTask(subTask2));
        System.out.println(manager.addSubTask(subTask3));
        System.out.println("-----------------------------------------------------------------------------------------");
        task1.setStatus(Status.DONE);
        task2.setStatus(Status.IN_PROGRESS);
        subTask1.setStatus(Status.DONE);
        subTask2.setStatus(Status.DONE);
        subTask3.setStatus(Status.IN_PROGRESS);
        manager.updateTask(task1);
        manager.updateTask(task2);
        manager.updateSubTask(subTask1);
        manager.updateSubTask(subTask2);
        manager.updateSubTask(subTask3);
        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllSubTasks());
        System.out.println(manager.getAllEpics());
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(manager.getSubTasksOfEpic(3));
        System.out.println("-----------------------------------------------------------------------------------------");
        manager.deleteTask(1);
        manager.deleteEpic(3);
        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubTasks());
    }
}
