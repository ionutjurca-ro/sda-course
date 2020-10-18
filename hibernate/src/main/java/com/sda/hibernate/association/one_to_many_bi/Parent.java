package com.sda.hibernate.association.one_to_many_bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Parent")
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(
            mappedBy = "parent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Child> children = new ArrayList<>();

    public Parent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    //helper methods - synchornize sides

    //add child to parent
    public void addChild(Child child) {
        //paernt knows child
        children.add(child);

        //child know parent
        child.setParent(this);
    }

    public void removeChild(Child child) { //method definition
        //remove child from parent
        children.remove(child);

        //remove parent from child
        child.setParent(null); //method call
    }
}
