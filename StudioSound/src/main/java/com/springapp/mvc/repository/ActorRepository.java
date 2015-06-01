package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Actor;
import com.springapp.mvc.domain.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ActorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addActor(Actor actor){
        this.sessionFactory.getCurrentSession().save(actor);
    }

    public List<Actor> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Actor").list();
    }

    public void removeActor(Integer iD){
        Actor contact = (Actor)this.sessionFactory.getCurrentSession().load(Actor.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public Actor findActor(Integer iD){
        Actor actor = (Actor)this.sessionFactory.getCurrentSession().get(Actor.class, iD);
        if (null!=actor){
            return actor;
        }
        else return null;
    }

    public void updateActor(Actor actor){
        this.sessionFactory.getCurrentSession().saveOrUpdate(actor);
    }

    public List<Actor> findActorRole(Integer iD){
        String id = Integer.toString(iD);
        String str1 = "from Actor where idActor!="+id;
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }
}
