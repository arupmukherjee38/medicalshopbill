package com.poc.medicalshopbill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shop_dtl_tbl")
public class ShopDetails {
//(shop_name,shop_add,shop_phn,shop_email)
	
	@Id
	@Column(columnDefinition = "number default 1")
	private int shopId;
	
	@Column(columnDefinition = "varchar2(255) default 'Amar Dokan'")
	private String shopName;
	@Column(columnDefinition = "varchar2(255) default '420 DumDum'")
	private String shopAdd;
	@Column(columnDefinition = "varchar2(255) default '9081952782'")
	private String shopPhone;
	@Column(columnDefinition = "varchar2(255) default 'babal@mail.com'")
	private String shopEmail;
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAdd() {
		return shopAdd;
	}
	public void setShopAdd(String shopAdd) {
		this.shopAdd = shopAdd;
	}
	public String getShopPhone() {
		return shopPhone;
	}
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	public String getShopEmail() {
		return shopEmail;
	}
	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}
	@Override
	public String toString() {
		return "ShopDetails [shopName=" + shopName + ", shopAdd=" + shopAdd + ", shopPhone=" + shopPhone
				+ ", shopEmail=" + shopEmail + "]";
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	public int getShopId() {
		return shopId;
	}
	
	
	
	
}
