package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value = "Data not available";


    public JobField() {
        id = nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
        if(value.isBlank()) {
            this.value = "Data not available";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        JobField that = (JobField) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {return Objects.hash(id);}

    @Override
    public String toString() {return value;}

    public int getId() {return id;}

    public String getValue() {return value;}

    public void setValue(String value) {this.value = value;}

}
