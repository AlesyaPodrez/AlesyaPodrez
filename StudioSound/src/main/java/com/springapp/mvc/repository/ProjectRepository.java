package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProject(Project project){
        this.sessionFactory.getCurrentSession().save(project);
    }

    public List<Project> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Project").list();
    }

    public void removeProject(Integer iD){
        Project contact = (Project)this.sessionFactory.getCurrentSession().load(Project.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public Project findProject(Integer iD){
        Project project = (Project)this.sessionFactory.getCurrentSession().get(Project.class, iD);
        if (null!=project){
            return project;
        }
        else return null;
    }

    public void updateProject(Project project){
        this.sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    public List<Project> findProjectID(Integer iD){
        String id = Integer.toString(iD);
        String str1 = "from Project where idProject="+id;
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }

    public List<Project> findProjectSearch(){
        String str1 = "from Project group by year";
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }

}