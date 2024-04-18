package plus.jqm.hello.admin.domain.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * User 展示对象
 *
 * @author xjq
 * @date 2024/04/16
 */
public class UserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 用户 id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别：0 男 1 女 2 未知
     */
    private Integer gender;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 账号状态：0 正常 1 停用
     */
    private Integer status;
    /**
     * 登录 IP
     */
    private String loginIP;
    /**
     * 登录时间
     */
    private LocalDateTime loginTime;
    /**
     * 备注
     */
    private String remark;

    public UserVO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) && Objects.equals(username, userVO.username) && Objects.equals(nickname, userVO.nickname) && Objects.equals(gender, userVO.gender) && Objects.equals(password, userVO.password) && Objects.equals(email, userVO.email) && Objects.equals(phoneNumber, userVO.phoneNumber) && Objects.equals(avatar, userVO.avatar) && Objects.equals(status, userVO.status) && Objects.equals(loginIP, userVO.loginIP) && Objects.equals(loginTime, userVO.loginTime) && Objects.equals(remark, userVO.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, nickname, gender, password, email, phoneNumber, avatar, status, loginIP, loginTime, remark);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status=" + status +
                ", loginIP='" + loginIP + '\'' +
                ", loginTime=" + loginTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
