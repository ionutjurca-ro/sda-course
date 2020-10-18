package com.sda.hibernate.association.one_to_many_bi;

public class DemoOneToManyBidirectional {

    public static void main(String[] args) {
        //parent
        //parent know children
        Parent parent = new Parent();
        parent.setName("parent");
        parent.setEmail("parent@gmail.com");

        //2 children
        //child knows parent
        Child child1 = new Child();
        child1.setTitle("child1");

        Child child2 = new Child();
        child2.setTitle("child2");

        //set children on parent
        parent.addChild(child1);
        parent.addChild(child2);

        //save parent
        ParentDao parentDao = new ParentDao();
        parentDao.create(parent);
        //insert parent
        //insert child1
        //insert child2

        //tables 2

        Parent savedParent = parentDao.findById(1L);
        Child firstChild = savedParent.getChildren().get(0);
    }
}
