package com.revature.foundation_project.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.foundation_project.sql_configuration.MySqlAccess;
import com.foundation_project.sql_queries.Queries;
import java.sql.*;

public class Admin implements Doa {
	Connection conn=MySqlAccess.getConnection();
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static Date date=new Date();
	static Scanner sc=new Scanner(System.in);
	PreparedStatement preaparedSt=null;
	MySqlAccess query=new MySqlAccess();
	Users user = new Users();
	public boolean checkLogin(String loginId, String password) throws Exception{
		CallableStatement cs=conn.prepareCall(Queries.SET_RETURN_VALUE);
		cs.execute();
		cs=conn.prepareCall(Queries.LOGIN_PROCEDURE_QUERY);
		cs.setString(1, loginId);
		cs.setString(2, password);
		cs.registerOutParameter(3,Types.INTEGER);
		cs.execute();
		return cs.getInt(3)==1;
	}
	@Override
	public void addNewUser() throws SQLException {
		int flag=0;
		do
		{
			System.out.println("1. Add Admin");
			System.out.println("2. Add Receptionist");
			System.out.println("3. Add Guest");
			System.out.println("4. Back to main menu");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				user.addAdmin();
				break;
			case 2:
				user.addReceptionist();
				break;
			case 3:
				user.addGuest();
				break;
			case 4:
				flag=1;
				break;
			}
		}while(flag==0);
		
		
	}

	@Override
	public void updateUser() throws SQLException {
		int flag=0;
		do
		{
			System.out.println("1. Update Admin");
			System.out.println("2. Update Receptionist");
			System.out.println("3. Update Guest");
			System.out.println("4. Back to main menu");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				user.updateAdmin();
				break;
			case 2:
				user.updateReceptionist();
				break;
			case 3:
				user.updateGuest();
				break;
			case 4:
				flag=1;
				break;
			}
		}while(flag==0);
		

	}

	@Override
	public void removeUser() throws SQLException {
		int flag=0;
		do
		{
			System.out.println("1. Remove Admin");
			System.out.println("2. Remove Receptionist");
			System.out.println("3. Remove Guest");
			System.out.println("4. Back to main menu");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				user.removeUser();
				break;
			case 2:
				user.removeUser();
				break;
			case 3:
				user.removeUser();
				break;
			case 4:
				flag=1;
				break;
			}
		}while(flag==0);
	}

	@Override
	public void displayUser() throws SQLException{
		int flag=0;
		do
		{
			System.out.println("1. Dislplay Admin");
			System.out.println("2. Dislplay Receptionist");
			System.out.println("3. Dislplay Guest");
			System.out.println("4. Back to main menu");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				user.seeAllAdmins();
				break;
			case 2:
				user.seeReceptionist();
				break;
			case 3:
				user.seeGuest();
				break;
			case 4:
				flag=1;
				break;
			}
			
		}while(flag==0);
//		PreparedStatement preparedStatement=conn.prepareStatement(Queries.SELECT_ALL_FROM_ADMIN);
//		ResultSet rs = preparedStatement.executeQuery();
//		System.out.println("All admins:");
//		while(rs.next())
//		{
//			String Admin_id=rs.getString("Admin_id");
//			String Admin_Name=rs.getString("Admin_Name");
//			String Admin_Password=rs.getString("Admin_Password");
//			String Admin_Mobile=rs.getString("Admin_Mobile");
//			String Admin_Last_Modified=rs.getString("Admin_Last_Modified");
//			System.out.println(Admin_id+" "+Admin_Name+" "+Admin_Password+" "+Admin_Mobile+" "+Admin_Last_Modified);
//		}
	}

}
