package com.example.eaccounting.controller;

import com.example.eaccounting.controller.model.CreateCoaControllerRequest;
import com.example.eaccounting.controller.model.CreateCoaControllerResponse;
import com.example.eaccounting.controller.model.GetCoaControllerRequest;
import com.example.eaccounting.controller.model.GetCoaControllerResponse;
import com.example.eaccounting.service.CoaService;
import com.example.eaccounting.service.model.CreateCoaServiceRequest;
import com.example.eaccounting.service.model.CreateCoaServiceResponse;
import com.example.eaccounting.service.model.GetCoaServiceRequest;
import com.example.eaccounting.service.model.GetCoaServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:52 AM
 */
@Slf4j
@RestController
@RequestMapping("/coas")
public class CoaController {

    @Autowired
    private CoaService coaService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateCoaControllerResponse createCoa(@Valid @RequestBody CreateCoaControllerRequest controllerRequest) {
        CreateCoaServiceRequest serviceRequest = CreateCoaServiceRequest.builder()
                .name(controllerRequest.getName())
                .code(controllerRequest.getCode())
                .normalBalance(controllerRequest.getNormalBalance())
                .build();

        CreateCoaServiceResponse serviceResponse = coaService.createCoa(serviceRequest);

        return CreateCoaControllerResponse.builder()
                .id(serviceResponse.getId())
                .name(serviceResponse.getName())
                .code(serviceResponse.getCode())
                .normalBalance(serviceResponse.getNormalBalance())
                .build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetCoaControllerResponse getCoa(@PathVariable("id") String id) {
        GetCoaControllerRequest controllerRequest = GetCoaControllerRequest.builder()
                .id(id)
                .build();

        GetCoaServiceRequest serviceRequest = GetCoaServiceRequest.builder()
                .id(controllerRequest.getId())
                .build();

        GetCoaServiceResponse serviceResponse = coaService.getCoa(serviceRequest);

        return GetCoaControllerResponse.builder()
                .id(serviceResponse.getId())
                .name(serviceResponse.getName())
                .code(serviceResponse.getCode())
                .normalBalance(serviceResponse.getNormalBalance())
                .build();
    }
}
