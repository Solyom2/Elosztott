package hu.me.iit.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "storage-service")
public interface StorageClient {

    @GetMapping("/deliver")
    int deliver();


}
