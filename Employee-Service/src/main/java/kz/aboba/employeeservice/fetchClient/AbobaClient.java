package kz.aboba.employeeservice.fetchClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "aboba-service")
public interface AbobaClient {
    @GetMapping("/aboba/{employeeId}")
    String getAboba(@PathVariable int employeeId);
}
