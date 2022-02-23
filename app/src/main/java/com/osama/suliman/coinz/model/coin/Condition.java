package com.osama.suliman.coinz.model.coin;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    public class Condition {

        @SerializedName("pk_i_id")
        @Expose
        private Integer pkIId;
        @SerializedName("s_code")
        @Expose
        private String sCode;
        @SerializedName("s_name")
        @Expose
        private Object sName;
        @SerializedName("d_value")
        @Expose
        private String dValue;
        @SerializedName("i_type")
        @Expose
        private String iType;
        @SerializedName("s_icon")
        @Expose
        private String sIcon;
        @SerializedName("b_enabled")
        @Expose
        private Boolean bEnabled;
        @SerializedName("dt_created_date")
        @Expose
        private String dtCreatedDate;
        @SerializedName("dt_modified_date")
        @Expose
        private String dtModifiedDate;
        @SerializedName("dt_deleted_date")
        @Expose
        private Object dtDeletedDate;

        public Integer getPkIId() {
            return pkIId;
        }

        public void setPkIId(Integer pkIId) {
            this.pkIId = pkIId;
        }

        public String getsCode() {
            return sCode;
        }

        public void setsCode(String sCode) {
            this.sCode = sCode;
        }

        public Object getsName() {
            return sName;
        }

        public void setsName(Object sName) {
            this.sName = sName;
        }

        public String getdValue() {
            return dValue;
        }

        public void setdValue(String dValue) {
            this.dValue = dValue;
        }

        public String getiType() {
            return iType;
        }

        public void setiType(String iType) {
            this.iType = iType;
        }

        public String getsIcon() {
            return sIcon;
        }

        public void setsIcon(String sIcon) {
            this.sIcon = sIcon;
        }

        public Boolean getbEnabled() {
            return bEnabled;
        }

        public void setbEnabled(Boolean bEnabled) {
            this.bEnabled = bEnabled;
        }

        public String getDtCreatedDate() {
            return dtCreatedDate;
        }

        public void setDtCreatedDate(String dtCreatedDate) {
            this.dtCreatedDate = dtCreatedDate;
        }

        public String getDtModifiedDate() {
            return dtModifiedDate;
        }

        public void setDtModifiedDate(String dtModifiedDate) {
            this.dtModifiedDate = dtModifiedDate;
        }

        public Object getDtDeletedDate() {
            return dtDeletedDate;
        }

        public void setDtDeletedDate(Object dtDeletedDate) {
            this.dtDeletedDate = dtDeletedDate;
        }

    }

