package com.kumar.AccountMicroservices.Dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold Error response information"
)
public class ErrorResponseDto {

    @Schema(

            description = "Api path invoked by client"
    )
    private String apiPath;

    @Schema(

            description = "Error code for the error happened"
    )
    private HttpStatus errorCode;

    @Schema(

            description = "Time when error happened"
    )
    private LocalDateTime errorTime;

    @Schema(

            description = "Message representing Error happened"
    )
    private String errorMessage;

    public ErrorResponseDto(String description, HttpStatus httpStatus, String message, LocalDateTime now) {
        this.apiPath = description;
        this.errorCode = httpStatus;
        this.errorMessage = message;
        this.errorTime = now;
    }



    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(LocalDateTime errorTime) {
        this.errorTime = errorTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
