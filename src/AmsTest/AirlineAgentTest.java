package AmsTest;

import Ams.AirlineAgent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AirlineAgentTest {

    @Test
    public void testAirlineAgentNoArgConstructor() {
        AirlineAgent agent = new AirlineAgent();
        Assertions.assertNotNull(agent, "AirlineAgent object should not be null");
    }

    @Test
    public void testAirlineAgentParameterizedConstructor() {
        AirlineAgent agent = new AirlineAgent(
                "A001", "Agent Smith", "smith@airline.com", "topsecret", "EMP999"
        );

        Assertions.assertEquals("A001", agent.getUserId());
        Assertions.assertEquals("Agent Smith", agent.getName());
        Assertions.assertEquals("smith@airline.com", agent.getEmail());
        Assertions.assertEquals("topsecret", agent.getPassword());
        Assertions.assertEquals("EMP999", agent.getEmployeeId());
    }
}
