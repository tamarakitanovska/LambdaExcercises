import static java.lang.System.*;

import domain.Task;
import domain.TaskType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) {

        List<Task> tasks = Task.getTasks();

        Function<Task, String> getTaskTitle = Task::getTitle;
        Predicate<Task> testTitles = t->t.getType().equals(TaskType.READING);

        List<Task> filteredTasks = tasks.stream()
                .filter(t->testTitles.test(t))
                .collect(Collectors.toList());

        filteredTasks.stream()
                .forEach(t-> System.out.println(getTaskTitle.apply(t)));

    }

}
