package com.ch.DAO;

import com.ch.model.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by apple on 2017/3/4.
 */
@Transactional
@Component
public class MessageDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public MessageDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public MessageDAO(){}
    @Transactional(readOnly = false)
    public void update(Message entity) {
        this.getSession().update(entity);
    }
    @Transactional(readOnly = false)
    public void delete(Serializable id) {
        this.getSession().delete(this.findById(id));
    }
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    @Transactional(readOnly = false)
    public void save(Message entity) {
        this.getSession().save(entity);
    }
    public Message findById(Serializable id) {
        return (Message) this.getSession().get(Message.class, id);
    }
    public List<Message> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }

    public void savaEntity(Message message){
        String sql = "insert into Message values(?,?,?,?,?)";
    }
}
