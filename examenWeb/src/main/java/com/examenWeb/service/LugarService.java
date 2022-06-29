/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenWeb.service;

import com.examenWeb.entity.Lugar;
import com.examenWeb.repository.LugarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LugarService implements ILugarService {

    @Autowired
    private LugarRepository LugarRepository;

    @Override
    public List<Lugar> LugarProvince() {
        return (List<Lugar>) LugarRepository.findAll();
    }
}
