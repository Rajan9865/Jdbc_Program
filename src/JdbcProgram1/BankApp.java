package JdbcProgram1;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BankApp
{
	Scanner	s;
	public static void main(String[] args)
	{
		BankApp ba=new BankApp();
		ba.startBankApp();
	}
	void startBankApp()
	{
		System.out.println("\n================================");
		System.out.println("1. Add Account");
		System.out.println("2. Fund Transfer");
		System.out.println("3. Mini Statement");
		System.out.println("4. Exit");
		
		System.out.println("\nSelect Any One Option");
		System.out.println("================================");
		
		getUserInput();
	}
	void getUserInput()
	{
		s=new Scanner(System.in);
		int useroption=s.nextInt();
		
		System.out.println("----------------------");
		
		if(useroption==1)
		{
			addAccount();
		}
		else if(useroption==2)
		{
			fundTransfer();
		}
		else if(useroption==3)
		{
			miniStatement();
		}
		else
		{
			System.out.println("Bank App CLosed");
			System.exit(0);
		}
	}
	void addAccount()
	{
		System.out.println("Enter ID : ");
		int id=s.nextInt();
		
		System.out.println("Enter Name : ");
		String name=s.next();
		
		System.out.println("Enter Email : ");
		String email=s.next();
		
		System.out.println("Enter Phone No : ");
		String phno=s.next();
		
		System.out.println("Enter Account No : ");
		int accno=s.nextInt();
		
		Connection con=null;
		try
		{
			con=DbConnection.getConnect();
			
			con.setAutoCommit(false);
			//-----------creating account----------------
			PreparedStatement ps1= con.prepareStatement("insert into users values(?,?,?,?,?)");
			
			ps1.setInt(1, id);
			ps1.setString(2, name);
			ps1.setString(3, email);
			ps1.setString(4, phno);
			ps1.setInt(5, accno);
			
			int rowCount1=ps1.executeUpdate();
			//-------------------------------------------
			
			//----------------deposit money in account----------------
			PreparedStatement ps2=con.prepareStatement("insert into total_ammount values(?,?,?)");
			
			ps2.setInt(1, id);
			ps2.setInt(2, accno);
			ps2.setInt(3, 50000);
			
			int rowCount2=ps2.executeUpdate();
			//--------------------------------------------------------
			
			if(rowCount1>0 && rowCount2>0)
			{
				con.commit();
				System.out.println("Account created successfully");
			}
			else
			{
				con.rollback();
				System.out.println("Account creation failed due to some error");
			}
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			System.out.println(e);
		}
		
		startBankApp();
	}
	void fundTransfer()
	{
		System.out.println("Enter From Account No : ");
		int from_accno=s.nextInt();
		
		System.out.println("Enter To Account No : ");
		int to_accno=s.nextInt();
		
		System.out.println("Enter Amount : ");
		int deposit_amount=s.nextInt();
		
		int from_bal=0, to_bal=0;
		
		Connection con=null;
		try
		{
			con=DbConnection.getConnect();
			
			con.setAutoCommit(false);
			
			PreparedStatement ps=con.prepareStatement("select balance from total_ammount where account_no=?");
			ps.setInt(1, from_accno);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				from_bal=rs.getInt(1);
			}
			
			PreparedStatement ps1=con.prepareStatement("select balance from total_ammount where account_no=?");
			ps1.setInt(1, to_accno);
			
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				to_bal=rs1.getInt(1);
			}
			
			int new_from_bal=from_bal-deposit_amount;
			int new_to_bal=to_bal+deposit_amount;
			
			PreparedStatement ps2=con.prepareStatement("update total_ammount set balance=? where account_no=?");
			ps2.setInt(1, new_from_bal);
			ps2.setInt(2, from_accno);
			int rowCount1=ps2.executeUpdate();
			
			PreparedStatement ps3=con.prepareStatement("update total_ammount set balance=? where account_no=?");
			ps3.setInt(1, new_to_bal);
			ps3.setInt(2, to_accno);
			int rowCount2=ps3.executeUpdate();
			
			//--------get system current date & time-------------
			Date d=new Date();
			
			SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
			String date1=sdf1.format(d);
			
			SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
			String time1=sdf2.format(d);
			//--------------------------------------------------
			
			PreparedStatement ps4=con.prepareStatement("insert into mini_statement values(?,?,?,?,?)");
			ps4.setInt(1, from_accno);
			ps4.setInt(2, deposit_amount);
			ps4.setString(3, "d");
			ps4.setString(4, date1);
			ps4.setString(5, time1);
			int rowCount3=ps4.executeUpdate();
			
			PreparedStatement ps5=con.prepareStatement("insert into mini_statement values(?,?,?,?,?)");
			ps5.setInt(1, to_accno);
			ps5.setInt(2, deposit_amount);
			ps5.setString(3, "c");
			ps5.setString(4, date1);
			ps5.setString(5, time1);
			int rowCount4=ps5.executeUpdate();
			
			if(rowCount1>0 && rowCount2>0 && rowCount3>0 && rowCount4>0)
			{
				con.commit();
				System.out.println("Amount deposit successfully");
			}
			else
			{
				con.rollback();
				System.out.println("Transaction failed");
			}
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			System.out.println(e);
		}
		
		startBankApp();
	}
	void miniStatement()
	{
		StringBuffer minist_details=new StringBuffer();
		
		System.out.println("Enter Account No. : ");
		int accno=s.nextInt();
		
		minist_details.append("Below is the transaction details for '"+accno+"' account no\n\n");
		
		Connection con=null;
		try
		{
			con=DbConnection.getConnect();
			
			PreparedStatement ps=con.prepareStatement("select * from mini_statement where account_no=?");
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
		
		startBankApp();
	}
	
	public void generateMiniStatementFile(StringBuffer details, int accountno)
	{
		String st=details.toString();
		try
		{
			FileOutputStream fos=new FileOutputStream("E:\\bankapp/"+accountno+".txt");
			fos.write(st.getBytes());
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
