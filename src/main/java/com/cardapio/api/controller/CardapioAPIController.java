/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.api.controller;

import com.cardapio.api.model.CardapioBean;
import com.cardapio.api.repository.CardapioDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/funcionarios")
public class CardapioAPIController {
    @GetMapping("/{id}")
    public CardapioBean lerTodos(@PathVariable int id) {
        return CardapioDAO.lerTodos(id);
}
}
