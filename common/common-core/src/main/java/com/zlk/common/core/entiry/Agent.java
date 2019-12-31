package com.zlk.common.core.entiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Agent implements Serializable {

    @Id
    private String id;//	否	是	string	uuid，唯一标识
    private String name;//	否	否	string	代理商名称
    private String remark;//	否	否	string	代理商简介
    private Integer agentLevel;//	否	否	int	代理商级别（0总代，1一级，2二级）
    private Double fee;//	否	否	long	代理商当前余额（单位为分）
    private String licenseId;//	可	否	string	uuid，许可证表唯一标识，只有总代理（agent_level为0）才填写此字段
    private String licenseName;//	否	否	string	许可证名称
    private String roleId;//	否	否	string	uuid，角色表唯一标识
    private String weixinOpenid;//	可	否	string	微信绑定openid
    private Integer type;//	否	否	int	代理商类型（1个人，2企业）
    @JsonProperty(value = "pphone")
    private String pPhone;//	可	否	string	个人手机号
    private Integer sex;//	可	否	int	性别（1男0女）
    private String pRealname;//	可	否	string	真实姓名
    private String pIdCard;//	可	否	string	身份证号
    private String pPic1;//	可	否	string	身份证正面照片
    private String pPic2;//	可	否	string	身份证反面照片
    private String pAddress;//	可	否	string	个人地址
    private String companyPhone;//	可	否	string	企业联系人手机号
    private String companyContact;//	可	否	string	企业联系人姓名
    private String companyName;//	可	否	string	公司名称
    private String companyRemark;//	可	否	string	公司简介
    private String companyTaxnumber;//	可	否	string	公司纳税人识别号
    private String companyPic;//	可	否	string	公司营业执照照片
    private String companyAddress;//	可	否	string	公司联系地址
    private Integer status;//	否	否	int	代理状态（1有效，0失效）
    private String reason;//	可	否	string	失效原因
    private Date invalidTime;//	可	否	datatime	失效时间
    private Integer operateType;//	否	否	int	操作人类型（1平台，2代理）
    private String operateId;//	否	否	string	操作人id
    private String operateName;//	否	否	string	操作人员名称
    private float dividePercent; // 分给上一级的比例
    private Date updateTime;//	可	否	datetime	数据修改时间
    private Date createTime;//	否	否	datetime	数据创建时间
    private Integer casqueCount; // 总代理头盔绑定数量
    private Integer divideMode;// 分账方式
    private String pushId; // 极光推送 id
    private Integer isSuper;// 是否超级代理商，1是，0否
}
