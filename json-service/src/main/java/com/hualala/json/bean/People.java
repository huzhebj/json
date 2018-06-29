package com.hualala.json.bean;

import lombok.Data;

@Data
public class People {
    private String name;
    private Integer age;

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (!getName().equals(people.getName())) return false;
        return getAge().equals(people.getAge());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge().hashCode();
        return result;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }*/
}
