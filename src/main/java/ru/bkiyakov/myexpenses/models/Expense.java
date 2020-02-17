package ru.bkiyakov.myexpenses.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Objects;

public class Expense {
    public String getExpenseId() {
        return expenseId.toString();
    }

    public void setExpenseId(ObjectId expenseId) {
        this.expenseId = expenseId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId='" + expenseId + '\'' +
                ", sum=" + sum +
                ", createdDate=" + createdDate +
                ", categoryId='" + categoryId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        return Objects.equals(expenseId, expense.expenseId);
    }

    @Override
    public int hashCode() {
        return expenseId != null ? expenseId.hashCode() : 0;
    }

    @Id
    private ObjectId expenseId;
    private int sum;
    private Date createdDate;
    private String categoryId;
    private String note;
}
