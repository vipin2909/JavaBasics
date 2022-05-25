package main;

import java.math.BigDecimal;

public class Project {
    private int id;
    private String name;
    private BigDecimal price;
    private String color;

    public class Builder {
        private Project project = new Project();

        public Builder id(int id) {
            project.id = id;
            return this;
        }

        public Builder name(String name) {
            project.name = name;
            return this;
        }

        public Builder price(BigDecimal price) {
            project.price = price;
            return this;
        }

        public Builder color(String color) {
            project.color = color;
            return this;
        }

        public Project build() {
            return project;
        }
    }

}
