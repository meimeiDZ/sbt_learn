package com.mmdz.repository;

import com.mmdz.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: MMDZ
 * @Date: 2021/5/21
 * @Desc:
 */
public interface CityRepository extends JpaRepository<City,Integer> {
}
