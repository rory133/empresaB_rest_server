package org.proyecto.empresaB_rest_server.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport
{    
    @Autowired
    public void anyMethodName(SessionFactory sessionFactory)
    {
    	
    	System.out.println("nyMethodName(SessionFactory sessionFactory)");
        setSessionFactory(sessionFactory);
        System.out.println("SessionFactory" + sessionFactory.getClass().getName());
    }
    
}
