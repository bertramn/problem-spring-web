package org.zalando.problem.spring.web.advice.network;

import net.jodah.failsafe.CircuitBreakerOpenException;
import org.apiguardian.api.API;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.AdviceTrait;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;
import static org.apiguardian.api.API.Status.INTERNAL;

@API(status = EXPERIMENTAL)
public interface CircuitBreakerOpenAdviceTrait extends AdviceTrait {

    @API(status = INTERNAL)
    @ExceptionHandler
    default ResponseEntity<Problem> handleCircuitBreakerOpen(
            final CircuitBreakerOpenException exception,
            final NativeWebRequest request) {
        return create(Status.SERVICE_UNAVAILABLE, exception, request);
    }

}
