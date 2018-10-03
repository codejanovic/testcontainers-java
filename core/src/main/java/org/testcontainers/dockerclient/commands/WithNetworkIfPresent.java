package org.testcontainers.dockerclient.commands;

import com.github.dockerjava.api.command.CreateContainerCmd;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.function.Function;


public class WithNetworkIfPresent implements Function<CreateContainerCmd, CreateContainerCmd> {

    @Override
    public CreateContainerCmd apply( CreateContainerCmd createContainerCmd ) {
        final TestcontainersConfiguration config = TestcontainersConfiguration.getInstance();
        if (config.getDockerNetwork().isPresent()) {
            final String network = config.getDockerNetwork().get();
            createContainerCmd.withNetworkMode(network);
        }
        return createContainerCmd;
    }

}
