package com.sda.hibernate.homework;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class ProjectRepository {

    private static final Logger LOGGER = Logger.getLogger(ProjectRepository.class.getName());

    private Session session;
    private Transaction tx;

    public void createProject(Project project) {
        try {
            startOperation();
            session.save(project);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    public Project findByld(int projectNumber) {
        Project project = null;
        try {
            startOperation();
            project = session.find(Project.class, projectNumber);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return project;
    }

    public void delete(Project project) {
        try {
            startOperation();
            session.delete(project);
            tx.commit();
        } catch (HibernateException e) {
            LOGGER.severe("delete failed");
        } finally {
            if (session != null) session.close();
        }
    }


    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}
