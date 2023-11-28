package BUS;

import java.util.ArrayList;
import java.util.Date;

import DAO.HoaDonDAO;
import DTO.DTO_HoaDon;

public class HoaDonBUS {
	HoaDonDAO hoadondao = new HoaDonDAO();
	
	//Trả về mảng hóa đơn lấy từ Database
	public ArrayList <DTO_HoaDon> get_AllHoaDon()
	{
		return hoadondao.get_AllHoaDon();
	}
	
	//Tìm kiếm hóa đơn
	public ArrayList <DTO_HoaDon> timKiemHoaDon(String tiemKiemStr, int selectedIndex, Date fromDate, Date toDate)
	{
		ArrayList <DTO_HoaDon> arr = hoadondao.get_AllHoaDon();
		
		ArrayList <DTO_HoaDon> arr_result = new ArrayList<DTO_HoaDon>();
		
		switch(selectedIndex)
		{
		case 0:
			for(DTO_HoaDon x: arr)
			{
				if(x.getMahd().toLowerCase().contains(tiemKiemStr) && x.getNgaylaphd().compareTo(fromDate)>	0 && x.getNgaylaphd().compareTo(toDate)<0)
					arr_result.add(x);
			}
			break;
		case 1:
			for(DTO_HoaDon x: arr)
			{
				if(x.getMakh().toLowerCase().contains(tiemKiemStr) && x.getNgaylaphd().compareTo(fromDate)>	0 && x.getNgaylaphd().compareTo(toDate)<0)
					arr_result.add(x);
			}
			break;
		case 2:
			for(DTO_HoaDon x: arr)
			{
				if(x.getManv().toLowerCase().contains(tiemKiemStr) && x.getNgaylaphd().compareTo(fromDate)>	0 && x.getNgaylaphd().compareTo(toDate)<0)
					arr_result.add(x);
			}
			break;
		case 3:
			for(DTO_HoaDon x: arr)
			{
				if(x.getDiachigiao().toLowerCase().contains(tiemKiemStr) && x.getNgaylaphd().compareTo(fromDate)>0 && x.getNgaylaphd().compareTo(toDate)<0)
					arr_result.add(x);
			}
			break;
		case 4:
			for(DTO_HoaDon x: arr)
			{
				if(x.getTrangthai().toLowerCase().contains(tiemKiemStr) && x.getNgaylaphd().compareTo(fromDate)>0 && x.getNgaylaphd().compareTo(toDate)<0)
					arr_result.add(x);
			}
			break;
		}
		return arr_result;
	}
	
	//Phương thức cập nhật nhà cung cấp
	public int update_TrangThaiHoaDon(DTO_HoaDon hoadon)
	{
		return hoadondao.update_TrangThaiHoaDon(hoadon);
	}
}
