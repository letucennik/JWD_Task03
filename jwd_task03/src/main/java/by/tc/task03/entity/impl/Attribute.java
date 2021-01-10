package by.tc.task03.entity.impl;

import by.tc.task03.entity.Element;
import javafx.util.Pair;

import java.io.Serializable;

public class Attribute implements Serializable, Element {
    Pair<String, String> nameAndValue;

    public Attribute() {
    }

    public Attribute(Pair<String, String> nameAndValue) {
        this.nameAndValue = nameAndValue;
    }

    public Attribute(String name, String value) {
        nameAndValue = new Pair<>(name, value);
    }

    public Pair<String, String> getNameAndValue() {
        return nameAndValue;
    }

    public void setNameAndValue(Pair<String, String> nameAndValue) {
        this.nameAndValue = nameAndValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (null == this.nameAndValue) {
            return null == attribute.nameAndValue;
        } else if (!nameAndValue.equals(attribute.nameAndValue)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (nameAndValue == null ? 0 : nameAndValue.hashCode());
    }

    @Override
    public String toString() {
        return nameAndValue.getKey() + " - " + nameAndValue.getValue();
    }
}
