package com.mvvalentin.hexagonal.adapters.in.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Objetivo dessa classe: Todas as excpetions  serão interceptadas e vou lançar o erro com este formato

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private Long timestamp;
    private Integer status; // código do http status
    private String message; // msg do erro
    private String path; // path aonde ocorrer o erro

}
