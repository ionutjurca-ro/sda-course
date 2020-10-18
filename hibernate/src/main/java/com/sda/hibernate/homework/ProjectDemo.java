package com.sda.hibernate.homework;

public class ProjectDemo {
    public static void main(String[] args) {
//        Employee employee1 = createEmployee("ionut", "jurca");
//        Employee employee2 = createEmployee("ramona", "sala");
        Project project1 = createProject("training");
        Project project2 = createProject("cleaning");

        ProjectRepository projectRepository = new ProjectRepository();
        projectRepository.createProject(project1);
        projectRepository.createProject(project2);
        Project foundProject = projectRepository.findByld(1);
        System.out.println(foundProject);


    }

    private static Employee createEmployee(String firstName, String lastName) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        return employee;
    }

    private static Project createProject(String projectName) {
        Project project = new Project();
        project.setProjectName(projectName);
        return project;
    }
}
