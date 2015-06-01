package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addRole(Role role){
        this.sessionFactory.getCurrentSession().save(role);
    }

    public List<Role> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Role").list();
    }

    public void removeRole(Integer iD){
        Role contact = (Role)this.sessionFactory.getCurrentSession().load(Role.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public List<Role> findRole(Integer iD){
        String id = Integer.toString(iD);
        String str1 = "from Role where idProject="+id;
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }

    public List<Role> findRoleActor(Integer iD){
        String id = Integer.toString(iD);
        String str1 = "from Role where idActor="+id;
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }

    public Role findRoleID(Integer iD){
        Role role = (Role)this.sessionFactory.getCurrentSession().get(Role.class, iD);
        if (null!=role){
            return role;
        }
        else return null;
    }

    public void updateRole(Role role){
        this.sessionFactory.getCurrentSession().saveOrUpdate(role);
    }
}
