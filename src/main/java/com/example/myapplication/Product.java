package com.example.myapplication;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Product {
	BigInteger id;
	String code;
	String name;

	int lotSize;
	String lotUnit;

	BigDecimal weight;
	String weightUnit;
	BigDecimal width;
	BigDecimal height;
	BigDecimal depth;
	String dimensionsUnit;
	BigDecimal volume;
	String volumeUnit;

	Date update;
	Date created;
	String strProp1;
	String strProp2;
	String strProp3;
	String strProp4;
	String strProp5;
	String strProp6;
	String strProp7;
	String strProp8;
	
	public Product(BigInteger id) {
		this.id = id;
	}

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLotSize() {
		return lotSize;
	}
	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}
	public String getLotUnit() {
		return lotUnit;
	}
	public void setLotUnit(String lotUnit) {
		this.lotUnit = lotUnit;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getDepth() {
		return depth;
	}
	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}
	public String getDimensionsUnit() {
		return dimensionsUnit;
	}
	public void setDimensionsUnit(String dimensionsUnit) {
		this.dimensionsUnit = dimensionsUnit;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public String getVolumeUnit() {
		return volumeUnit;
	}
	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getStrProp1() {
		return strProp1;
	}
	public void setStrProp1(String strProp1) {
		this.strProp1 = strProp1;
	}
	public String getStrProp2() {
		return strProp2;
	}
	public void setStrProp2(String strProp2) {
		this.strProp2 = strProp2;
	}
	public String getStrProp3() {
		return strProp3;
	}
	public void setStrProp3(String strProp3) {
		this.strProp3 = strProp3;
	}
	public String getStrProp4() {
		return strProp4;
	}
	public void setStrProp4(String strProp4) {
		this.strProp4 = strProp4;
	}
	public String getStrProp5() {
		return strProp5;
	}
	public void setStrProp5(String strProp5) {
		this.strProp5 = strProp5;
	}
	public String getStrProp6() {
		return strProp6;
	}
	public void setStrProp6(String strProp6) {
		this.strProp6 = strProp6;
	}
	public String getStrProp7() {
		return strProp7;
	}
	public void setStrProp7(String strProp7) {
		this.strProp7 = strProp7;
	}
	public String getStrProp8() {
		return strProp8;
	}
	public void setStrProp8(String strProp8) {
		this.strProp8 = strProp8;
	}
}
