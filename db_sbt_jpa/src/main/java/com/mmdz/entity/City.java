package com.mmdz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: MMDZ
 * @Date: 2021/5/21
 * @Desc:
 */
@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class City {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int cityId;
    private String cityName;
    private String cityIntroduce;

    public City(String cityName, String cityIntroduce) {
        this.cityName = cityName;
        this.cityIntroduce = cityIntroduce;
    }
}
