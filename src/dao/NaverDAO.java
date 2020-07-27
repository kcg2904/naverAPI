package dao;

import java.util.ArrayList;

import dto.NaverDTO;

public interface NaverDAO {
	public void insert(NaverDTO dto);
	
	public ArrayList<NaverDTO> select();
	
}
