package by.tc.task02.dao;

import by.tc.task02.entity.Category;
import by.tc.task02.sources.ConstantStrings;

public class SportEquipment {
    private Category category;
    private String title;
    private double price;

    public SportEquipment(Category category, String title, double price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEquipment that = (SportEquipment) o;

        if (getPrice() != that.getPrice()) return false;
        if (getCategory() != that.getCategory()) return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }

    @Override
    public int hashCode() {
    return 19 + ((this.category == null) ? 0 : this.category.hashCode()) +
                ((this.title == null) ? 0 : this.title.hashCode());
    }

    @Override
    public String toString() {

        return this.category.toString().concat(ConstantStrings.SEPARATOR).concat(this.title).
                concat(ConstantStrings.CURRENCY).concat(Double.toString(price));
    }
}
