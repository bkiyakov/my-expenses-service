package ru.bkiyakov.myexpenses.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Category {
    public String getCategoryId() {
        return categoryId.toString();
    }

    public void setCategoryId(ObjectId categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return Objects.equals(categoryId, category.categoryId);
    }

    @Override
    public int hashCode() {
        return categoryId != null ? categoryId.hashCode() : 0;
    }

    @Id
    private ObjectId categoryId;
    private String name;
    //TODO private Icon icon;
}
