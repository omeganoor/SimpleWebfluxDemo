package com.demo.webflux.libraries;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

@Component
public class GlobalHeaderOperationCustomizer implements OperationCustomizer {

  @Override
  public Operation customize(Operation operation, HandlerMethod handlerMethod) {
    List<Parameter> parameterList = Objects.nonNull(operation.getParameters())
        ? operation.getParameters() : new ArrayList<>();

    parameterList.add(new Parameter()
        .in(ParameterIn.HEADER.toString())
        .name("username").required(true).example("username"));
    operation.setParameters(parameterList);
    return operation;
  }
}
