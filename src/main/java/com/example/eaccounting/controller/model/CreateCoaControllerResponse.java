package com.example.eaccounting.controller.model;

import com.example.eaccounting.entity.enums.NormalBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:57 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCoaControllerResponse {
    private String id;
    private String name;
    private String code;
    private NormalBalance normalBalance;
}
