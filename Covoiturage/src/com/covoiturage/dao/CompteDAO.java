package com.covoiturage.dao;


import com.covoiturage.Compte;
import com.covoiturage.base.BaseCompteDAO;

public class CompteDAO extends BaseCompteDAO {
	
	public Compte Login(String username, String password){
	//	try
		//{
		String query = " from Compte where login like '"+username+"' and password like '"+password+"'";
		java.util.List rs = this.find(query);
		return rs.isEmpty()?null:(Compte)rs.get(0);
//	}
//		catch (Exception e){
			//return null;
		//}
	}
}