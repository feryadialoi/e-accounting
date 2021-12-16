package com.example.eaccounting.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:54 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCoaControllerRequest {
    private String id;
}
