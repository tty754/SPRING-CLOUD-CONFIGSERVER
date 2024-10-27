package com.kumar.AccountMicroservices.Controller;


import com.kumar.AccountMicroservices.Constant.AccountConstants;
import com.kumar.AccountMicroservices.Dto.AccountContactInfoDto;
import com.kumar.AccountMicroservices.Dto.CustomerDto;
import com.kumar.AccountMicroservices.Dto.ErrorResponseDto;
import com.kumar.AccountMicroservices.Dto.ResponseDto;
import com.kumar.AccountMicroservices.Service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Crud Operations for REST API",
        description = "Crud operations for Create,fetch,update and Delete for Account Microservices "
)

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountControllers {

    @Autowired
    private final IAccountService accountService;

    public AccountControllers(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Value("${build.version}")
    private String buildValue;

    @Autowired
    private AccountContactInfoDto accountContactInfoDto;


    @Operation(
            summary = "Create REST API",
            description = "REST API to create Customer and Accounts inside EasyBank"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus Created"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        accountService.CreateAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));

    }


    @Operation(
            summary = "Fetch REST API",
            description = "REST API to GET Customer and Accounts details from EasyBank"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus Ok"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountsDetails(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be of the pattern ") String mobileNum) {
        CustomerDto customerDto = accountService.fetchAccountDetails(mobileNum);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }


    @Operation(
            summary = "Update REST API",
            description = "REST API to update Customer and Accounts information inside EasyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HttpStatus Required Information updated"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HttpStatus Internal Server Error",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponseDto.class
                            )
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete REST API",
            description = "REST API to Delete Customer and Accounts from EasyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HttpStatus Ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = " HttpStatus Internal Server Error"
            )
    })

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                                                            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be of the pattern ")
                                                            String mobileNumber) {
        boolean isDeleted = accountService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_DELETE));
        }
    }


    @Operation(
            summary = "Get Build Info",
            description = "Get build Info that is deployed in the Account microservices"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HttpStatus Ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = " HttpStatus Internal Server Error",

                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

    @GetMapping("/build-Value")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildValue);
    }

    @Operation(
            summary = "Get Contact Info",
            description = "Get Contact Info that is required into the Cards microservices"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HttpStatus Ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = " HttpStatus Internal Server Error",

                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

    @GetMapping("/contact-info")
    public ResponseEntity<AccountContactInfoDto> getContactDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(accountContactInfoDto);
    }


}
