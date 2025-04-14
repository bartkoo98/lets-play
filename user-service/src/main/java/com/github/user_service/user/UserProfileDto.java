package com.github.user_service.user;

import com.github.user_service.user.entity.City;
import com.github.user_service.user.entity.Sex;
import com.github.user_service.user.entity.UserLanguage;

import java.util.Set;

public class UserProfileDto {
    private Sex sex;
    private Integer age;
    private String avatar;
    private String description;
    private City city;
    private Set<UserLanguage> userLanguages;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<UserLanguage> getUserLanguages() {
        return userLanguages;
    }

    public void setUserLanguages(Set<UserLanguage> userLanguages) {
        this.userLanguages = userLanguages;
    }
}
