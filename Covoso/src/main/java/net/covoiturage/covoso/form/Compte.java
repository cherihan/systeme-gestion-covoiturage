package net.covoiturage.covoso.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Compte")
public class Compte {
	@Id
	@Column(name = "Login")
	String login;

	@Column(name = "Password")
	String password;

	@Column(name = "Avatar")
	String avatar;

	@Column(name = "Type")
	String type;

	@Column(name = "Utilisateurid")
	@ForeignKey(name = "UtilisateurFK")
	Integer utilisateurid;
	
	
	public Integer getUtilisateurid() {
		return utilisateurid;
	}

	public void setUtilisateurid(Integer utilisateurid) {
		this.utilisateurid = utilisateurid;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*
	 * Utilisateur utilisateur;
	 * 
	 * 
	 * public Utilisateur getUtilisateur() {
	 * if(utilisateur==null&&this.getUtilisateurid()!=null) return new
	 * UtilisateurDaoImpl().single(this.getUtilisateurid()); else return
	 * utilisateur; }
	 * 
	 * public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur =
	 * utilisateur; }
	 */


}
