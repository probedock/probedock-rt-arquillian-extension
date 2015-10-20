package io.probedock.rt.arquillian;

import io.probedock.client.core.filters.FilterUtils;
import io.probedock.rt.client.Filter;
import java.lang.reflect.Method;
import org.jboss.arquillian.test.spi.execution.ExecutionDecision;
import org.jboss.arquillian.test.spi.execution.TestExecutionDecider;

/**
 * Implement the logic to filter the test during the execution. The implementation
 * is based of the {@link Filter}.
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
public class ProbeDockRTTestExecutionDecider implements TestExecutionDecider {
	/**
	 * Get the filters only once for all the run
	 */
	private static final Filter filter = new Filter();
	
	@Override
	public ExecutionDecision decide(Method method) {
		// Decide if the test should or should not run
		if (FilterUtils.isRunnable(method.getDeclaringClass(), method, filter.getFilters())) {
			return ExecutionDecision.execute();
		}
		else {
			return ExecutionDecision.dontExecute("Does not match the filters defined.");
		}
	}

	@Override
	public int precedence() {
		return Integer.MAX_VALUE;
	}
}
