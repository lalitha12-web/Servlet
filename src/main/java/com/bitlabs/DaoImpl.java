package com.bitlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DaoImpl implements DaoInterface {
	Connection con=null;

	public DaoImpl() {
		//loading driver class
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					//connection establishment
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","root");
					if(con!=null)
					{
						System.out.println("connection established");
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
	}

	@Override
	public int register(Registration r) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, r.getFirstname());
			pstmt.setString(2, r.getMiddlename());
			pstmt.setString(3, r.getLastname());
			pstmt.setString(4, r.getCourse());
			pstmt.setString(5, r.getGender());
			pstmt.setLong(6, r.getPhoneno());
			pstmt.setString(7, r.getAddress());
			pstmt.setString(8, r.getEmail());
			pstmt.setString(9, r.getPassword());
			pstmt.setString(10, r.getRepwd());
			i=pstmt.executeUpdate();
		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return i;
		
	}
}
