package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Staff;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StaffRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addStaff(Staff staff){
        this.sessionFactory.getCurrentSession().save(staff);
    }

    public List<Staff> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Staff").list();
    }

    public void removeStaff(Integer iD){
        Staff contact = (Staff)this.sessionFactory.getCurrentSession().load(Staff.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public Staff findStaff(Integer iD){
        Staff staff = (Staff)this.sessionFactory.getCurrentSession().get(Staff.class, iD);
        if (null!=staff){
            return staff;
        }
        else return null;
    }

    public void updateStaff(Staff staff){
        this.sessionFactory.getCurrentSession().saveOrUpdate(staff);
    }

    public List<Staff> findStaffID(Integer idPost, Integer idStaff){
        String id = Integer.toString(idPost);
        String iD = Integer.toString(idStaff);
        String str1 = "from Staff where (idPost="+id+") and (idStaff!="+iD+")";
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }

}
