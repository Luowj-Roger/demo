package com.hnisi.roger.refugescene.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 *  避难场所实体类
 *
 * @author Roger
 * @since 2020/9/30
 */
@Entity
@Table(name = "b_wz_bhcs")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RefugeScene implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private String id;


    /**
     * 场所编号
     */
    @Column(name = "csbh")
    private String csbh;


    /**
     * 场所品名
     */
    @Column(name = "cspm")
    private String cspm;


    /**
     * 场所类型
     */
    @Column(name = "cslx")
    private String cslx;


    /**
     * 场所等级
     */
    @Column(name = "csdj")
    private String csdj;


    /**
     * 建设日期
     */
    @Column(name = "jsrq")
    private java.util.Date jsrq;


    /**
     * 服务半径（米）
     *//*
    @Column(name = "fwbj")
    private java.math.BigDecimal fwbj;


    *//**
     * 容纳人数（万人）
     *//*
    @Column(name = "rnrs")
    private java.math.BigDecimal rnrs;


    *//**
     * 有效面积（公顷）
     *//*
    @Column(name = "yxmj")
    private java.math.BigDecimal yxmj;*/


    /**
     * 联系电话
     */
    @Column(name = "lxrbgdh")
    private String lxrbgdh;


    /**
     * 地理位置坐标
     */
    @Column(name = "dlwzzb")
    private String dlwzzb;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private String longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private String latitude;

    /**
     * 天地图坐标
     */
    @Column(name = "tdtzb")
    private String tdtzb;

    /**
     * 粤政图坐标
     */
    @Column(name = "yztzb")
    private String yztzb;


    /**
     * 所在区域
     */
    @Column(name = "szqy")
    private String szqy;

    /**
     * 所在区域_中文
     */
    @Column(name = "szqy_detail")
    private String szqy_detail;

    /**
     * 所在区县
     */
    @Column(name = "szqx")
    private String szqx;

    /**
     * 所在区县_中文
     */
    @Column(name = "szqx_detail")
    private String szqx_detail;


    /**
     * 详细地址
     */
    @Column(name = "xxdz")
    private String xxdz;


    /**
     * 介绍
     */
    @Column(name = "js")
    private String js;


    /**
     * 状态，0：无效，1：有效
     */
    @Column(name = "zt")
    private String zt;


    /**
     * 图片
     */
    @Column(name = "tp")
    private String tp;


    /**
     * 创建人id
     */
    /*@Column(name = "creator_id")
    private String creatorId;


    *//**
     * 创建人姓名
     *//*
    @Column(name = "creator_name")
    private String creatorName;


    *//**
     * 创建人组织机构id
     *//*
    @Column(name = "creator_orgid")
    private String creatorOrgid;


    *//**
     * 创建人组织机构名称
     *//*
    @Column(name = "creator_orgname")
    private String creatorOrgname;


    *//**
     * 创建时间
     *//*
    @Column(name = "create_time")
    private java.util.Date createTime;


    *//**
     * 最后修改人id
     *//*
    @Column(name = "updater_id")
    private String updaterId;


    *//**
     * 最后修改人姓名
     *//*
    @Column(name = "updater_name")
    private String updaterName;


    *//**
     * 最后修改人组织机构id
     *//*
    @Column(name = "updater_orgid")
    private String updaterOrgid;


    *//**
     * 最后修改人组织机构名称
     *//*
    @Column(name = "updater_orgname")
    private String updaterOrgname;


    *//**
     * 最后修改时间
     *//*
    @Column(name = "update_time")
    private java.util.Date updateTime;


    *//**
     * 删除标志，0否；1是
     *//*
    @Column(name = "delete_flag")
    private String deleteFlag;


    *//**
     * 删除人id
     *//*
    @Column(name = "deleter_id")
    private String deleterId;


    *//**
     * 删除人姓名
     *//*
    @Column(name = "deleter_name")
    private String deleterName;


    *//**
     * 删除人组织机构id
     *//*
    @Column(name = "deleter_orgid")
    private String deleterOrgid;


    *//**
     * 删除人组织机构名称
     *//*
    @Column(name = "deleter_orgname")
    private String deleterOrgname;


    *//**
     * 删除时间
     *//*
    @Column(name = "delete_time")
    private java.util.Date deleteTime;*/

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param csbh the csbh to set
     */
    public void setCsbh(String csbh) {
        this.csbh = csbh;
    }

    /**
     * @return the csbh
     */
    public String getCsbh() {
        return this.csbh;
    }

    /**
     * @param cspm the cspm to set
     */
    public void setCspm(String cspm) {
        this.cspm = cspm;
    }

    /**
     * @return the cspm
     */
    public String getCspm() {
        return this.cspm;
    }

    /**
     * @param cslx the cslx to set
     */
    public void setCslx(String cslx) {
        this.cslx = cslx;
    }

    /**
     * @return the cslx
     */
    public String getCslx() {
        return this.cslx;
    }

    /**
     * @param csdj the csdj to set
     */
    public void setCsdj(String csdj) {
        this.csdj = csdj;
    }

    /**
     * @return the csdj
     */
    public String getCsdj() {
        return this.csdj;
    }

    /**
     * @param jsrq the jsrq to set
     */
    public void setJsrq(java.util.Date jsrq) {
        this.jsrq = jsrq;
    }

    /**
     * @return the jsrq
     */
    public java.util.Date getJsrq() {
        return this.jsrq;
    }

    /**
     * @param fwbj the fwbj to set
     */
    /*public void setFwbj(java.math.BigDecimal fwbj) {
        this.fwbj = fwbj;
    }

    *//**
     * @return the fwbj
     *//*
    public java.math.BigDecimal getFwbj() {
        return this.fwbj;
    }

    *//**
     * @param rnrs the rnrs to set
     *//*
    public void setRnrs(java.math.BigDecimal rnrs) {
        this.rnrs = rnrs;
    }

    *//**
     * @return the rnrs
     *//*
    public java.math.BigDecimal getRnrs() {
        return this.rnrs;
    }

    *//**
     * @param yxmj the yxmj to set
     *//*
    public void setYxmj(java.math.BigDecimal yxmj) {
        this.yxmj = yxmj;
    }

    *//**
     * @return the yxmj
     *//*
    public java.math.BigDecimal getYxmj() {
        return this.yxmj;
    }*/

    /**
     * @param lxdh the lxrbgdh to set
     */
    public void setLxrbgdh(String lxdh) {
        this.lxrbgdh = lxrbgdh;
    }

    /**
     * @return the lxrbgdh
     */
    public String getLxrbgdh() {
        return this.lxrbgdh;
    }

    /**
     * @param dlwzzb the dlwzzb to set
     */
    public void setDlwzzb(String dlwzzb) {
        this.dlwzzb = dlwzzb;
    }

    /**
     * @return the dlwzzb
     */
    public String getDlwzzb() {
        return this.dlwzzb;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTdtzb() {
        return tdtzb;
    }

    public void setTdtzb(String tdtzb) {
        this.tdtzb = tdtzb;
    }

    public String getYztzb() {
        return yztzb;
    }

    public void setYztzb(String yztzb) {
        this.yztzb = yztzb;
    }

    /**
     * @param szqy the szqy to set
     */
    public void setSzqy(String szqy) {
        this.szqy = szqy;
    }

    /**
     * @return the szqy
     */
    public String getSzqy() {
        return this.szqy;
    }

    /**
     * @param szqy_detail the szqy_detail to set
     */
    public void setSzqy_detail(String szqy_detail) {
        this.szqy_detail = szqy_detail;
    }

    /**
     * @return the szqy_detail
     */
    public String getSzqy_detail() {
        return this.szqy_detail;
    }

    /**
     * @param szqx the szqx to set
     */
    public void setSzqx(String szqx) {
        this.szqx = szqx;
    }

    /**
     * @return the szqx
     */
    public String getSzqx() {
        return this.szqx;
    }

    /**
     * @param szqx_detail the szqx_detail to set
     */
    public void setSzqx_detail(String szqx_detail) {
        this.szqx_detail = szqx_detail;
    }

    /**
     * @return the szqx_detail
     */
    public String getSzqx_detail() {
        return this.szqx_detail;
    }

    /**
     * @param xxdz the xxdz to set
     */
    public void setXxdz(String xxdz) {
        this.xxdz = xxdz;
    }

    /**
     * @return the xxdz
     */
    public String getXxdz() {
        return this.xxdz;
    }

    /**
     * @param js the js to set
     */
    public void setJs(String js) {
        this.js = js;
    }

    /**
     * @return the js
     */
    public String getJs() {
        return this.js;
    }

    /**
     * @param zt the zt to set
     */
    public void setZt(String zt) {
        this.zt = zt;
    }

    /**
     * @return the zt
     */
    public String getZt() {
        return this.zt;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(String tp) {
        this.tp = tp;
    }

    /**
     * @return the tp
     */
    public String getTp() {
        return this.tp;
    }

    /**
     * @param creatorId the creatorId to set
     */
    /*public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    *//**
     * @return the creatorId
     *//*
    public String getCreatorId() {
        return this.creatorId;
    }

    *//**
     * @param creatorName the creatorName to set
     *//*
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    *//**
     * @return the creatorName
     *//*
    public String getCreatorName() {
        return this.creatorName;
    }

    *//**
     * @param creatorOrgid the creatorOrgid to set
     *//*
    public void setCreatorOrgid(String creatorOrgid) {
        this.creatorOrgid = creatorOrgid;
    }

    *//**
     * @return the creatorOrgid
     *//*
    public String getCreatorOrgid() {
        return this.creatorOrgid;
    }

    *//**
     * @param creatorOrgname the creatorOrgname to set
     *//*
    public void setCreatorOrgname(String creatorOrgname) {
        this.creatorOrgname = creatorOrgname;
    }

    *//**
     * @return the creatorOrgname
     *//*
    public String getCreatorOrgname() {
        return this.creatorOrgname;
    }

    *//**
     * @param createTime the createTime to set
     *//*
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    *//**
     * @return the createTime
     *//*
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    *//**
     * @param updaterId the updaterId to set
     *//*
    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    *//**
     * @return the updaterId
     *//*
    public String getUpdaterId() {
        return this.updaterId;
    }

    *//**
     * @param updaterName the updaterName to set
     *//*
    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    *//**
     * @return the updaterName
     *//*
    public String getUpdaterName() {
        return this.updaterName;
    }

    *//**
     * @param updaterOrgid the updaterOrgid to set
     *//*
    public void setUpdaterOrgid(String updaterOrgid) {
        this.updaterOrgid = updaterOrgid;
    }

    *//**
     * @return the updaterOrgid
     *//*
    public String getUpdaterOrgid() {
        return this.updaterOrgid;
    }

    *//**
     * @param updaterOrgname the updaterOrgname to set
     *//*
    public void setUpdaterOrgname(String updaterOrgname) {
        this.updaterOrgname = updaterOrgname;
    }

    *//**
     * @return the updaterOrgname
     *//*
    public String getUpdaterOrgname() {
        return this.updaterOrgname;
    }

    *//**
     * @param updateTime the updateTime to set
     *//*
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    *//**
     * @return the updateTime
     *//*
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    *//**
     * @param deleteFlag the deleteFlag to set
     *//*
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    *//**
     * @return the deleteFlag
     *//*
    public String getDeleteFlag() {
        return this.deleteFlag;
    }

    *//**
     * @param deleterId the deleterId to set
     *//*
    public void setDeleterId(String deleterId) {
        this.deleterId = deleterId;
    }

    *//**
     * @return the deleterId
     *//*
    public String getDeleterId() {
        return this.deleterId;
    }

    *//**
     * @param deleterName the deleterName to set
     *//*
    public void setDeleterName(String deleterName) {
        this.deleterName = deleterName;
    }

    *//**
     * @return the deleterName
     *//*
    public String getDeleterName() {
        return this.deleterName;
    }

    *//**
     * @param deleterOrgid the deleterOrgid to set
     *//*
    public void setDeleterOrgid(String deleterOrgid) {
        this.deleterOrgid = deleterOrgid;
    }

    *//**
     * @return the deleterOrgid
     *//*
    public String getDeleterOrgid() {
        return this.deleterOrgid;
    }

    *//**
     * @param deleterOrgname the deleterOrgname to set
     *//*
    public void setDeleterOrgname(String deleterOrgname) {
        this.deleterOrgname = deleterOrgname;
    }

    *//**
     * @return the deleterOrgname
     *//*
    public String getDeleterOrgname() {
        return this.deleterOrgname;
    }

    *//**
     * @param deleteTime the deleteTime to set
     *//*
    public void setDeleteTime(java.util.Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    *//**
     * @return the deleteTime
     *//*
    public java.util.Date getDeleteTime() {
        return this.deleteTime;
    }*/

}
