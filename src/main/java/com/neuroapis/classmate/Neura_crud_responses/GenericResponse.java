package com.neuroapis.classmate.Neura_crud_responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@Service
public class GenericResponse
{

    private String requestResponse;
    public GenericResponse(String requestResponse)
    {
        this.setRequestResponse(requestResponse);
    }
}
