package com.moadd.sendimagetoserver;

import android.graphics.Bitmap;

/**
 * Created by moadd on 21-Sep-17.
 */

public class ItemForm1 {

    private String userRoleId;

    public String getUserRoleId() {
        return userRoleId;
    }
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    private Double price;
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }private String madeIn;
    private Bitmap image;

    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }
    private String itemBarcode;
    private String itemName;
    private String itemSize;
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    private String itemIngredients;
    private String itemGruop;
    private String expiryDateStatus;

    public String getExpiryDateStatus() {
        return expiryDateStatus;
    }
    public void setExpiryDateStatus(String expiryDateStatus) {
        this.expiryDateStatus = expiryDateStatus;
    }
    public String getItemGruop() {
        return itemGruop;
    }
    public void setItemGruop(String itemGruop) {
        this.itemGruop = itemGruop;
    }
    public String getItemBarcode() {
        return itemBarcode;
    }
    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemSize() {
        return itemSize;
    }
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }
    public String getItemIngredients() {
        return itemIngredients;
    }
    public void setItemIngredients(String itemIngredients) {
        this.itemIngredients = itemIngredients;
    }
    public String getMadeIn() {
        return madeIn;
    }
    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

}