package org.testcontainers.dockerclient.commands;

import java.util.function.Function;

import org.testcontainers.utility.TestcontainersConfiguration;

import com.github.dockerjava.api.command.CreateContainerCmd;


public class WithNetworkIfPresent implements Function<CreateContainerCmd, CreateContainerCmd> {

    @Override
    public CreateContainerCmd apply( CreateContainerCmd createContainerCmd ) {
        final TestcontainersConfiguration config = TestcontainersConfiguration.getInstance();
        config.getDockerNetwork().ifPresent(createContainerCmd::withNetworkMode);
        return createContainerCmd;
    }
}
