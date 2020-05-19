package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String cfPort;
    private final String cfMemory;
    private final String cfInstanceIndex;
    private final String cfInstanceAddress;


    public EnvController(@Value("${port:NOT SET}") String cfPort,
                         @Value("${memory.limit:NOT SET}") String cfMemory,
                         @Value("${cf.instance.index:NOT SET}")   String cfInstanceIndex,
                         @Value("${cf.instance.address:NOT SET}") String cfInstanceAddress
                         ) {

        this.cfPort = cfPort;
        this.cfMemory = cfMemory;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }

    

    @GetMapping(value = "/env")
    public Map<String, String> getEnv() {

        Map<String, String> env = new HashMap<>();

        env.put("PORT", cfPort);
        env.put("MEMORY_LIMIT", cfMemory);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddress);

        return env;

    }
}
