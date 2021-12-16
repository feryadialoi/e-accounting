package com.example.eaccounting.service;

import com.example.eaccounting.entity.Coa;
import com.example.eaccounting.repository.CoaRepository;
import com.example.eaccounting.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 12/16/2021 12:16 AM
 */
@Service
public class CoaService {

    @Autowired
    private CoaRepository coaRepository;

    public CreateCoaServiceResponse createCoa(CreateCoaServiceRequest serviceRequest) {
        Coa coa = Coa.builder()
                .name(serviceRequest.getName())
                .code(serviceRequest.getCode())
                .normalBalance(serviceRequest.getNormalBalance())
                .build();

        coaRepository.save(coa);

        return CreateCoaServiceResponse.builder()
                .id(coa.getId())
                .name(coa.getName())
                .code(coa.getCode())
                .normalBalance(coa.getNormalBalance())
                .build();
    }

    public GetCoaServiceResponse getCoa(GetCoaServiceRequest serviceRequest) {
        Coa coa = getCoaOrNull(serviceRequest.getId());

        if (coa == null) return null;

        return GetCoaServiceResponse.builder()
                .id(coa.getId())
                .name(coa.getName())
                .code(coa.getCode())
                .normalBalance(coa.getNormalBalance())
                .build();
    }

    public UpdateCoaServiceResponse updateCoa(UpdateCoaServiceRequest serviceRequest) {
        Coa coa = getCoaOrNull(serviceRequest.getId());

        if (coa == null) return null;

        coa.setName(serviceRequest.getName());
        coa.setCode(serviceRequest.getCode());
        coa.setNormalBalance(serviceRequest.getNormalBalance());

        coaRepository.save(coa);

        return UpdateCoaServiceResponse.builder()
                .id(coa.getId())
                .name(coa.getName())
                .code(coa.getCode())
                .normalBalance(coa.getNormalBalance())
                .build();
    }

    public DeleteCoaServiceResponse deleteCoa(DeleteCoaServiceRequest serviceRequest) {
        Coa coa = getCoaOrNull(serviceRequest.getId());

        if (coa == null) return null;

        coaRepository.delete(coa);

        return DeleteCoaServiceResponse.builder()
                .id(coa.getId())
                .build();
    }

    private Coa getCoaOrNull(String coaId) {
        Optional<Coa> optionalCoa = coaRepository.findById(coaId);

        if (optionalCoa.isEmpty()) return null;

        return optionalCoa.get();
    }

    public List<GetListCoaServiceResponse> getListCoa(GetListCoaServiceRequest serviceRequest) {
        List<Coa> coas = coaRepository.findAll();

        return coas.stream().map(coa -> GetListCoaServiceResponse.builder()
                .id(coa.getId())
                .name(coa.getName())
                .code(coa.getCode())
                .normalBalance(coa.getNormalBalance())
                .build()
        ).collect(Collectors.toList());
    }
}
