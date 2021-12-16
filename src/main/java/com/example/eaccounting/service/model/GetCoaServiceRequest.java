package com.example.eaccounting.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:26 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCoaServiceRequest {
    private String id;
}
