package com.kumar.LoanMicroservices.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Data

public class ResponseDto {

    @Schema(
            description = "Status code in the response"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;


    public ResponseDto(String status200, String message200) {
        this.statusCode=status200;
        this.statusMsg=message200;
    }
}
