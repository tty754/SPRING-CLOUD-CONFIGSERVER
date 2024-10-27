package com.kumar.AccountMicroservices.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto {

    @Schema(

            description = "Status code for Response",example = "200"
    )
    private String statusCode;

    @Schema(

            description = "Status message for Response",example = "Response sent Successfully"
    )
    private String statusMsg;

    public ResponseDto(String status201, String message201) {
        this.statusCode = status201;
        this.statusMsg = message201;
    }

}
