package org.kobic.s4dncv.engine.database.vo;

public class SampleVo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String num;
	private String id;
	private String celline_name;
	private String table_name;
	private String valid_yn;
	
	

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCelline_name() {
		return celline_name;
	}
	public void setCelline_name(String celline_name) {
		this.celline_name = celline_name;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getValid_yn() {
		return valid_yn;
	}
	public void setValid_yn(String valid_yn) {
		this.valid_yn = valid_yn;
	}
	
}
