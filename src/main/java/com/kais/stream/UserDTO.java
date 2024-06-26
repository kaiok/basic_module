package com.kais.stream;

/**
 * @author kais
 * @date 2022.07.01. 15:49
 */
public class UserDTO {

    private Integer id;

    private String userName;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public UserDTO(Integer id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public UserDTO() {
    }
}
