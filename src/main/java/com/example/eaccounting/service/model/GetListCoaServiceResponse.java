package com.example.eaccounting.service.model;

import com.example.eaccounting.entity.enums.NormalBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:28 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetListCoaServiceResponse {
    private String id;
    private String name;
    private String code;
    private NormalBalance normalBalance;
}