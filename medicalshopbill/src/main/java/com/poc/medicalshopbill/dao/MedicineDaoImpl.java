package com.poc.medicalshopbill.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poc.medicalshopbill.entity.MediDtl;
import com.poc.medicalshopbill.entity.ShopDetails;

@Repository
public class MedicineDaoImpl implements MedicineDao{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public ShopDetails getShopDtlById() {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForObject("select * from shop_dtl_tbl where shop_id=?", new Object[] {
	            1
	        },
	        new BeanPropertyRowMapper < ShopDetails > (ShopDetails.class));
	}

	@Override
	public int[] saveMedi(List<MediDtl> dtl) {
		// TODO Auto-generated method stub
		/*return jdbcTemplate.update(
                "insert into medi_dtl_tbl (id,medicine_name, batch_no, expire_date, price) values(MEDI_DTL_SEQ.nextval,?,?,?,?)",
                dtl.getMedicineName(), dtl.getBatchNo() , dtl.getExpireDate() ,dtl.getPrice());*/
		 return this.jdbcTemplate.batchUpdate(
					"insert into medi_dtl_tbl (id,medicine_name, batch_no, expire_date, price) values(MEDI_DTL_SEQ.nextval,?,?,?,?)",
					new BatchPreparedStatementSetter() {

						public void setValues(PreparedStatement ps, int i) throws SQLException {
							ps.setString(1, dtl.get(i).getMedicineName());
							ps.setString(2, dtl.get(i).getBatchNo());
							ps.setString(3, dtl.get(i).getExpireDate());
							ps.setDouble(4, dtl.get(i).getPrice());
						}

						public int getBatchSize() {
							return dtl.size();
						}

					});
	}

	@Override
	public List<MediDtl> getAllMedi() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from medi_dtl_tbl", new BeanPropertyRowMapper < MediDtl > (MediDtl.class));
	}

	@Override
	public MediDtl getMediById(int id) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForObject("select * from medi_dtl_tbl where id=?", new Object[] {
		            id
		        },
		        new BeanPropertyRowMapper < MediDtl > (MediDtl.class));
	}

}
