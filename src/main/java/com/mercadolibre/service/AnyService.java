package com.mercadolibre.service;

import com.mercadolibre.dto.AnyDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnyService {

    private List<AnyDTO> anyDTOList;

    public AnyService() {
        this.anyDTOList = new ArrayList<>();
    }

    public void postMethod(AnyDTO anyDTO) {
        anyDTO.setProcessed(Boolean.TRUE);
        anyDTO.setName("DTO POST");
        anyDTOList.add(anyDTO);
    }

    public AnyDTO getMethod(Long id) {
        return Objects.requireNonNull(
                anyDTOList.stream().filter(
                        anyDTO -> anyDTO.getId().equals(id)
                ).findFirst().orElse(null)
        );
    }

    public void putMethod(AnyDTO anyDTO, Long id) {
        AnyDTO anyDTOToUpdate = getMethod(id);
        anyDTO.setName("DTO PUT");
        anyDTOToUpdate.setName(anyDTO.getName());
    }

    public boolean deleteMethod(Long id) {
        return anyDTOList.removeIf(anyDTO -> anyDTO.getId().equals(id));
    }

}
