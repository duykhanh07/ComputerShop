package BUS;

import java.util.ArrayList;
import java.util.Collections;

import DAO.QuanLyTonKhoDAO;

public class QuanLyTonKhoBUS {
	
	public ArrayList<TonKho> ds_tonkho = new ArrayList<QuanLyTonKhoBUS.TonKho>();
	public ArrayList<TonKho> ds_hienThi;
	
	public QuanLyTonKhoBUS() {
		ArrayList<Object>[] al_tonKho = QuanLyTonKhoDAO.getTonKho();
		for(int i =0; i<al_tonKho[0].size(); i++) {
			TonKho tonKho = new TonKho((String)al_tonKho[0].get(i), (String)al_tonKho[1].get(i), (Integer)al_tonKho[2].get(i));
			ds_tonkho.add(tonKho);
		}
		ds_hienThi = (ArrayList<TonKho>) ds_tonkho.clone();
	}
	
	public void sapXepTonKho(int selectedIndex) {
		switch (selectedIndex) {
			case 1:Collections.sort(ds_hienThi, (o1, o2) -> o1.getTensp().compareToIgnoreCase(o2.getTensp()));break;
			case 2:Collections.sort(ds_hienThi, (o1, o2) -> o2.getTensp().compareToIgnoreCase(o1.getTensp()));break;
			case 3:Collections.sort(ds_hienThi, (o1, o2) -> o1.getSoluongton() - (o2.getSoluongton()));
			case 4:Collections.sort(ds_hienThi, (o1, o2) -> o2.getSoluongton() - (o1.getSoluongton()));
			default:Collections.sort(ds_hienThi, (o1, o2) -> o1.getMasp().compareToIgnoreCase(o2.getMasp()));
		}
	}
	
	public void timKiemTonKho(String timKiemStr, int selectedIndex) {
		ds_hienThi.clear();
		for(int i = 0; i< ds_tonkho.size(); i++) {
			switch(selectedIndex) {
			case 0:
				if(ds_tonkho.get(i).getMasp().toLowerCase().contains(timKiemStr) || ds_tonkho.get(i).getTensp().toLowerCase().contains(timKiemStr)) {
					ds_hienThi.add(ds_tonkho.get(i));
				}
				break;
			case 1:
				if(ds_tonkho.get(i).getMasp().toLowerCase().contains(timKiemStr)) {
					ds_hienThi.add(ds_tonkho.get(i));
				}
				break;
			case 2:
				if(ds_tonkho.get(i).getTensp().toLowerCase().contains(timKiemStr)) {
					ds_hienThi.add(ds_tonkho.get(i));
				}
				break;
			}
		}
	}
	
	public class TonKho {
		String masp;
		String tensp;
		int soluongton;
		
		public TonKho(String masp, String tensp, int soluongton) {
			this.masp = masp;
			this.tensp = tensp;
			this.soluongton = soluongton;
		}
		
		public String getMasp() {
			return masp;
		}

		public String getTensp() {
			return tensp;
		}

		public int getSoluongton() {
			return soluongton;
		}
	}
}
