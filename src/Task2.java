import static java.lang.System.out;
import static java.lang.System.setOut;

import domain.Task;
import domain.TaskType;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();

        System.out.println("=====Reading task titles sorted by their creation date=====");
        List<Task> list1 = tasks.stream()
                .filter(t->t.getType().equals(TaskType.READING))
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .collect(Collectors.toList());
        list1.stream()
                .forEach(t-> System.out.println(t.getTitle()));


        System.out.println("\n"+"=====Reading task titles sorted by their creation date in reverse=====");
        List<Task> list2 = tasks.stream()
                .filter(t->t.getType().equals(TaskType.READING))
                .sorted(Comparator.comparing(Task::getCreatedOn).reversed())
                .collect(Collectors.toList());
        list2.stream()
                .forEach(t-> System.out.println(t.getTitle()));


        System.out.println("\n"+"=====Distinct tasks=====");
        List<Task> list3 = tasks.stream()
                .distinct()
                .collect(Collectors.toList());
        list3.stream()
                .forEach(t-> System.out.println(t.getTitle()));

        System.out.println("\n"+"=====Top 2 reading tasks sorted by their creation date=====");
        List<Task> list4 = tasks.stream()
                .filter(t->t.getType().equals(TaskType.READING))
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .limit(2)
                .collect(Collectors.toList());
        list4.stream()
                .forEach(t-> System.out.println(t.getTitle()));


        System.out.println("\n"+"=====all unique tags from all tasks=====");
        Set<String> list5 = tasks.stream()
                .flatMap(t->t.getTags()
                        .stream())
                .collect(Collectors.toSet());

        list5.stream()
                .forEach(System.out::println);


        System.out.println("\n"+"=====Check if all reading tasks have tag books=====");
        List<String> list6 = tasks.stream()
                .filter(t->t.getType().equals(TaskType.READING))
                .flatMap(t->t.getTags()
                        .stream().filter(tag->tag.contains("books")))
                .collect(Collectors.toList());

        list6.stream()
                .forEach(System.out::println);

        System.out.println("\n"+"=====Creating a summary of all titles=====");
        List<String> list7 = tasks.stream()
                .map(t->t.getTitle())
                .collect(Collectors.toList());

        list7.stream()
                .forEach(System.out::println);





//        List<Task> readingTasks = new ArrayList<>();
//        for (Task task : tasks) {
//            if (task.getType() == TaskType.READING) {
//                readingTasks.add(task);
//            }
//        }
//        Collections.sort(readingTasks, new Comparator<Task>() {
//            @Override
//            public int compare(Task t1, Task t2) {
//                return t1.getTitle().length() - t2.getTitle().length();
//            }
//        });
//        for (Task readingTask : readingTasks) {
//            out.println(readingTask.getTitle());
//        }
    }
}