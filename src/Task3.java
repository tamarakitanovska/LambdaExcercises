import static domain.Task.getTasks;
import static java.lang.System.*;

import domain.Task;
import domain.TaskType;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {

        List<Task> tasks = getTasks();

        System.out.println("=====Task with longest title=====");
        Task taskWithLongesTitle = tasks.stream()
                .sorted(Comparator.comparing(Task::getTitleSize).reversed())
                .findFirst()
                .get();

        System.out.println(taskWithLongesTitle.getTitle());


        System.out.println("\n"+"=====Count total number of tags=====");
        long numberOfTags = tasks.stream()
                .flatMap(t->t.getTags().stream())
                .count();

        System.out.println(numberOfTags);


        System.out.println("\n"+"=====Generate summary of Task titles=====");
        List<String> taskTitles = tasks.stream()
                .map(t->t.getTitle())
                .collect(Collectors.toList());

        taskTitles.stream()
                .forEach(System.out::println);


        System.out.println("\n"+"=====Grouping tasks by type=====");
        Map<TaskType,List<Task>> tasksByType =  tasks.stream()
                .collect(Collectors.groupingBy(Task::getType));

        tasksByType.entrySet().stream()
                .forEach(System.out::println);


        System.out.println("\n"+"=====Grouping tasks by type and createdOn=====");
        Map<TaskType,Map<LocalDate,List<Task>>> tasksByTypeAndCreatedOn =  tasks.stream()
                .collect(Collectors.groupingBy(Task::getType, Collectors.groupingBy(Task::getCreatedOn)));

        tasksByTypeAndCreatedOn.entrySet().stream()
                .forEach(System.out::println);


//        Map<TaskType, List<Task>> allTasksByType = new HashMap<>();
//        for (Task task : tasks) {
//            List<Task> existingTasksByType = allTasksByType.get(task.getType());
//            if (existingTasksByType == null) {
//                List<Task> tasksByType = new ArrayList<>();
//                tasksByType.add(task);
//                allTasksByType.put(task.getType(), tasksByType);
//            } else {
//                existingTasksByType.add(task);
//            }
//        }
//        for (Map.Entry<TaskType, List<Task>> entry : allTasksByType.entrySet()) {
//            out.println(String.format("%s =>> %s", entry.getKey(), entry.getValue()));
//        }
    }
}

