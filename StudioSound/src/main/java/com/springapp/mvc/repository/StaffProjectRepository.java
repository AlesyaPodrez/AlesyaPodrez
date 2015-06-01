package com.springapp.mvc.repository;

import com.springapp.mvc.domain.StaffProject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StaffProjectRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addStaffProject(StaffProject staffproject){
        this.sessionFactory.getCurrentSession().save(staffproject);
    }

    public List<StaffProject> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from StaffProject").list();
    }

    public void removeStaffProject(Integer iD){
        StaffProject contact = (StaffProject)this.sessionFactory.getCurrentSession().load(StaffProject.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public StaffProject findStaffProject(Integer iD){
        StaffProject staffproject = (StaffProject)this.sessionFactory.getCurrentSession().get(StaffProject.class, iD);
        if (null!=staffproject){
            return staffproject;
        }
        else return null;
    }

    public void updateStaffProject(StaffProject staffproject){
        this.sessionFactory.getCurrentSession().saveOrUpdate(staffproject);
    }

    public List<StaffProject> findStaffProjectID(Integer iD){
        String id = Integer.toString(iD);
        String str1 = "from StaffProject where idProject="+id;
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }

}