package com.vini.oficina.dto.request;

import jakarta.validation.constraints.NotBlank;

public class OrdemServicoRequestDTO {

    private int id;

    @NotBlank(message = "informa numeroOS")
    private String NumeroOs;

    public String getNumeroOs() {
        return NumeroOs;
    }

    public void setNumeroOs(String numeroOs) {
        NumeroOs = numeroOs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
