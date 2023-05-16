package JdbcProgram;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class BankApp 
{
	Scanner sc1;
	public static void main(String[] args) 
	{
		BankApp ba1=new BankApp();
		ba1.startBankapp();		
	}
	void startBankapp()
	{
		System.out.println("\n===============================");
		System.out.println(" 1. Add Account:-");
		System.out.println(" 2. fnd transfer:-");
		System.out.println(" 3. Mini stgatement:-");
		System.out.println(" 4.  Exit:-");
		System.out.println("===================================");
		System.out.println("\nSelect any one option :");
		getUserInput();
	}
	void getUserInput()
	{
		sc1=new Scanner(System.in);
		int useroption=sc1.nextInt();
		if (useroption ==1) 
		{
			System.out.println(" Add Account:-");	
			addAcount();
			
		} else if (useroption==2) 
		{
			System.out.println(" fnd transfer:-");
			fundTransfer();
		}else if (useroption==3) 
		{
			System.out.println("  Mini stgatement:-");
			miniStatement();
		}
		else {
			System.out.println("Bank app close :");
			System.exit(0);
		}
	}
	void addAcount()
	{
		System.out.println(" Please enter id:");
		int id=sc1.nextInt();
		
		System.out.println("Please Enter name:");
		String name=sc1.next();
		
		System.out.println("Please Enter Email:");
		String email=sc1.next();
		
		System.out.println("Please Enter phone number:");
		String phone=sc1.next();
		 
		System.out.println("Please Enter Account number:");
		int acc_no=sc1.nextInt();
		Connection con1=null;
		try {
			//-------------- Creating Account------------------
		
//			Class.forName("com.mysql.cj.jdbc.Driver");
			con1=DbConnection.getconnect();
			con1.setAutoCommit(false);
//			System.out.println("driver loaded");
//			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp", "root", "root");
//			System.out.println("established");
			PreparedStatement ps1=con1.prepareStatement("insert into users values(?,?,?,?,?)");
			ps1.setInt(1, id);
			ps1.setString(2, name);
			ps1.setString(3, email);
			ps1.setString(4, phone);
			ps1.setInt(5, acc_no);
			int rowCount1=ps1.executeUpdate();
			//-p--------close creating
			
			// ---------deposit money in account --------------------
			PreparedStatement ps2=con1.prepareStatement("insert into total_ammount values(?,?,?)");
			ps2.setInt(1, id);
			ps2.setInt(2, acc_no);
			ps2.setInt(3, 50000);
			int rowCount2= ps2.executeUpdate();
			if (rowCount1>0 && rowCount2>0) 
				//---------------------------
			{
				System.out.println("Account created successfully");
				con1.commit();
				
			}
			else 
			{
				con1.rollback();
				System.out.println("Account not created  due to some error ");
				

			}
		} catch (Exception e) {
//			e.printStackTrace();
			try {
				con1.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
				System.out.println(e1);
				
			}
			System.out.println(e);
			// TODO: handle exception
		}
		
		startBankapp();
	}
	void  fundTransfer()
	{
		System.out.println("Enter from account no:");
		int from_accno=sc1.nextInt();
		
		System.out.println("ENter to Account no:");
		int to_accno=sc1.nextInt();
		
		System.out.println("enmter ammount :");
		int deposut_ammount=sc1.nextInt();
		
		int from_bal=0,to_bal=0;
		Connection con1=null;
		try 
		{
			con1=DbConnection.getconnect();
			con1.setAutoCommit(false);
			PreparedStatement ps=con1.prepareStatement("select balance from total_ammount where account_no=?");
			ps.setInt(1, from_accno);
			
			ResultSet rs1=ps.executeQuery();
			while (rs1.next()) 
			{
				from_bal=rs1.getInt(1);
				
			}
//			Connection con2=DbConnection.getconnect();
			PreparedStatement ps1=con1.prepareStatement("select balance from total_ammount where account_no=?");
			ps1.setInt(1, to_accno);
			
			ResultSet rs2=ps1.executeQuery();
			while (rs2.next()) 
			{
				to_bal=rs2.getInt(1);
						
			}
			int new_from_bal=from_bal-deposut_ammount;
			int new_to_bal=to_bal+deposut_ammount;
			
			PreparedStatement ps2=con1.prepareStatement("update total_ammount set balance=? where account_no=?");
			ps2.setInt(1, new_to_bal);
			ps2.setInt(2, new_to_bal);
			int rowCount1= ps2.executeUpdate();
			
			PreparedStatement ps3=con1.prepareStatement("update total_ammount set balance=? where account_no=?");
			ps3.setInt(1, new_to_bal);
			ps3.setInt(2, new_to_bal);
			int rowCount2= ps3.executeUpdate();
			
			//----------fet system current date and time--------------
			Date d1= new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
			String date1=sdf1.format(d1);
			
			SimpleDateFormat sdf2=new SimpleDateFormat("HH/mm/ss");
			String time1=sdf2.format(d1);
			
			PreparedStatement ps4=con1.prepareStatement("insert into mini_statement values(?,?,?,?,?)");
			ps4.setInt(1, from_accno);
			ps4.setInt(2, deposut_ammount);
			ps4.setString(3, "d");
			ps4.setString(4, date1);
			ps4.setString(5, time1);
			int rowCount3=ps4.executeUpdate();
			PreparedStatement ps5=con1.prepareStatement("insert into mini_statement values(?,?,?,?,?)");
			ps5.setInt(1, to_accno);
			ps5.setInt(2, deposut_ammount);
			ps5.setString(3, "c");
			ps5.setString(4, date1);
			ps5.setString(5, time1);
			int rowCount4=ps5.executeUpdate();
			
			if (rowCount1>0 && rowCount2>0 && rowCount3 >0&&rowCount4>0) 
			{
				con1.commit();
				System.out.println("ammount deposit successufully");
				
			} else {
				con1.rollback();
				System.out.println("transition faailed");
			}
			
			
			} catch (Exception e)
		{
				try {
					con1.rollback();
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
				
			System.out.println(e);
			// TODO: handle exception
		}
		
		
		startBankapp();
	}
	void miniStatement()
	{
StringBuffer minist_details=new StringBuffer();
		
		System.out.println("Enter Account No. : ");
		int accno=sc1.nextInt();
		
		minist_details.append("Below is the transaction details for '"+accno+"' account no\n\n");
		
		Connection con1=null;
		try
		{
			con1=DbConnection.getconnect();
			
			PreparedStatement ps=con1.prepareStatement("select * from mini_statement where account_no=?");
			ps.setInt(1, accno);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getInt(2));
				minist_details.append(rs.getInt(2));
				
				System.out.print("\t"+rs.getString(3));
				minist_details.append("\t"+rs.getString(3));
				
				System.out.print("\t"+rs.getString(4));
				minist_details.append("\t"+rs.getString(4));
				
				System.out.print("\t"+rs.getString(5));
				minist_details.append("\t"+rs.getString(5));
				
				System.out.println();
				minist_details.append("\n");
			}
			
			
			generateMiniStatementFile(minist_details, accno);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		startBankapp();
	}
	
	public void generateMiniStatementFile(StringBuffer details, int accountno)
	{
		String st=details.toString();
		try
		{
			FileOutputStream fos=new FileOutputStream("e:/"+accountno+".txt");
			fos.write(st.getBytes());
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	}
	
	

