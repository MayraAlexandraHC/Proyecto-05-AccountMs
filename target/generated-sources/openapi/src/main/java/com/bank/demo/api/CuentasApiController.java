package com.bank.demo.api;

import com.bank.demo.model.CuentaRequest;
import com.bank.demo.model.CuentaResponse;
import com.bank.demo.model.ErrorResponse;
import com.bank.demo.model.TransaccionRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T08:10:11.580573300-05:00[America/Lima]", comments = "Generator version: 7.10.0")
@Controller
@RequestMapping("${openapi.accountManagement.base-path:}")
public class CuentasApiController implements CuentasApi {

    private final CuentasApiDelegate delegate;

    public CuentasApiController(@Autowired(required = false) CuentasApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CuentasApiDelegate() {});
    }

    @Override
    public CuentasApiDelegate getDelegate() {
        return delegate;
    }

}
