package org.kobic.s4dncv.engine.model;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class J4DNucleomeViewerEngine {
	private SqlSessionFactory factory;
	private SqlSession session;

    public void init() throws IOException {
    	Reader r = Resources.getResourceAsReader( "org/kobic/s4dncv/engine/database/mybatis/conf.xml" );
    	this.factory = new SqlSessionFactoryBuilder().build(r);

    	this.session = this.factory.openSession();

    	Map<String, String> map = new HashMap<String, String>();
    	map.put("symbol", "BRCA");
    	List<String> keywords = this.session.selectList("getAutoCompleteGeneSymbol", map);

    	for(String keyword:keywords) {
    		System.out.println(keyword);
    	}
    }
    
    public void close() {
    	this.session.close();
    }
}