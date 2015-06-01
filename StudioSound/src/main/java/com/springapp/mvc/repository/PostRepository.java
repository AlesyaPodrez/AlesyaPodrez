package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPost(Post post){
        this.sessionFactory.getCurrentSession().save(post);
    }

    public List<Post> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Post").list();
    }
    public List<Post> listName(){
        return this.sessionFactory.getCurrentSession().createSQLQuery("select * from post").list();
    }

    public void removePost(Integer iD){
        Post contact = (Post)this.sessionFactory.getCurrentSession().load(Post.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public Post findPost(Integer iD){
        Post post = (Post)this.sessionFactory.getCurrentSession().get(Post.class, iD);
        if (null!=post){
            return post;
        }
        else return null;
    }

    public void updatePost(Post post){
        this.sessionFactory.getCurrentSession().saveOrUpdate(post);
    }

    public List<Post> findPostStaff(Integer iD){
        String id = Integer.toString(iD);
        String str1 = "from Post where idPost!="+id;
        return this.sessionFactory.getCurrentSession().createQuery(str1).list();
    }
}
