package com.ch.DAO;

import com.ch.bean.Message.GetMessageIBean;
import com.ch.model.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
    public List<Message> findByHQL(String hql, GetMessageIBean params) {
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0, params.getUsername());
        query.setParameter(1,params.getFromUser());
        return query.list();
    }

    public void updataStatus(GetMessageIBean iBean){
        Query query = this.getSession().createQuery("update Message set messageIsread = 1 where messageTouser = ? and messageFromuser = ? and messageIsread= 0");
        query.setParameter(0,iBean.getUsername());
        query.setParameter(1,iBean.getFromUser());
        int a=query.executeUpdate();
        System.out.println("一共修改了"+ a +"条数据");
    }
}
