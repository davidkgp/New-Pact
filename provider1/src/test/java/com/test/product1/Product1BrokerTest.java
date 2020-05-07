package com.test.product1;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
//@PactFolder("C:\\Users\\Win10\\Downloads\\New-Pact-master\\New-Pact-master\\consumer1\\target\\pacts")
@Provider("EcommereceProvider")
@PactBroker//pass this in vm options -Dpactbroker.host=<Brokerhost> -Dpactbroker.protocol=<broker_protocol> -Dpactbroker.auth.scheme=bearer -Dpactbroker.auth.username=<Token>

/*Simply pass what you need with -Dconnectionstring=foobar in the junit command line,
or use the java api for system properties to set this programmatically,
with System.setProperty(String name, String value), and System.getProperty(String name).

In your tests, you can use the @Before or @BeforeClass to set up common objects based on this property, pending on whether you want to run the setup once for each test (in which case you can use class members) or once for each suite (and then use static members).

You can even incorporate this behavior by using an abstract class which all your test cases extends.*/

@VerificationReports(value = { "console", "markdown", "json" })

public class Product1BrokerTest {

	private int PORT = 9080;

	@BeforeClass

	public static void setVersion() {

		// https://github.com/DiUS/pact-jvm/tree/master/provider/pact-jvm-provider-junit#publishing-verification-results-to-a-pact-broker

		System.setProperty("pact.provider.version", "1.0.0");

		System.setProperty("pact.verifier.publishResults", "true");

	}

	@TestTarget

	public final Target target = new HttpTarget("http", "localhost", PORT);

	// private static ConfigurableApplicationContext applicationContext;

//	@BeforeClass
//
//	public static void start() {
//
	// applicationContext = SpringApplication.run(EcommerceApplication.class);
//
//	}

//	@TargetRequestFilter
//
//    public void printTheRequestHeaders(HttpRequest request) {
//
//        Arrays.asList(request.getAllHeaders())
//
//                .forEach(header -> System.out.println(header.getName() + "->" + header.getValue()));

	// }

//	@AfterClass
//
//	public static void stop() {
//
//		SpringApplication.exit(applicationContext);
//
//	}
//	
//	

	@State("HP")

	public void withSomeState() {

		System.out.println("get list of products from HP");

	}
}
