package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

public class Task {

    private String id;
    private String title;
    private String description;
    private TaskType type;
    private LocalDate createdOn;
    private Set<String> tags = new HashSet<>();

    public Task() {
    }

    private Task(Builder builder) {
        id = builder.id;
        title = builder.title;
        description = builder.description;
        type = builder.type;
        createdOn = builder.createdOn;
        tags = builder.tags;
    }

    public int getTitleSize(){
        return title.length();
    }

    public static List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        Set<String> tagsReading = new HashSet<>();
        Set<String> tagsCoding = new HashSet<>();
        Set<String> tagsBlogging = new HashSet<>();
        tagsCoding.add("coding");
        tagsCoding.add("refactoring");
        tagsReading.add("reading");
        tagsReading.add("books");
        tagsBlogging.add("blogging");
        tagsBlogging.add("writings posts");

        tasks.add(
            new Builder()
                .id("1")
                .title("Code Refactoring")
                .description("Code needs to be refactored")
                .createdOn(LocalDate.of(2018, 11, 1))
                .type(TaskType.CODING)
                .tags(tagsCoding)
                .build()
        );

        tasks.add(
            new Builder()
                .id("2")
                .title("Adding new feature")
                .description("New feature needs to be added")
                .createdOn(LocalDate.of(2018, 11, 4))
                .type(TaskType.CODING)
                .tags(tagsCoding)
                .build()
        );

        tasks.add(
            new Builder()
                .id("3")
                .title("Reading Domain Driven Development")
                .description("Reading new book about Domain Driven Development")
                .createdOn(LocalDate.of(2018, 11, 1))
                .type(TaskType.READING)
                .tags(tagsReading)
                .build()
        );

        tasks.add(
            new Builder()
                .id("4")
                .title("Reading Design Patterns")
                .description("Reading new book about Design Patterns")
                .createdOn(LocalDate.of(2018, 11, 4))
                .type(TaskType.READING)
                .tags(tagsReading)
                .build()
        );
        tasks.add(
            new Builder()
                .id("5")
                .title("Reading Java Lambda")
                .description("Reading new book about Java Lambda")
                .createdOn(LocalDate.of(2018, 11, 4))
                .type(TaskType.READING)
                .tags(tagsReading)
                .build()
        );

        tasks.add(
            new Builder()
                .id("6")
                .title("Blogging about Lambda Functions")
                .description("Blogging about Lambda Functions")
                .createdOn(LocalDate.of(2018, 11, 5))
                .type(TaskType.BLOGGING)
                .tags(tagsBlogging)
                .build()
        );
        tasks.add(
            new Builder()
                .id("6")
                .title("Blogging about Lambda Functions")
                .description("Blogging about Lambda Functions")
                .createdOn(LocalDate.of(2018, 11, 5))
                .type(TaskType.BLOGGING)
                .tags(tagsBlogging)
                .build()
        );
        return tasks;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getType() {
        return type;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public Task addTag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public Set<String> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    @Override
    public String toString() {
        return "Task{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", type=" + type +
            ", createdOn=" + createdOn +
            ", tags=" + tags +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(title, task.title) &&
            Objects.equals(type, task.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type);
    }

    public static class Builder {

        private String id = "";
        private String title = "";
        private String description = "";
        private TaskType type = TaskType.BLOGGING;
        private LocalDate createdOn = LocalDate.now();
        private Set<String> tags = new HashSet<>();

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder type(TaskType type) {
            this.type = type;
            return this;
        }

        public Builder createdOn(LocalDate createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder tags(Set<String> tags) {
            this.tags = tags;
            return this;
        }


        public Task build() {
            return new Task(this);
        }
    }
}