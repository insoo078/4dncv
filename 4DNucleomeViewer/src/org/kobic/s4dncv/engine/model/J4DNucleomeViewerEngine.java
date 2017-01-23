package org.kobic.s4dncv.engine.model;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class J4DNucleomeViewerEngine {
	private SqlSessionFactory factory;
    
    public void init() throws IOException {
    	Reader r = Resources.getResourceAsReader( "org/kobic/s4dncv/engine/database/mybatis/conf.xml" );
    	this.factory = new SqlSessionFactoryBuilder().build(r);
    	
    	SqlSession ss = this.factory.openSession();
    }
}