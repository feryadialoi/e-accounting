package com.example.eaccounting.controller.model;

import com.example.eaccounting.entity.enums.NormalBalance;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:58 AM
 */
@Data
public class CreateCoaControllerRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotNull
    private NormalBalance normalBalance;
}
