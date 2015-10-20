package io.probedock.rt.arquillian;

import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.test.spi.execution.TestExecutionDecider;

/**
 * Define the mounting point for the Probe Dock RT extension of Arquillian.
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
public class ProbeDockRTArquillianExtension implements LoadableExtension {
	@Override
	public void register(ExtensionBuilder builder) {
		builder.service(TestExecutionDecider.class, ProbeDockRTTestExecutionDecider.class);
	}
}
