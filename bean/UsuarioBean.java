package br.facape.nti.crudBye.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String usncodg;
	private String usclogn;
	private String uscsenh;
	private String uscnome;
	private String uscmail;
	
	public String getUsncodg() {
		return usncodg;
	}
	public void setUsncodg(String usncodg) {
		this.usncodg = usncodg;
	}
	public String getUsclogn() {
		return usclogn;
	}
	public void setUsclogn(String usclogn) {
		this.usclogn = usclogn;
	}
	public String getUscsenh() {
		return uscsenh;
	}
	public void setUscsenh(String uscsenh) {
		this.uscsenh = uscsenh;
	}
	public String getUscnome() {
		return uscnome;
	}
	public void setUscnome(String uscnome) {
		this.uscnome = uscnome;
	}
	public String getUscmail() {
		return uscmail;
	}
	public void setUscmail(String uscmail) {
		this.uscmail = uscmail;
	}
	
	

}
