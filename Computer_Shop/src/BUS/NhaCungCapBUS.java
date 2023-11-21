package BUS;

import java.util.ArrayList;
import java.util.Collections;

import DAO.NhaCungCapDAO;
import DTO.DTO_NhaCungCap;

public class NhaCungCapBUS {
	
	NhaCungCapDAO nhacungcapdao = new NhaCungCapDAO();
	
	//Trả về mảng các nhà cung cấp
	public ArrayList <DTO_NhaCungCap> get_AllNhaCungCap()
	{
		return nhacungcapdao.get_AllNhaCungCap();
	}
	
	//Trả về mảng mã nhà cung cấp
	public ArrayList <String> get_mancc()
	{
		return nhacungcapdao.get_mancc();
	}
	
	//Gọi phương thức thêm nhà cung cấp
	public int insert_NhaCungCap(DTO_NhaCungCap ncc)
	{
		return nhacungcapdao.insert_NhaCungCap(ncc);
	}
	
	//Gọi phương thức cập nhật nhà cung cấp
	public int update_NhaCungCap(DTO_NhaCungCap ncc)
	{
		return nhacungcapdao.update_NhaCungCap(ncc);
	}
	
	//Trả về số lượng nhà cung cấp
	public int get_countNhaCungCap()
	{
		return nhacungcapdao.databaseSize();
	}
	
	//Tìm kiếm nhà cung cấp
	public ArrayList<DTO_NhaCungCap> timKiemNhaCungCap(String timKiemStr, int selectedIndex)
	{
		ArrayList <DTO_NhaCungCap> arr = new ArrayList<DTO_NhaCungCap>();
		arr = nhacungcapdao.get_AllNhaCungCap();
		
		ArrayList <DTO_NhaCungCap> arr_result = new ArrayList<DTO_NhaCungCap>();
		
		switch (selectedIndex)
		{
		case 0:
			for(DTO_NhaCungCap x: arr)
			{
				if(x.getMancc().toLowerCase().contains(timKiemStr) || x.getTenncc().toLowerCase().contains(timKiemStr))
					arr_result.add(x);
			}
			break;
		case 1:
			for(DTO_NhaCungCap x: arr)
			{
				if(x.getMancc().toLowerCase().contains(timKiemStr))
					arr_result.add(x);
			}
			break;
		case 2:
			for(DTO_NhaCungCap x: arr)
			{
				if(x.getTenncc().toLowerCase().contains(timKiemStr))
					arr_result.add(x);
			}
			break;
		case 3:
			for(DTO_NhaCungCap x: arr)
			{
				if(x.getSdt().toLowerCase().contains(timKiemStr))
					arr_result.add(x);
			}
			break;
		case 4:
			for(DTO_NhaCungCap x: arr)
			{
				if(x.getDiachi().toLowerCase().contains(timKiemStr))
					arr_result.add(x);
			}
			break;
		}
		
		return arr_result;
	}
	
}
