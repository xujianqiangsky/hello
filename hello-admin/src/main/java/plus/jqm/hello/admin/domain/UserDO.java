package plus.jqm.hello.admin.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * User 数据对象
 *
 * @author xjq
 * @date 2024/04/16
 */
public class UserDO {
    private Long id;
    private String username;
    private String nickname;
    /**
     * 性别：0 男 1 女 2 未知
     */
    private Integer gender;
    private String password;
    private String email;
    private String phoneNumber;
    private String avatar;
    /**
     * 账号状态：0 正常 1 停用
     */
    private Integer status;
    private String loginIP;
    private LocalDateTime loginTime;
    private String createdBy;
    private LocalDateTime createdTime;
    private String updatedBy;
    private LocalDateTime updatedTime;
    /**
     * 逻辑删除：0 未删除 1 已删除
     */
    private Integer deleted;
    private String remark;

    public UserDO() {}

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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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
        UserDO userDO = (UserDO) o;
        return Objects.equals(id, userDO.id) && Objects.equals(username, userDO.username) && Objects.equals(nickname, userDO.nickname) && Objects.equals(gender, userDO.gender) && Objects.equals(password, userDO.password) && Objects.equals(email, userDO.email) && Objects.equals(phoneNumber, userDO.phoneNumber) && Objects.equals(avatar, userDO.avatar) && Objects.equals(status, userDO.status) && Objects.equals(loginIP, userDO.loginIP) && Objects.equals(loginTime, userDO.loginTime) && Objects.equals(createdBy, userDO.createdBy) && Objects.equals(createdTime, userDO.createdTime) && Objects.equals(updatedBy, userDO.updatedBy) && Objects.equals(updatedTime, userDO.updatedTime) && Objects.equals(deleted, userDO.deleted) && Objects.equals(remark, userDO.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, nickname, gender, password, email, phoneNumber, avatar, status, loginIP, loginTime, createdBy, createdTime, updatedBy, updatedTime, deleted, remark);
    }

    @Override
    public String toString() {
        return "UserDO{" +
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
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", deleted=" + deleted +
                ", remark='" + remark + '\'' +
                '}';
    }
}
