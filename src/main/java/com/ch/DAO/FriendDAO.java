package com.ch.DAO;

import com.ch.bean.FriendInfoOBean;
import com.ch.model.Friend;
import com.ch.model.Message;
import com.ch.model.Userinfo;
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
public class FriendDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public FriendDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public FriendDAO(){}
    @Transactional(readOnly = false)
    public void update(Friend entity) {
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
    public void save(Friend entity) {
        this.getSession().save(entity);
    }
    public Friend findById(Serializable id) {
        return (Friend) this.getSession().get(Friend.class, id);
    }
    public List<Friend> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }

    public List<Userinfo> findFriendByOwner(String username){
        String sql = "select * from Userinfo where username in (select friend_username from Friend where owner_username=?) ";
        Query query = this.getSession().createSQLQuery(sql).addEntity(Userinfo.class);
        query.setParameter(0,username);
        return query.list();
    }
}
