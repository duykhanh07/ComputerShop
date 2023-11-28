package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTO_NhaCungCap;

public class NhaCungCapDAO extends DAO_Connection{
	
	public NhaCungCapDAO()
	{
		conn =  Connect_mySQL();
	}
	
	//Lấy tất cả nhà cung cấp có trong database
		public ArrayList <DTO_NhaCungCap> get_AllNhaCungCap()
		{
			String sql = "select * from nhacungcap";
			ArrayList <DTO_NhaCungCap> arr = new ArrayList<DTO_NhaCungCap>();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					DTO_NhaCungCap ncc = new DTO_NhaCungCap(rs.getString("mancc"), rs.getString("tenncc"), rs.getString("sdt"), rs.getString("diachi"));
					arr.add(ncc);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return arr;
		}
		
		//Lấy mã nhà cung cấp của tất cả các nhà cung cấp có trong database
		public ArrayList <String> get_mancc()
		{
			String sql = "select mancc from nhacungcap";
			ArrayList <String> arr = new ArrayList<String>();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					String mancc = rs.getString("mancc");
					arr.add(mancc);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return arr;
		}
		
		//Thêm nhà cung cấp vào database
		public int insert_NhaCungCap(DTO_NhaCungCap ncc)
		{
			String sql = "insert into nhacungcap(mancc, tenncc, sdt, diachi) values ('" + ncc.getMancc() + "', '" + ncc.getTenncc() + "', '" + ncc.getSdt() + "', '" + ncc.getDiachi() + "')";
			int rs = -1;
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				rs = stmt.executeUpdate();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
		
		//Cập nhật nhà cung cấp
		public int update_NhaCungCap(DTO_NhaCungCap ncc)
		{
			String sql = "update nhacungcap set tenncc = ?, sdt = ?, diachi = ? where mancc = '" + ncc.getMancc() + "'";
			int rs = -1;
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, ncc.getTenncc());
				stmt.setString(2, ncc.getSdt());
				stmt.setString(3, ncc.getDiachi());
				rs = stmt.executeUpdate();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
		
		//Tìm số lượng nhà cung cấp
		public int databaseSize()
		{
			String sql = "select * from nhacungcap";
			int count = 0;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					count++;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return count;
		}
}
