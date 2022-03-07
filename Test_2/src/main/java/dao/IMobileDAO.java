package dao;

import java.util.List;

import utils.Mobile;

public interface IMobileDAO {
	public List<Mobile> selectAll(String sql);

	public boolean insert(Mobile e);

	public Mobile findById(int findId);

	public boolean update(Mobile e);

	public boolean delete(int deleteId);
}
